

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
		
		System.out.println("\n\nAjouter dépense : ");
		//Commentaire
		String commentaire = fenetre.getSaisieCommentaire().getText();
		commentaire = commentaire.substring(3);
		
		//Montant
		String montant = fenetre.getSaisieMontant().getText();
		montant = montant.substring(3);
		
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
							try {
								listPersonne.add(fenetre.getFenetrePrincipale().getTricount().GetParticipants().get(i));
							} catch (RemoteException e1) {
								e1.printStackTrace();
							}
						}
					}
					
					//On vérifie qu'au moins une personne a été selectionnée
					if (listPersonne.size()==0) {
						System.out.println("Veuillez selectionnez au moins une personne");
					}else {
						int compteur=0;
						try {
							for (int i=0;i<fenetre.getFenetrePrincipale().getTricount().GetParticipants().size();i++) {
								if (this.fenetre.getListcheckbox().get(i).isSelected()) {
									compteur++;
								}
							}
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
						Personne[] participantTab = new Personne[compteur];
						int indice=0;
						try {
							for (int i=0;i<this.fenetre.getFenetrePrincipale().getTricount().GetParticipants().size();i++) {
								if (this.fenetre.getListcheckbox().get(i).isSelected()) {
									participantTab[indice] = this.fenetre.getFenetrePrincipale().getTricount().GetParticipants().get(i);
									indice++;
								}
							}
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
						
						
						
						try {
							FenetreConfirmationDepense f = new FenetreConfirmationDepense(fenetre,Double.parseDouble(montant),commentaire,participantTab);
							f.setVisible(true);
							
						} catch (NumberFormatException | RemoteException e1) {
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
