import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class DemanderEquilibreAction extends AbstractAction {
	private FenetrePrincipale fenetre;
	
	public DemanderEquilibreAction(FenetrePrincipale fenetre, String texte){
		super(texte);
		
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
	} 
}
