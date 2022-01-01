import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.AbstractAction;

public class AjouterDepenseAction extends AbstractAction {
	
	private FenetrePrincipale fenetre;
	
	public AjouterDepenseAction(FenetrePrincipale fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e){ 
		//Action lors du clic sur le bouton calculer
		
		FenetreDepense fenetredep = null;
		try {
			fenetredep = new FenetreDepense(this.fenetre);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fenetredep.setVisible(true);//On la rend visible
		
	} 
}
