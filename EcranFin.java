import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>EcranFin</code> hérite de la classe <code>Fenetre</code> et crée la fenêtre de fin qui arrive après la fin de la partie
 *  
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class EcranFin extends Fenetre{
	/**
	 * Le constructeur de la classe EcranFin qui construit notre écran de fin avec les boutons nécessaires
	 * 
	 * @param score le score de la partie en cours
	 */

	public EcranFin(int score){
		super(); // appel au constructeur de fenetre

		// Création du panneau d'accueil modifié en lui passant le score qui va permettre de modifier le fond d'écran en fonction du score
		PaintFin panneau = new PaintFin(score);
		this.window.add(panneau);

		// Position des éléments absolue
		panneau.setLayout(null);

		// Créations des boutons Rejouer et Quitter
		JButton btn1 = new JButton("Rejouer");
		JButton btn2 = new JButton("Quitter");

		// Position et dimensions des boutons
		btn1.setBounds(250,500,200,50);
		btn2.setBounds(550,500,200,50);

		// Ajout du listener pour quand les boutons sont cliqués
		ListenerGlobal obs = new ListenerGlobal(this.window);
		btn1.addActionListener(obs);
		btn2.addActionListener(obs);

		/**
		 * Ajout des commandes personnalisées en fonction de ce que nous voulons faire avec les boutons 
		 * On réutilise les mêmes commandes de <code>Accueil</code> pour optimiser l'utilisation d'espace
		 */
		btn1.setActionCommand("play");
		btn2.setActionCommand("quit");

		// Ajout des boutons au panneau
		panneau.add(btn1);
		panneau.add(btn2);
	}
}
