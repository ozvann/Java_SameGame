import javax.swing.*;
import java.io.*;

/**
 * La classe <code>Remplifile</code> est charge un fichier que l'utilisateur a choisi, et il associe les valeurs du fichier 
 * et le traduit en une grille avec les valeurs 1, 2 et 3
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */
public class Remplifile{

	private int colonne = 17; // Nombre de colonnes
	private int ligne = 12; // Nombre de lignes

	/** 
	 * Constructeur de la classe <code>Remplifile</code> qui lit les données du fichier donné par l'utilisateur
	 * Le fichier doit respecter le format 'R', 'V' ou 'B' sinon on affiche un message d'erreur
	 * 
	 * @param grille grille qu'on remplit avec les valeurs du fichier
	 */
	public Remplifile(int grille[][]){
		try{
			boolean badformat = true;
			while(badformat){

				// On demande à l'utilisateur de choisir un fichier
				ChoixFichier fichier = new ChoixFichier();
				FileReader enter = new FileReader("" + fichier + "");
				BufferedReader flux = new BufferedReader(enter);
				int c = 0;
				char ch;
				boolean format = true;
				Verification verif = new Verification();

				// On remplit la grille avec les caractères du fichier
				for(int i = 1; i < ligne-1; i++){
					for (int j = 1; j < colonne; j++) {
						c = flux.read();
						ch = (char) c;
						format = verif.verif(ch);


						if(format){
							if (grille[i][j] == 0){
								// On met les valeurs en fonction des caractères lus
								if (ch == 'R'){
									grille[i][j] = 1;
								}else if (ch == 'V'){
									grille[i][j] = 2;
								}else if (ch == 'B'){
									grille[i][j] = 3;
								}
							}
						}else {
											// Erreur de format 
							JOptionPane.showMessageDialog(null, "Fichier trop court : données manquantes.", "Erreur de format", JOptionPane.ERROR_MESSAGE);
							j = colonne;
							i = ligne;
						}
						verif.compteX(); // Vérification des lignes
					}
					verif.compteY(); // Vérification des colonnes
				}

				if(format){
					badformat = false; // Si le format est correct on sort de la boucle
				}

				flux.close(); // Fermeture du flux de lecture du fichier
			}
		} catch (IOException e){
			                     		// Gestion des erreurs de fichier
			JOptionPane.showMessageDialog(null, "Une erreur s'est produite : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
}