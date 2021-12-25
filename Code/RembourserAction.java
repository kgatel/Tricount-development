import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;

public class RembourserAction extends AbstractAction {
	private FenetrePrincipale fenetre;
	private ArrayList<Personne> participant;
	
	public RembourserAction(ArrayList<Personne> participant,FenetrePrincipale fenetre, String texte){
		super(texte);
		this.participant=participant;
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		FenetreRembourser fenetreremb = null;
		try {
			fenetreremb = new FenetreRembourser(this.participant);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fenetreremb.setVisible(true);//On la rend visible
	} 
}
