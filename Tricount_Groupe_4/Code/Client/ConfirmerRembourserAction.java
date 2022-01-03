

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.AbstractAction;

public class ConfirmerRembourserAction extends AbstractAction {
	
	private FenetreConfirmationRembourser fenetreConfirmation;
	
	public ConfirmerRembourserAction(FenetreConfirmationRembourser fenetre, String texte){
		super(texte);
		this.fenetreConfirmation = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		this.fenetreConfirmation.dispose();
		
		int idDepense;
		try {
			idDepense = this.fenetreConfirmation.getFenetreRembourser().getFenetrePrincipale().getTricount().GetDepense().size();
			int idAcheteur = this.fenetreConfirmation.getFenetreRembourser().getFenetrePrincipale().getUtilisateur().getId();
			double montant = this.fenetreConfirmation.getMontant();
			int[] idTab = new int[1];
			idTab[0]=this.fenetreConfirmation.getPersonneRemboursee().getId();
			this.fenetreConfirmation.getFenetreRembourser().getFenetrePrincipale().getTricount().AddDepense(idDepense,"Remboursement", idAcheteur, montant, idTab );
			System.out.println("Remboursement effectué");
		
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
		
		this.fenetreConfirmation.getFenetreRembourser().dispose();
		
		
	}

}
