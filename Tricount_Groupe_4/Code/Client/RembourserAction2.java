

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.AbstractAction;

public class RembourserAction2 extends AbstractAction {
	
	private FenetreRembourser fenetre;
	
	public RembourserAction2(FenetreRembourser fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		System.out.println("\n\nRemboursement : ");
		
		//Montant
		String montant = fenetre.getSaisieMontant().getText();
		montant = montant.substring(3);
		
		int nb_cases_cochees=0;
		nb_cases_cochees=1;
		
		if (nb_cases_cochees!=1) {
			System.out.println("Veuillez sélectionner une et une seule personne à rembourser");
		}else {
			if (isValidFloat(montant)) {
				if (Double.parseDouble(montant)<0.01) {
					System.out.println("Veuillez rentrer une somme supérieure à 0.01€");
				}
				else {
					Personne p = null;
					int indiceP = this.fenetre.getCombobox().getSelectedIndex();
					try {
						p = this.fenetre.getFenetrePrincipale().getTricount().GetParticipants().get(indiceP);
					} catch (RemoteException e2) {
						e2.printStackTrace();
					}
					try {
						if (p.getId()==this.fenetre.getFenetrePrincipale().getUtilisateur().getId()) {
							System.out.println("Un utilisateur ne peut pas se rembourser lui-même");
						}else {
							try {
								FenetreConfirmationRembourser f = new FenetreConfirmationRembourser(fenetre,Double.parseDouble(montant),p);
								f.setVisible(true);
								
							} catch (NumberFormatException | RemoteException e1) {
								e1.printStackTrace();
							}
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}					
				}
			}else {
				System.out.println("Montant invalide, saisie incorrect");
			}
		}
		
	}
	
	private static boolean isValidFloat(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;		
	}
}
