import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * La classe <code>ChoixFichier</code> permet simplement d'ouvrir une boîte de dialogue pour que l'utilisateur choisisse un fichier
 *  
 * @version 1.0
 * @author Rayan BISSON Ozvann ABRAHAM
 */

public class ChoixFichier {

	protected String sortie; // Le chemin absolu du fichier sélectionné
	protected int res; // Le code de résultat du sélecteur de fichier, il permet de savoir si un fichier a été sélectionné ou non

	/** 
	 * Le constructeur de la classe <code>ChoixFichier</code> 
	 * 
	 * Il ouvre une fenêtre pour choisir le fichier. Si un fichier est choisi son chemin absolu est enregistré dans <code>sortie</code>
	 */
  	public ChoixFichier(){
    	JFileChooser choose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    	res = choose.showOpenDialog(null);
    	if (res == JFileChooser.APPROVE_OPTION) {
    		File file = choose.getSelectedFile();
    		sortie = "" + file.getAbsolutePath();
		}
  	}
  	
  	/** 
  	 * Renvoie le chemin absolu du fichier choisi
  	 * 
  	 * @return chemin du fichier sélectionné
  	 */

  	public String toString(){
  		return this.sortie;
  	}
}