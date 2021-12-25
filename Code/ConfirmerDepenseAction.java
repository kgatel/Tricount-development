
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;

public class ConfirmerDepenseAction extends AbstractAction {
	
	private FenetreConfirmationDepense fenetre;
	
	public ConfirmerDepenseAction(FenetreConfirmationDepense fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		//Ajouter au serveur la dépense avec les personnes cochées puis fermez la fenêtre si la dépense est valide
		
		
		this.fenetre.dispose();
		
		System.out.println("Dépense Ajoutée");
		
		ArrayList<Personne> listPersonne = new ArrayList<Personne>();
		for (int i=0;i<fenetre.getFenetreDepense().getListcheckbox().size();i++) {
			if (fenetre.getFenetreDepense().getListcheckbox().get(i).isSelected()) {
				listPersonne.add(fenetre.getFenetreDepense().getParticipant().get(i));
			}
		}
		
		System.out.println("Dépense divisée en "+listPersonne.size()+" : ");
		for (int j=0;j<listPersonne.size();j++) {
			try {
				System.out.print(listPersonne.get(j).getName());
				if (j!=listPersonne.size()-1) {
					System.out.print(" - ");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.println();
		
		this.fenetre.getFenetreDepense().dispose();
		
		
	}

}
