
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;

public class AnnulerConfirmationDepenseAction extends AbstractAction {
	
	private FenetreConfirmationDepense fenetre;
	
	public AnnulerConfirmationDepenseAction(FenetreConfirmationDepense fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		//Ajouter au serveur la dépense avec les personnes cochées puis fermez la fenêtre si la dépense est valide
		
		System.out.println("Dépense annulé");
		this.fenetre.dispose();
		
	}

}
