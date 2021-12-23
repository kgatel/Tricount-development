import java.awt.event.ActionEvent;
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
		FenetreRembourser fenetreremb = new FenetreRembourser(this.participant);
		fenetreremb.setVisible(true);//On la rend visible
	} 
}
