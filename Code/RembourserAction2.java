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
		
		//Ajouter la dépense inverse au serveur pour le stockage puis fermez la fenêtre si le montant est valide
		
		System.out.println("\n\nRemboursement : ");
		
		//Montant
		String montant = fenetre.getSaisieMontant().getText();
		montant = montant.substring(3);
		System.out.println("Montant : "+montant+"€");
		
		int nb_cases_cochees=0;
		/*for (int i=0;i<fenetre.getListcheckbox().size();i++) {
			if (fenetre.getListcheckbox().get(i).isSelected()) {
				nb_cases_cochees++;
			}
		}*/
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
					System.out.println("Montant Valide - Dépense acceptée");
					/*for (int j=0;j<fenetre.getListcheckbox().size();j++) {
						if (fenetre.getListcheckbox().get(j).isSelected()) {
							p = fenetre.getParticipant().get(j);
						}
					}*/
					int indiceP = fenetre.getCombobox().getSelectedIndex();
					p = fenetre.getParticipant().get(indiceP);
					try {
						System.out.println("Virement de "+montant+"€ vers le compte de "+p.getName());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}else {
				System.out.println("Montant invalide, saisie incorrect");
			}
		}
		
		this.fenetre.dispose();
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
