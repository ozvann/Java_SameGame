import javax.swing.*;
import java.awt.*;

/** 
 * La classe <code>PaintChoix</code> est une classe qui hérite de <code>JPanel</code> et qui fait un panneau personnalisé
 * Cette classe dessine l'écran de choix de la grille, donc dessine le titre complet avec un background
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */
public class PaintChoix extends JPanel{

	private Image background; // Image de fond 

	/**
     * Constructeur de la classe <code>PaintChoix</code>
     * Charge l'image de fond dans le dossier Images
     */
	public PaintChoix(){
		super();
		this.background = Toolkit.getDefaultToolkit().getImage("./Images/hollow.png");
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

		secondpinceau.setColor(Color.BLACK);
		secondpinceau.setFont(new Font("Arial", Font.PLAIN, 30));
		secondpinceau.drawString("Dark Souls", 370, 150); // Suite du titre un peu plus bas en noir
	}
}
