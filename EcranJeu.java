import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>EcranFin</code> hérite de la classe <code>Fenetre</code> et crée la fenêtre de jeu qui gère toute la partie en cours
 *  
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class EcranJeu extends Fenetre {
    // On initialise une variable qui va récupérer le score du joueur
    private int score = 0;

    /**
     *  Ecrase le titre de la fenêtre actuel pour le remplacer par celui avec le nouveau score
     * 
     * @param gain gain de score effectué par le clic de la souris
     */
    public void ajouterScore(int gain) {
        score += gain;
        window.setTitle("Same Game - Score : " + score);
    }

    /**
     * Permet de récupérer le score actuel de la partie
     * 
     * @return score de la partie
     */
    public int getScore() {
        return score;
    }

    /** 
     * Constructeur de la classe EcranJeu qui permet de créer une fenêtre avec une grille contenant toutes les images ou cases du jeu sur lesquelles on peut cliquer
     * 
     * @param grille la grille de base qu'on utilise pour afficher la grille la première fois
     */
    public EcranJeu(int[][] grille) {
        super(); // appel au constructeur de Fenetre

        this.window.setTitle("Same Game"); // Titre de base sans le score car le joueur n'a pas commencé à jouer

        // Définir un layout pour la fenêtre
        this.window.setLayout(new GridLayout(12, 17));

        // Créer un tableau de panels (un pour chaque case de la grille)
        PaintJeu[][] panels = new PaintJeu[grille.length][grille[0].length];

        // Parcourir la grille et ajouter les cases avec image
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                int valeur = grille[i][j];
                
                panels[i][j] = new PaintJeu(valeur);
                
                // Créer un listener pour chaque case, en passant aussi le tableau de panels
                ListenerJeu obs = new ListenerJeu(i, j, grille, this.window, panels, this);
                panels[i][j].addMouseListener(obs);
                panels[i][j].addMouseMotionListener(obs);

                // On ajoute le tableau de panels à la fenêtre
                this.window.add(panels[i][j]);
            }
        }
        // On rend la fenêtre visible
        this.window.setVisible(true);
    }
}