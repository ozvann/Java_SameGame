import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/** 
 * La classe <code>ListenerJeu</code> est une classe qui hérite de <code>MouseAdapter</code> et qui gère les listener de souris qui concernent 
 * toute la partie de jeu en cours
 * 
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

/** 
 * On extend de la classe MouseAdapter au lieu de l'interface MouseListener pour ne pas avoir besoin de 
 * redéfinir toutes les méthodes de MouseListener
 */
public class ListenerJeu extends MouseAdapter { 
    private int i, j; // Position de là ou on a cliqué
    private JFrame window; // Récupération de la fenêtre 
    private int[][] grille; // Grille actuelle au moment du clic
    private PaintJeu[][] panels; // Grille de panels où on met les images
    private EcranJeu ecranJeu; // Ecran de jeu pour récupérer le score actuel du jeu

    /**
     * Constructeur de la classe <code>ListenerJeu</code> qui permet de récupérer des éléments utiles pour tout le programme
     * @param i ligne où on a cliqué
     * @param j colonne où on a cliqué
     * @param grille grille au moment du clic 
     * @param window fenêtre pour pouvoir la modifier au moment du code
     * @param panels tableau de panneaux pour pouvoir ajouter les contours en rouge 
     */
    public ListenerJeu(int i, int j, int[][] grille, JFrame window, PaintJeu[][] panels, EcranJeu ecranJeu) {
        this.i = i;
        this.j = j;
        this.grille = grille;
        this.window = window;
        this.panels = panels;
        this.ecranJeu = ecranJeu;
    }

    /** 
     * Un override qui permet de gérer les choses à faire au moment du clic de l'utilisateur
     * 
     * @param e évènement déclenché par l'utilisateur (souris cliquée)
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int valeur = grille[i][j];

        if (valeur == 0 || valeur == 9) { // On ne touche pas aux bordures ou aux cases déjà cliquées
            return;
        }

        // Grille de booléens de la même taille que la grille de jeu pour garder les cases appartenant aux même groupe que la case cliquée
        boolean[][] groupe = new boolean[grille.length][grille[0].length]; 
        int[] compteur = {0}; // Compteur pour compter combien de cases font partie de ce groupe 
        marquerGroupe(i, j, valeur, groupe, compteur); // On parcourt toutes les cases connectées à celle sur laquelle on a cliqué

        if (compteur[0] < 2) { // Taille du groupe maximum pour éviter de supprimer un groupe de 1 
            return;
        }

        // Calcul du gain de points
        int gain = (compteur[0] - 2) * (compteur[0] - 2);
        ecranJeu.ajouterScore(gain);

        for (int x = 0; x < grille.length; x++) { // On supprime tout le groupe 
            for (int y = 0; y < grille[0].length; y++) {
                if (groupe[x][y]) {
                    grille[x][y] = 0;
                }
            }
        }

        // On met de la gravité pour la grille pour que les éléments tombent comme ils sont sensés tomber 
        new Gravite(grille);


        window.getContentPane().removeAll(); // On supprime tout ce qu'il y a dans l'écran pour le redessiner par la suite

        for (int x = 0; x < grille.length; x++) {
            for (int y = 0; y < grille[0].length; y++) {

                panels[x][y] = new PaintJeu(grille[x][y]); // On redessine tous les panels dans la fenêtre

                // On rajoute les listener pour chaque élément
                ListenerJeu listener = new ListenerJeu(x, y, grille, window, panels, ecranJeu);
                panels[x][y].addMouseListener(listener);
                panels[x][y].addMouseMotionListener(listener);

                // On les rajoute à la fenêtre
                window.add(panels[x][y]);
            }
        }

        window.revalidate(); // On vérifie que les éléments soient tous bien remis en place
        window.repaint(); // On rafraîchit les graphismes pour que les modifications s'affichent à l'écran

        // Vérifier si le joueur a terminé le jeu (quand il ne reste plus que des groupes de taille 1 ou plus aucun groupe)
        if (verifFin()) {
            window.dispose(); // On enlève la fenêtre actuelle et on appelle l'écran de fin
            EcranFin fin = new EcranFin(ecranJeu.getScore());
            fin.window.setVisible(true);
        }
    }

    /** 
     * Un override qui permet de gérer les choses à faire au moment ou la souris rentre dans une case
     * 
     * @param e évènement déclenché par l'utilisateur (souris entrée dans la case)
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        int valeur = grille[i][j];

        if (valeur == 0 || valeur == 9) { // On ne touche pas aux bordures
            return;
        }

        // Grille de booléens de la même taille que la grille de jeu pour garder les cases appartenant aux même groupe que la case cliquée
        boolean[][] groupe = new boolean[grille.length][grille[0].length];
        marquerGroupe(i, j, valeur, groupe, new int[]{0}); // On parcourt toutes les cases connectées à celle sur laquelle on a cliqué

        for (int x = 0; x < grille.length; x++) {
            for (int y = 0; y < grille[0].length; y++) {
                panels[x][y].setSurbrillance(groupe[x][y]); // On met les contours rouges pour tous les éléments du groupe
            }
        }
    }

    /** 
     * Un override qui permet de gérer les choses à faire au moment ou la souris sort d'une case
     * 
     * @param e évènement déclenché par l'utilisateur (souris sortie de la case)
     */
    @Override
    public void mouseExited(MouseEvent e) {
        for (int x = 0; x < grille.length; x++) {
            for (int y = 0; y < grille[0].length; y++) {
                panels[x][y].setSurbrillance(false); // On enlève les contours rouge pour tous les éléments du groupe
            }
        }
    }

