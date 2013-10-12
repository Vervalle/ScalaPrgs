package ScalaByEx

import scala.annotation.tailrec

object sort extends App {
 
def sort2(xs: Array[Int]): Array[Int] = {
 if (xs.length <= 1) xs
 else {
	 val pivot = xs(xs.length / 2)
	 Array.concat(sort2(xs filter (pivot >)), xs filter (pivot ==), sort2(xs filter (pivot <)))
 }
}


def sqrt(x: Double) = {
	def abs(x: Double): Double =
		 if (x >0) x else -x
 
	def square(x: Double): Double = x * x
    	
	def sqrtIter(guess: Double, x: Double): Double =
		 if (isGoodEnough(guess, x)) guess
		 else sqrtIter(improve(guess, x), x)
	
	def improve(guess: Double, x: Double) =	(guess + x / guess) / 2
 
 	def isGoodEnough(guess: Double, x: Double) = abs(square(guess) - x) < 0.0001
 	
 	sqrtIter(1.0, x)
}

// Format an Integer and a Double to String
def fmt(v: Any): String = v match {
  case d : Double => "%1.2f" format d
  case i : Int => i.toString
  case _ => throw new IllegalArgumentException
}

// PGCD  = fonction tail recursive, pas besoin d'empilement de la fonction pour le calcul
def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

// Factorial ecriture tail recursive pour helper, @tailrec > test qu'elle soit effectivement bien tailrec
def fact(n : BigInt) : BigInt = {
		@tailrec def helper(m : BigInt, current : BigInt) : BigInt = 
		  if (m <= 1) current else helper(m - 1, m * current) 
  helper(n, 1)}

// Factorial écriture NON tailrec, donne résultat faux a partir de n > 12
def factoriel(n: Int): Int = if (n==0) 1 else n * factoriel(n-1)

// additionne tous les entiers compris entre a et b, sumInt est une fonction dite de permier ordre
def sumInt(a:Int, b:Int):Int =
  if (a>b) 0 else a + sumInt(a+1, b)
  
def square(x: Int): Int = x * x
def sumSquare (a:Int, b:Int): Int =
  if(a>b) 0 else square(a)+ sumSquare(a+1, b)
  
def powerOf2(x:Int):Int = if(x==0) 1 else 2*powerOf2(x-1)
def sumPowerOf2 (a:Int, b:Int):Int =
  if(a>b) 0 else powerOf2(a)+sumPowerOf2(a+1,b)
  
// les trois fonctions précédentes sont de même type, soit f(n) pour n variant de a vers b   
def sum(f: Int => Int, a:Int, b:Int): Int =
  if(a>b) 0 else f(a) + sum(f, a+1, b)
def sumInts(a: Int, b:Int): Int = sum(id, a, b)
def sumSquares(a: Int, b:Int): Int = sum(square, a, b)
def sumPowerOf2s(a: Int, b:Int): Int = sum(powerOf2, a, b)

def id(x:Int): Int = x

// en utilisant des fonctions anonymes, comme celle-ci qui elève au carre (x:Int) => x*x
def sumIntAno(a:Int, b:Int):Int = sum((x:Int) => x, a, b)
def sumSquareAno(a:Int, b:Int):Int = sum((x:Int) => x*x, a, b)

// la curryfication
def sumCurry(f: Int => Int)(a:Int, b:Int): Int = 
    if (a>b) 0 else f(a) + sumCurry(f)(a+1, b)

def sumIntCurry = sumCurry(id)(_,_)
def sumSquareCurry = sumCurry(square)(_,_)

def sumTailRec(f: Int => Int)(a: Int, b: Int): Int = {
   	def iter(a: Int, result: Int): Int = {
   		if (a>b) 0
 		else f(a) + iter(a+1, b)
 	}
 	iter(a, b)
}

/* ============================================================
 * Appels aux fontcions
 * ============================================================  */
var startTime = System.currentTimeMillis

println("racine carré de 2 vaut= " + fmt(sqrt(2)))
println("racine carré de 25 vaut= " + fmt(sqrt(25)))
println("elapsed time= " + (System.currentTimeMillis - startTime) + " milliseconds") 

var tab: Array[Int] = Array(7, 5, 1, 24, 3, 54, 78, 101, 51, 5, 3, 1, 24, 148, 1540, 8, 12, 54, 12, 1, 3, 5, 10 ,14, 8700)
print("tableau = ")
println(tab.mkString("[",",","]"))

print("tableau trié = ")
println(sort2(tab).mkString("[",",","]"))

val x:Int = 16
val y:Int = 32
println("PGCD entre " + x + " et " + y + " est egal à " + gcd(x,y) )

println("elapsed time= " + (System.currentTimeMillis - startTime) + " milliseconds") 

println("(tailrec) Factoriel de x= " + fact(x))
println("elapsed time= " + (System.currentTimeMillis - startTime) + " milliseconds") 

println("(non tailrec) Factoriel de x= " + factoriel(x))
println("elapsed time= " + (System.currentTimeMillis - startTime) + " milliseconds")

println("somme d'entiers: " + sumInt(1,5))
println("somme des carrés d'entiers: " + sumSquare(1,4))
println("somme des carrés d'entiers - Algorithme factorisé: " + sumSquares(1,4))
println("somme des carrés d'entiers - fonction Anonyme: " + sumSquareAno(1,4))
println("somme des carres d'entiers - curryfication: " + sumSquareCurry(1,4))
println("somme des carres d'entiers - tail recursive: " + sumTailRec(square)(1,4))


// fin du code
}