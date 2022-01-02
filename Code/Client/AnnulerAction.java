


import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class AnnulerAction extends AbstractAction {
	
	private JFrame fenetre;
	
	public AnnulerAction(JFrame fenetre){
		super("<html><h4>Annuler</h4></html>");
		this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) { 
		//Action lors du clic sur le bouton calculer
		
		this.fenetre.dispose();
		
	}

}
