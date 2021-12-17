import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class AjouterDepenseAction extends AbstractAction {
	private FenetrePrincipale fenetre;
	
	public AjouterDepenseAction(FenetrePrincipale fenetre, String texte){
		super(texte);
		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
	} 
}
