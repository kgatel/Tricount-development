import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;

public class AjouterDepenseAction2 extends AbstractAction {
	private FenetreDepense fenetre;
	
	public FenetreDepense getFenetre() {
		return fenetre;
	}
	
	public AjouterDepenseAction2(FenetreDepense fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		//Ajouter au serveur la dépense avec les personnes cochées puis fermez la fenêtre si la dépense est valide
		
		System.out.println("\n\nAjouter dépense : ");
		//Commentaire
		String commentaire = fenetre.getSaisieCommentaire().getText();
		commentaire = commentaire.substring(3);
		System.out.println("Commentaire : "+commentaire);
		
		//Montant
		String montant = fenetre.getSaisieMontant().getText();
		montant = montant.substring(3);
		System.out.println("Montant : "+montant+"€");
		
		//On vérifie que le montant est valide
		if (!isValidFloat(montant)) {
			System.out.println("Montant invalide, saisie incorrect");
		}
		else {
			if (Double.parseDouble(montant)<0.01) {
				System.out.println("Veuillez rentrer une somme supérieure à 0.01€");
			}
			else {
				if (commentaire.equals("")) {
					System.out.println("Veuillez rentrer le commentaire de votre dépense");
				}
				else {
					
					ArrayList<Personne> listPersonne = new ArrayList<Personne>();
					for (int i=0;i<fenetre.getListcheckbox().size();i++) {
						if (fenetre.getListcheckbox().get(i).isSelected()) {
							listPersonne.add(fenetre.getParticipant().get(i));
						}
					}
					
					//On vérifie qu'au moins une personne a été selectionnée
					if (listPersonne.size()==0) {
						System.out.println("Veuillez selectionnez au moins une personne");
					}else {
						Personne[] participantTab = new Personne[this.fenetre.getParticipant().size()];
						int indice=0;
						for (int i=0;i<this.fenetre.getParticipant().size();i++) {
							if (this.fenetre.getListcheckbox().get(i).isSelected()) {
								participantTab[indice] = this.fenetre.getParticipant().get(i);
								indice++;
							}
						}
						try {
							FenetreConfirmationDepense f = new FenetreConfirmationDepense(fenetre,Double.parseDouble(montant),commentaire,participantTab);
							f.setVisible(true);
						} catch (NumberFormatException | RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
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
