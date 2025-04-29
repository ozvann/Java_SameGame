import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>Choix</code> hérite de la classe <code>Fenetre</code> et crée une fenêtre pour le choix de la grille (par fichier ou aléatoire)
 *  
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class Choix extends Fenetre{
	public Choix(){
		super(); // appel au constructeur de fenetre 

		// Création du panneau d'accueil modifié
		PaintChoix panneau = new PaintChoix();
		this.window.add(panneau);

		// Position des éléments absolue
		panneau.setLayout(null);

		// Création des boutons Choisir fichier et Grille aléatoire
		JButton btn1 = new JButton("Choisir fichier");
		JButton btn2 = new JButton("Grille aleatoire");

		// Position et dimensions des boutons
		btn1.setBounds(450,430,200,50);
		btn2.setBounds(450,530,200,50);

		// Ajout du listener pour quand les boutons sont cliqués
		ListenerGlobal obs = new ListenerGlobal(this.window);
		btn1.addActionListener(obs);
		btn2.addActionListener(obs);

		// Ajout des commandes personnalisées en fonction de ce que nous voulons faire avec les boutons 
		btn1.setActionCommand("fichier");
		btn2.setActionCommand("rdm");

		// Ajout des boutons au panneau
		panneau.add(btn1);
		panneau.add(btn2);

		// On rend la fenêtre visible
		this.window.setVisible(true);
	}
}
