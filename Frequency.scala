package JavaCourseToScala

object consecutiveCharacters extends App {

  val str = "110001101"
  println("Max # of consecutive 1 into str = " + consOne(str))
  
  
  def consOne (x: String): Int = {
    def helper (p: String, xs: String, Acc: Int, Max: Int): Int = {
    		val head = xs take 1
    		val tail = xs takeRight (xs.length -1)
    		
    		if( xs.isEmpty()) Max+1
    		else if( head == p && head == "1") {
    					if ((Acc+1)>Max)	helper(head, tail, Acc+1, Acc+1)
    					else				helper(head, tail, Acc+1, Max)
    		}	else	  					helper(head, tail, 0, Max)
    }
    helper (" ", x, 0, 0)
  } // end consOne

}
