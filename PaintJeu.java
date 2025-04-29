import javax.swing.*;
import java.awt.*;

/** 
 * La classe <code>PaintJeu</code> est une classe qui hérite de <code>JPanel</code> et qui fait un panneau personnalisé
 * Cette classe dessine l'écran de jeu, donc dessine les images dans les cases et les bordures quand la souris est sur un groupe de blocs
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */
public class PaintJeu extends JPanel {

    private Image image; // Images des cases de la grille
    private int valeur; // Valeur pour savoir quelle image mettre dans quelle case
    private boolean surbrillance = false; // Par défaut surbrillance désactivée

    /**
     * Constructeur de la classe <code>PaintJeu</code>
     * Charge l'image de case dans le dossier Images, on a une image différente en fonction de la valeur dans la grille
     * 
     * @param valeur valeur de la case 
     */
    public PaintJeu(int valeur) {
        super();
        this.valeur = valeur;

        // Charger l'image selon la valeur
        switch (valeur) {
        case 1:
            image = Toolkit.getDefaultToolkit().getImage("Images/Zweihander.jpeg");
            break;
        case 2:
            image = Toolkit.getDefaultToolkit().getImage("Images/Yorshka_s_Chime.jpg");
            break;
        case 3:
            image = Toolkit.getDefaultToolkit().getImage("Images/Scythe.jpg");
            break;
        default:
            image = null;
        }
    }

    /**
     * Dessine la surbrillance de la case 
     *
     * @param active Si vrai, active la surbrillance, sinon la désactive
     */
    public void setSurbrillance(boolean active) {
        this.surbrillance = active;
        repaint(); // Repeindre la cellule pour mettre la surbrillance
    }

    /**
     * Renvoie la valeur associée à cette case
     *
     * @return la valeur de la case
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Méthode qui est appelée pour dessiner le contenu graphique du panneau
     *
     * @param pinceau l'objet utilisé pour dessiner le contenu du panneau
     */
    @Override
    protected void paintComponent(Graphics pinceau) {

        Graphics secondpinceau = pinceau.create(); // Création d'un pinceau pour dessiner

        if(this.isOpaque()){
            secondpinceau.setColor(this.getBackground());
            secondpinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        } //Toute la partie avant est obligatoire si on veut que l'objet ne soit pas transparent et le pinceau sert à ajouter ce qu'on veut

        // Dessiner l'image si elle existe
        if (image != null) {
            secondpinceau.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }

        // Dessiner la bordure rouge si surbrillance activée
        if (surbrillance) {
            secondpinceau.setColor(Color.RED);
            secondpinceau.drawRect(1, 1, getWidth() - 3, getHeight() - 3);  // Dessiner la bordure
        }
    }
}