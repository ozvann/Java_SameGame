/** 
 * La classe <code>GraviteGauche</code> est une classe qui permet de gérer la gravité à gauche d'une partie de jeu
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class GraviteGauche{
	private int colonne = 17; // Nombre de colonnes
	private int ligne = 12; // Nombre de lignes
	private int update = 0; // Compteur pour déterminer si une colonne est vide

	/** 
	 * Constructeur de <code>GraviteGauche</code> qui permet de ramener les colonnes à gauche quand il y a des colonnes vides
	 * 
	 * @param grille grille de jeu au moment où la méthode est invoquée
	 */
	public GraviteGauche(int grille[][]){
		update = 0;
		// On parcourt le tableau en omettant les bordures
		for(int j = 1; j < colonne-1; j++){
			for(int i = 1; i < ligne-1; i++){ 
				if(grille[i][j] == 0 && grille[i][j+1] != 9){ // Si un bloc a une case non-vide et non-mur on incrémente un compteur
					update++; 
				}
			}
			if(update == ligne-2){ // Si une colonne entière est remplie de cases vides
				update = 0;
				for(int k = 1; k < ligne-1; k++){ // On décale les éléments de la colonne de droite vers celle de gauche et on les remplace par des 0
					grille[k][j] = grille[k][j+1];
					grille[k][j+1] = 0;
				}
			}
			update = 0;
		}
	}
}