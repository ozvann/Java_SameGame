import javax.swing.*;
import java.awt.*;

/** 
 * La classe <code>PaintFin</code> est une classe qui hérite de <code>JPanel</code> et qui fait un panneau personnalisé
 * Cette classe dessine l'écran de fin du jeu, donc dessine le titre avec un background et le score
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */
public class PaintFin extends JPanel {

    private Image background; // Image de background
    private int score; // Score du joueur

    /**
     * Constructeur de la classe <code>PaintChoix</code>
     * Charge l'image de fond dans le dossier Images, on a une image différente en fonction de la qualité du score du joueur
     * 
     * @param score score du joueur
     */
    public PaintFin(int score){
        super();
        this.score = score;
        if (score < 1000) { // Si le score est inférieur à 1000, on met cette image
            this.background = Toolkit.getDefaultToolkit().getImage("Images/fondmoins.png");
        } else if (score >= 1000 && score < 2000) { // Si le score est entre 1000 et 2000, on met cette image 
            this.background = Toolkit.getDefaultToolkit().getImage("Images/fondmilieu.png");
        } else if (score >= 2000) { // Si le score est supérieur à 2000 on met cette image
            this.background = Toolkit.getDefaultToolkit().getImage("Images/fondplus.png");
        } else { // Valeur par défaut donc vide 
            this.background = null;
        }
    }

   /**
     * Méthode qui est appelée pour dessiner le contenu graphique du panneau
     *
     * @param pinceau l'objet utilisé pour dessiner le contenu du panneau
     */
    @Override
    protected void paintComponent(Graphics pinceau){ 

        Graphics secondpinceau = pinceau.create(); // Création d'un pinceau pour dessiner

        if(this.isOpaque()){
            secondpinceau.setColor(this.getBackground());
            secondpinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        } //Toute la partie avant est obligatoire si on veut que l'objet ne soit pas transparent et le pinceau sert à ajouter ce qu'on veut

        secondpinceau.drawImage(this.background, 0, 0, this); // Dessiner l'image de background


        secondpinceau.setFont(new Font("Arial", Font.PLAIN, 60));
        secondpinceau.setColor(Color.BLACK);
        secondpinceau.drawString("Same Game", 360 + 3, 100 + 3); // Ombre du titre en noir

        secondpinceau.setColor(new Color(139,0,0));
        secondpinceau.drawString("Same Game", 360, 100); // Titre en rouge 

        secondpinceau.setFont(new Font("Arial", Font.PLAIN, 30));
        secondpinceau.drawString("Same Game : " + score, 390, 150); // Score un peu plus bas
    }
}