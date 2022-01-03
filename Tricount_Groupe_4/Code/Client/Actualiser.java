

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

public class Actualiser extends AbstractAction {
	
	private IHM fenetre;
	private ArrayList<Personne> participant;
	
	public Actualiser(ArrayList<Personne> participant,IHM fenetre, String texte){
		super(texte);
		this.participant=participant;
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		this.fenetre.dispose();
		
		try {
			this.fenetre.rebuild();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		fenetre.setVisible(true);//On la rend visible
		
	} 
}
