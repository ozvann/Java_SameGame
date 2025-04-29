/**
 * La classe <code>Verification</code> vérifie le format de la grille dans le fichier et a un compteur X et Y pour garder en compte
 * et vérifier la taille de la grille
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */
public class Verification{

	protected int compteX = 0; // Compteur position X
	protected int compteY = 0; // Compteur position Y

	/**
     * Constructeur par défaut de la classe <code>Verification</code>
     * Initialise les compteurs X et Y à 0
     */
	protected Verification(){
	}

	/**
     * Vérifie si un caractère donné est valide pour remplir la grille et les valeurs de position pour rester dans les limites
     * 
     * @param ch Le caractère à vérifier
     * @return true si le caractère et valide et false sinon 
     */
	public boolean verif(char ch){
		if (ch == 'R' || ch == 'V' || ch == 'B' || ch == '\n'){
			if (this.compteY > 10 || this.compteX > 15){ // Si ça dépasse la taille de la grille on retourne false
				return false;
			} else{
				return true; // Si il dépasse pas les limites et est valide on retourne true
			}
		}else { // Si il y a un caractère autre que les caractères valides on retourne false
			return false;
		}
	}

	// Compteur de position X pour avancer dans les colonnes
    public void compteX() {
        this.compteX++;
    }

    // Compteur de position Y pour avancer dans les lignes
    public void compteY() {
        this.compteY++;
        this.compteX = 0; // Réinitialisation du compteur X pour chaque nouvelle ligne
	}
}