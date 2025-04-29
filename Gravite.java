/** 
 * La classe <code>Gravite</code> est une classe qui permet de gérer la gravité verticale d'une partie de jeu
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class Gravite{
	private int colonne = 17;
	private int ligne = 12;
	/** 
	 * Constructeur de <code>Gravite</code> qui permet de faire redescendre les lignes quand il y a un 0 
	 * 
	 * @param grille grille de jeu au moment où la méthode est invoquée
	 */
	public Gravite(int grille[][]) {
		int change = 1;
		while(change != 0){	// On continue de boucler tant que des changements sont faits
			change = 0;
			for (int i = 1; i < ligne-1; i++){ // Parcourt les lignes
				for (int j = 1; j < colonne-1; j++){ // Parcourt les colonnes
					if(grille[i+1][j] == 0 && grille[i+1][j] != grille[i][j]){
						grille[i+1][j] = grille[i][j]; // Descends la valeur vers le bas
						grille[i][j] = 0; // L'ancienne valeur devient donc 0
						change++; //Indique qu'un changement a été fait
					}
				}
			}
		}
		// On vérifie toutes les colonnes pour savoir si on peut les bouger à gauche
		int z = 0;
		while(z < 15){
			new GraviteGauche(grille);
			z++;
		}
	}
}
