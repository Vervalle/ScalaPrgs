package JavaCourseToScala

import scala.annotation.tailrec
import java.lang.String
import scala.util.matching.Regex

object ConsecutiveCaracters extends App {

  val str = "  11011    00010 10111 01101 "

  // only 0, 1 and whitespace are admitted characters
  if (!str.matches("[01\\s]+")) println("invalid characters")    
    
  // remove all leading or trailing spaces
  val strC: String = str.trim
 
  // split into lines
  val lines = strC.split(" {1,}");
 
  // all lines must have the same size
  val uniqueSize = lines(0).size
  var sized = true
  for (i <-1 to (lines.length -1)) {
    if (lines(i).size != uniqueSize) sized = false
  }
  if (!sized) println(" lines with different sizes")
  
  // count number of max consecutive designed characters
  var m = new Array[Int](lines.length)
  var max: Int = 0
  for ( i<-0 to (lines.length-1)) {
    m(i) = consOne(lines(i), '1')
    if ( m(i) > max ) max = m(i)
  } 

  // display the result
  for ( i<-0 to (lines.length - 1)) {
         if ( m(i) == max) println("line " + i +" with " + m(i))
  }

  
  // ============= functions
   def consOne (x: String, c: Char): Int = {
    def helper (p: Char, xs: String, Acc: Int, Max: Int): Int = {
     	if( xs.isEmpty()) Max+1
     	else {
     		val head = xs first
     		val tail = xs takeRight (xs.length -1)
    		
    		if( head == p && head == c) {
    				if ((Acc+1)>Max)	helper(head, tail, Acc+1, Acc+1)
    				else				helper(head, tail, Acc+1, Max)
    		}	else					helper(head, tail, 0, Max)
     	} // end empty string
    }
    helper (' ', x, 0, 0)
} // end consOne

 // alternative function to the previous one
  @tailrec def maxConsecutive(s: String, c: Char, acc: Int = 0): Int =
		  if (s.isEmpty) acc
		  else {
			  	val first = s.dropWhile(_ != c)
				val current = first.takeWhile(_ == c).size
				val rest = first.dropWhile(_ == c)
				maxConsecutive(rest, c, Math.max(acc, current))
		  }
  
} // end object