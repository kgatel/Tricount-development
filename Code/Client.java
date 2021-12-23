import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.SwingUtilities;

public class Client {
	public static void main(String args[]) {
		String machine = "localhost";
	    int port = 1099;
	    Personne stubPers, Pers = new PersonneImpl("Thibaut");
	    try {
	    	Registry registry = LocateRegistry.getRegistry(machine, port);
	    	Tricount obj = (Tricount)registry.lookup("Tricountdesfamilles");
	        stubPers = (Personne)UnicastRemoteObject.exportObject(Pers,0);
	        System.out.println(obj.Connexion(Pers.getName()));
			//On crée une nouvelle instance de notre SimpleFenetre
		/*FenetrePrincipale fenetre = null;
			try {
				fenetre = new FenetrePrincipale(obj.GetParticipants());
				System.out.println(fenetre.affichage3Depenses(obj.GetDepense()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fenetre.setVisible(true);//On la rend visible   */
		//tentative de RMI soldé par un échec mais le connexion marche.
	        
	    } catch (Exception e) {
	    	System.out.println("Client exception: " +e);
	    }
	}
}