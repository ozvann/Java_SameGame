/** 
 * La classe <code>Main</code> est une classe très courte qui lance juste l'accueil qui est le point de départ qui enchaîne 
 * toutes les classes nécessaires au fonctionnement du programme
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */
public class Main{
	/** 
	 * Constructeur de la classe <code>Main</code> qui lance l'accueil et c'est simplement ça
	 */
	public static void main(String[] args) {
		Accueil accueil = new Accueil(); // Lance l'accueil
		accueil.window.setVisible(true); // Rend la fenêtre visible
	}
}
