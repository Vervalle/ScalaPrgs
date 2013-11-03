object SumMultiply extends App {

  def somme (x: Int, s:Int=0): Int = {
    //println("Avant: " + x + ", " + s)
    if (x%10 != 0 || x>9) somme(x/10, s + x%10)
    else s
  } // end somme

  def produit (x: Int, p:Int=1): Int = {
    if (x%10 != 0  || x>9) produit(x/10, p * (x%10))
    else p
  } // end produit
  
  def sommeProduitEgaux(x: Int): Boolean = {
    (somme(x) == produit(x))
  } // end   
    
  def lesPremiers (x: Int, max: Int, k: Int=0, acc: List[Int] = List.empty): List[Int] = {
    if (k == max) acc.reverse
    else { 
      if (sommeProduitEgaux(x)) lesPremiers(x+1, max, k+1, x::acc)
      else						lesPremiers(x+1, max, k, acc)
    }
   }  // end lesPremiers

 
  // les 20 premiers nombres à partir de 10 satisfaisant la condition somme{chiffres} = produit{chiffres}
  val xs = lesPremiers(10, 20)
  println(xs.mkString("[",",","]")) 
  
} // end object