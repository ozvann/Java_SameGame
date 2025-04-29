/** 
 * La classe <code>Grid</code> est une classe qui permet d'initialiser la grille de jeu avec les dimensions demandées
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class Grid{
	private int colonne = 17; // Nombre de colonnes
	private int ligne = 12; // Nombre de lignes
	private int[][] grille; // Initialisation de la grille
	/** 
	 * Constructeur de la classe <code>Grid</code> qui permet de remplir la grille en définissant tout d'abord les bordures et en initialisant avec des 0
	 * Puis en appelant les fonctions en fonction du choix fait par l'utilisateur (Remplir la grille à l'aide d'un fichier prédéfini ou aléatoirement)
	 * 
	 * @param remple choix de l'utilisateur (grille par fichier ou aléatoire)
	 */
	public Grid(int remple){
		grille = new int[ligne][colonne]; // On définit la grille avec notre nombre de lignes et de colonnes
		for (int i = 0; i < ligne; i++){ // On parcourt les lignes
			for (int j = 0; j < colonne; j++){ //On parcourt les colonnes
				if (i != 0 && j != 0 && i != ligne-1 && j != colonne-1){
					grille[i][j] = 0; // Si on est pas dans les bords, on met un 0 
				}else{
					grille[i][j] = 9; // Si on est dans la bordure, on met un 9
				}
			}
		}
		if(remple == 1){ // Si le choix de l'utilisateur est par fichier, on remplit la grille par le contenu du fichier (Remplifile)
			new Remplifile(grille);
		}else if(remple == 2){ // Si c'est aléatoirement, on rempli la grille aléatoirement (AleaGrid)
			new AleaGrid(grille);
		}
		new EcranJeu(grille); // On initialise l'écran de jeu avec la grille modifiée
	}
}