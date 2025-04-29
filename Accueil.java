import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>Accueil</code> hérite de la classe <code>Fenetre</code> pour créer 
 * la fenêtre d'accueil du jeu
 *  
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class Accueil extends Fenetre{
	
	/**
	 * Constructeur de la classe <code>Accueil</code> qui construit la fenêtre d'accueil avec les boutons nécessaires
	 */

	public Accueil(){
		super(); // Appel au constructeur de fenetre pour créer la fenêtre de base

		// Création du panneau d'accueil modifié
		PaintAccueil panneau = new PaintAccueil();
		this.window.add(panneau); 

		panneau.setLayout(null); // Position des éléments absolue

		// Création des boutons Jouer et Quitter
		JButton btn1 = new JButton("Jouer");
		JButton btn2 = new JButton("Quitter");

		// Position et dimensions des boutons
		btn1.setBounds(250,500,200,50);
		btn2.setBounds(550,500,200,50);

		// Ajout du listener pour quand les boutons sont cliqués
		ListenerGlobal obs = new ListenerGlobal(this.window);
		btn1.addActionListener(obs);
		btn2.addActionListener(obs);

		// Ajout des commandes personnalisées en fonction de ce que nous voulons faire avec les boutons
		btn1.setActionCommand("play");
		btn2.setActionCommand("quit");

		// Ajout des boutons au panneau
		panneau.add(btn1);
		panneau.add(btn2);
	}
}
