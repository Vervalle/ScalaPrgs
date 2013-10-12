package JavaCourseToScala

import scala.annotation.tailrec

object Suite extends App {

	// suite(u) retourne le nb d'itérations nécessaires pour pour que u(n) = 0
	// suite n'est pas recursive terminale car la derniere action dans le corps n'est pas l'appel à la fonction mais 1 + f
	def suite(x: Int): Int = {
		if (x==0) 0 
		else if (x%3 == 0) 1 + suite(x+4)
		else if (x%4 == 0) 1 + suite(x/2)
		else 1 + suite(x-1)
	}
	
	def suite2(x: Int): Int = {
	  @tailrec def helper(x: Int, k: Int): Int = {
		if (x==0) k 
		else if (x%3 == 0) helper(x+4, k+1)
		else if (x%4 == 0) helper(x/2, k+1)
		else helper(x-1, k+1)	    
	  }
	  helper(x, 0)
	}

// =====================================	
	var startTime = System.currentTimeMillis
	for(a <- 5 to 1000){
	 	println(a + " -> " + suite(a)) 
	}
	println("elapsed time non tailrec= " + (System.currentTimeMillis - startTime) + " milliseconds") 

	startTime = System.currentTimeMillis
	for(a <- 5 to 1000){
	 	println(a + " -> " + suite2(a)) 
	}
	println("elapsed time tailrec= " + (System.currentTimeMillis - startTime) + " milliseconds") 
}