import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Client {
		
	public static void main(String args[]) throws RemoteException {
		String machine = "localhost";
	    int port = 1099;
	    Personne stubPers, Pers = new PersonneImpl("Thibaut");
		Tricount tritemp = new TricountImpl();
	    try {
	    	Registry registry = LocateRegistry.getRegistry(machine, port);
	    	Tricount obj = (Tricount)registry.lookup("Tricountdesfamilles");
	        stubPers = (Personne)UnicastRemoteObject.exportObject(Pers,0);
	        System.out.println(obj.Connexion(Pers.getName()));
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					//On crée une nouvelle instance de notre SimpleFenetre
					FenetrePrincipale fenetre = null;
					try {
						System.out.println(obj.Clone(tritemp));
						fenetre = new FenetrePrincipale(obj);
						fenetre.setVisible(true);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
	        
	    } catch (Exception e) {
	    	System.out.println("Client exception: " +e);
	    }
	}
}