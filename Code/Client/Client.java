import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Client {
		
	public static void main(String args[]) throws RemoteException {
		String machine = "localhost";
	    int port = 1099;
	    Personne pers;
	    boolean connexion;
	    if (args.length==1) {
		    pers = new PersonneImpl(args[0]);
	    } else if(args.length==2){
		    pers = new PersonneImpl(args[0]);
      		machine = args[1];
      	} else if(args.length==3){
		    pers = new PersonneImpl(args[0]);
      		machine = args[1];
      		port = Integer.parseInt(args[2]);
      	}else{
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Donnez votre nom ");
	    	String prenom;
	    	prenom = sc.nextLine();
	    	sc.close();
		    pers = new PersonneImpl(prenom);
	    }
	    Personne stubPers;
	    try {
	    	Registry registry = LocateRegistry.getRegistry(machine, port);
	    	Tricount obj = (Tricount)registry.lookup("Tricount");
	        stubPers = (Personne)UnicastRemoteObject.exportObject(pers,0);
	        connexion = obj.Connexion(stubPers);
	        UnicastRemoteObject.unexportObject(pers, true);
	        if (connexion == true) {
	        	System.out.println("Connexion établie");
	        }else {
	        	System.out.println("Erreur de Connexion");
	        }
	        
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					//On crée une nouvelle instance de notre SimpleFenetre
					FenetrePrincipale fenetre = null;
					try {
						fenetre = new FenetrePrincipale(obj,pers);
						fenetre.setVisible(true);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			});
	        
	    } catch (Exception e) {
	    	System.out.println("Client exception: " +e);
	    }
	}
}