import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.AbstractAction;

public class RembourserAction extends AbstractAction {
	private FenetrePrincipale fenetre;
	
	public RembourserAction(FenetrePrincipale fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		FenetreRembourser fenetreremb = null;
		try {
			fenetreremb = new FenetreRembourser(this.fenetre);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		fenetreremb.setVisible(true);//On la rend visible
	} 
}
