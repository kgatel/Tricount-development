
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;

public class ConfirmerDepenseAction extends AbstractAction {
	
	private FenetreConfirmationDepense fenetreConfirmation;
	
	public ConfirmerDepenseAction(FenetreConfirmationDepense fenetre, String texte){
		super(texte);
		this.fenetreConfirmation = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		//Ajouter au serveur la dépense avec les personnes cochées puis fermez la fenêtre si la dépense est valide
		
		
		this.fenetreConfirmation.dispose();
		
		int idDepense;
		try {
			idDepense = this.fenetreConfirmation.getFenetreDepense().getFenetrePrincipale().getTricount().GetDepense().size();
			String commentaire = this.fenetreConfirmation.getCommentaire();	
			int idAcheteur = this.fenetreConfirmation.getFenetreDepense().getFenetrePrincipale().getUtilisateur().getId();
			double montant = this.fenetreConfirmation.getMontant();
			int[] idTab = new int[this.fenetreConfirmation.getPersonneTab().length];
			for (int i=0;i<idTab.length;i++) {
				idTab[i]=this.fenetreConfirmation.getPersonneTab()[i].getId();
			}
			this.fenetreConfirmation.getFenetreDepense().getFenetrePrincipale().getTricount().AddDepense(idDepense,commentaire, idAcheteur, montant, idTab );
			System.out.println("Dépense ajoutée " + idAcheteur);
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
		
		ArrayList<Personne> listPersonne = new ArrayList<Personne>();
		for (int i=0;i<fenetreConfirmation.getFenetreDepense().getListcheckbox().size();i++) {
			if (fenetreConfirmation.getFenetreDepense().getListcheckbox().get(i).isSelected()) {
				try {
					listPersonne.add(fenetreConfirmation.getFenetreDepense().getFenetrePrincipale().getTricount().GetParticipants().get(i));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
		this.fenetreConfirmation.getFenetreDepense().dispose();
		
		
	}

}
