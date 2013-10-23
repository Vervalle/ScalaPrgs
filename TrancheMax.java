import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);

        // stocke les indices des lignes contenant la plus grande sequence de
        // '1' consecutifs dans la matrice
        ArrayList<Integer> maxConsecutifList = new ArrayList<Integer>();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        if (matrice.isEmpty()){
            System.out.println("Matrice vide!");
        	return;
        }
        
        // oter les whitespaces du debut et de fin
        matrice = matrice.trim();
        
        // ne saisir que 0 ou 1 ou  ' '
        int		i		= 0;
        while ( i < matrice.length()){
        	if (matrice.charAt(i) != '0' && matrice.charAt(i) != '1' && matrice.charAt(i) != ' ' ){
        		System.out.println("Matrice invalide, seulement '1' , '0' et ' ' admis!");
        		return;
        	} else {
        		++i;
        	}
        } // end while
        
        // tester la longueur des lignes
       	String[] lignes	= matrice.split(" {1,}");
       	int lineLength	= lignes[0].length();
       	int nbOfLines	= lignes.length;
       	i				= 1;
       	while ( i < nbOfLines){
       		if (lineLength != lignes[i].length()){
           		System.out.println("Matrice invalide, lignes de longueurs differentes!");
           		return;
       		} else {
       			++i;
       		}
       	} // end while
       	
       	// compter le nb de 1 consecutifs par ligne
       	int max = 0;
       	int[] decompte = new int[nbOfLines];
       	for (i=0; i < nbOfLines; ++i){
       		int unConsec = 0;
       		int maxLine  = 0;
       		boolean serie = false;
       		char previousChar = ' ';
       		
       		for (int j=0; j < lineLength; ++j) {
       			if (lignes[i].charAt(j) == '1' && previousChar == '1'){
       				if (serie) {		//serie qui se poursuit
       					++unConsec;
       				} else {			//serie qui commence
       					serie = true;
       					unConsec = 2;
       				} // end if serie
       			} else {
       				serie = false;		//serie qui s'arrete
       			} // end if

       			previousChar = lignes[i].charAt(j);
           		if (unConsec > maxLine){ maxLine = unConsec;} // meilleure suite pour la meme ligne
       		
       		} // end for j
       		decompte[i] = maxLine;
       		if (maxLine > max) { max = maxLine; }
       	} // end for i
       	
        for (Integer index : decompte) {
            System.out.print(index);
        }
        System.out.println("\n Max= " + max + " nblines= " + nbOfLines + " longueur line= " + lineLength );
       	
       	// alimenter le tableau resultat
        if ( max > 0) {
        	for (i=0; i < nbOfLines; ++i){
        		if ( decompte[i] == max) {
        			maxConsecutifList.add(i);
        		}
        	} // end for
        }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1!");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs:");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }
}
