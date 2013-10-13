package main.W6_Exo;

import java.util.ArrayList;

public class EntiersAmicaux {

	public static void main(String[] args) {

	// Raw Data
	int[] nombres	= {1210, 45, 27, 220, 54, 284, 9890, 120, 1184};
	int[] sommeDiv	= new int[nombres.length];
	
	// Calculer la somme des diviseurs des entiers du jeu de données
	for (int i=0; i < nombres.length; ++i){
		sommeDiv[i] = SumDiv(TrouverDiv(nombres[i]));
	}
	
	// Afficher le tab resulat
	for (int i=0; i < nombres.length; ++i){
		System.out.println("pour " + nombres[i] + " on trouve " + sommeDiv[i]);
	}

	System.out.println("Les paires de nombres amicaux sont alors: ");
	// Trouver les paires de nombres amicaux
	for (int i=0; i < nombres.length; ++i){
		for (int j=i+1; j < nombres.length; ++j){
			if (sommeDiv[i] == sommeDiv[j]){
				System.out.println(nombres[i] + " " + nombres[j]);
			}
		} // for j
	} // for i

	} // fin main


	/* -----------------------------------------
	 * functions
	 * -----------------------------------------*/
	static ArrayList<Integer> TrouverDiv(int n) {
		ArrayList<Integer> Diviseurs = new ArrayList<Integer>();
		int a = 1;
		int b = n;
		
		while( a < b){
			if (n%a == 0) 
			{
				Diviseurs.add(a);
				b = n/a;
				Diviseurs.add(b);
			} // fin then
			++a;
		} // fin while
		return Diviseurs;
	}

	static int SumDiv(ArrayList<Integer> tab) {
		int s = 0;
		for(int i=0; i< tab.size(); ++i){
			s += tab.get(i);
		}// fin for	
		return s;
	}
	
} // fin class
