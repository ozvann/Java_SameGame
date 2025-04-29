import java.util.Random;
import java.io.*;

/**
 * La classe <code>AleaGrid</code> permet simplement de créer une grille aléatoire
 *  
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class AleaGrid{

	private int colonne = 17; // Nombre de colonnes
	private int ligne = 12; // Nombre de lignes

	/** Constructeur de la classe <code>AleaGrid</code> 
	 * 
	 * @param grille la grille qu'on doit remplir
	 */

	public AleaGrid(int grille[][]){ // On prend en argument une grille puis on la remplit avec des valeurs aléatoires

		Random rand = new Random();  // Chiffre aléatoire
		int alea = 0; // Initialisation d'une variable pour mettre le prochain chiffre aléatoire

		for (int i = 0; i < ligne; i++){
			for (int j = 0; j < colonne; j++){
				alea = rand.nextInt(3); // On met le chiffre aléatoire

				if (i != 0 && j != 0 && i != ligne-1 && j != colonne-1){
					grille[i][j] = alea+1; // En parcourant le tableau, si l'endroit où on est n'est pas une bordure, on y place la valeur aléatoire
				}else{
					grille[i][j] = 9; // Sinon, on y met la valeur 9 (valeur pour les bordures)
				}
			}
		}
	}
}
