import java.awt.event.*;
import javax.swing.*;

/** 
 * La classe <code>ListenerGlobal</code> est une classe qui hérite de <code>ActionListener</code> et qui gère les ActionListener de tout le programme
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class ListenerGlobal implements ActionListener{ 
	private JFrame fenetre; // On récupère la fenêtre pour pouvoir la fermer avant d'appeler une autre fonction

	/** 
	 * Constructeur de la classe <code>ListenerGlobal</code> qui permet simplement de récupérer la fenêtre 
	 * 
	 * @param fenetre la fenetre qu'on récupère
	 */
	public ListenerGlobal(JFrame fenetre){
		this.fenetre = fenetre;
	}
	
	/** 
	 * Un override qui permet de gérer les actions réalisées en fonction des commandes définies dans le code
	 * 
	 * @param e évènement déclenché par l'utilisateur
	 */
	@Override
	public void actionPerformed(ActionEvent e){ 
		String composant = e.getActionCommand(); // On récupère la commande du listener ajouté pour savoir quoi faire
		if(composant == "play"){ // Commande play : lance le choix de la grille
			fenetre.dispose();
			new Choix();
		} else if(composant == "quit"){ // Commande quit : quitte directement le programme
			System.exit(0);
		} else if(composant == "rdm"){ // Commande rdm = random : crée une grille aléatoire
			fenetre.dispose();
			new Grid(2);
		} else if(composant == "fichier"){ // Commande fichier : lance une grille avec le fichier donné dans la sélection
			fenetre.dispose();
			new Grid(1);
		}
	}
}
