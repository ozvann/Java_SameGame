import javax.swing.*;
import java.awt.*;

/** 
 * La classe <code>Fenetre</code> est une classe qui crée une fenêtre de base selon nos nécessités pour le projet
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class Fenetre{
	//On initialise la fenêtre
	protected JFrame window;

	/** 
	 * Constructeur de <code>Fenetre</code> qui crée une fenêtre avec les dimensions de notre projet
	 */
	public Fenetre(){
		window = new JFrame("Same Game : Dark Souls"); // On initialise la JFrame fenêtre
		window.setSize(1000, 700); // On définit la taille en 1000x700
		window.setResizable(false); // On fait en sorte que la fenêtre ne soit pas redimensionnable pour éviter les potentiels problèmes d'emplacement
		window.setLocation(50, 0); // On définit la position de base de la fenêtre à 50, 0
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On ferme la fenêtre quand on quitte
	}
}