    /** 
     * Une méthode qui permet de repérer récursivement toutes les cases connectées à la case cliquée
     * On remplit le tableau groupe avec true pour chaque case qui fait partie du même groupe 
     * 
     * @param x abcisse (lignes)
     * @param y ordonnée (colonnes)
     * @param valeur la valeur de la case à rechercher
     */
    private void marquerGroupe(int x, int y, int valeur, boolean[][] groupe, int[] compteur) {
        if (x < 0 || y < 0 || x >= grille.length || y >= grille[0].length) { // Hors de la grille 
            return;
        }

        if (groupe[x][y]) { // Déjà visité
            return;
        }

        if (grille[x][y] != valeur) { // Si elle n'a pas la bonne valeur
            return;
        }

        groupe[x][y] = true; // La case appartient au groupe 
        compteur[0]++; // Compteur de taille de groupe

        // Exploration des 4 cases voisines
        marquerGroupe(x + 1, y, valeur, groupe, compteur); // Bas
        marquerGroupe(x - 1, y, valeur, groupe, compteur); // Haut
        marquerGroupe(x, y + 1, valeur, groupe, compteur); // Droite
        marquerGroupe(x, y - 1, valeur, groupe, compteur); // Gauche
    }

    /**
     *  Méthode pour vérifier si tous les groupes restants sont de taille 1
     * 
     */
    private boolean verifFin() {
        for (int i = 0; i < grille.length; i++) { // Parcourt les lignes
            for (int j = 0; j < grille[0].length; j++) { // Parcourt les colonnes
                int valeur = grille[i][j]; // Récupère la valeur de la case
                if (valeur == 0 || valeur == 9) {
                    continue; // Ignorer les cases vides ou les bordures
                }

                boolean[][] groupe = new boolean[grille.length][grille[0].length]; // Tableau groupe pour marquer les cases déjà explorées
                int[] compteur = {0}; // Compteur de la taille du groupe
                marquerGroupe(i, j, valeur, groupe, compteur); // Marque toutes les cases du groupe

                // Si un groupe est trouvé avec plus d'un élément, on continue le jeu
                if (compteur[0] > 1) {
                    return false;
                }
            }
        }
        return true; // Si tous les groupes restants sont de taille 1, la partie est terminée
    }
}