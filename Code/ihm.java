import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;

public class ihm {

	public static void main(String[] args) throws RemoteException {
		System.out.flush();	//clean console board
		
		//ICI ON SE CONNECTE
		
		ArrayList<Personne> participant = new ArrayList<Personne>();
		
		//TESSSSSST
		participant.add(new PersonneImpl("Michèle"));
		participant.get(0).setId(0);
		participant.add(new PersonneImpl("Paul"));
		participant.get(1).setId(1);
		participant.add(new PersonneImpl("Jack"));
		participant.get(2).setId(2);
		participant.add(new PersonneImpl("Eugène"));
		participant.get(3).setId(3);
		participant.add(new PersonneImpl("Kev"));
		participant.get(4).setId(4);

		
		Personne[] participantTab = new Personne[participant.size()];
		
		for (int i=0;i<participant.size();i++) {
			participantTab[i] = participant.get(i);
		}
		
		//Fin TESSSSSST

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre SimpleFenetre
				FenetrePrincipale fenetre = null;
				try {
					fenetre = new FenetrePrincipale(new TricountImpl(participantTab),participant.get(0));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fenetre.setVisible(true);//On la rend visible
				
				
			}
		});
	
	}
}
