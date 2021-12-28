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
	    Personne Pers;
	    if (args.length==1) {
		    Pers = new PersonneImpl(args[0]);
	    } else if(args.length==2){
		    Pers = new PersonneImpl(args[0]);
      		machine = args[1];
      	} else{
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Donnez votre nom ");
	    	String prenom;
	    	prenom = sc.nextLine();
	    	sc.close();
		    Pers = new PersonneImpl(prenom);
	    }
	    Personne stubPers;
	    try {
	    	Registry registry = LocateRegistry.getRegistry(machine, port);
	    	Tricount obj = (Tricount)registry.lookup("Tricountdesfamilles");
	        stubPers = (Personne)UnicastRemoteObject.exportObject(Pers,0);
	        System.out.println(obj.Connexion(Pers));
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					//On crée une nouvelle instance de notre SimpleFenetre
					FenetrePrincipale fenetre = null;
					try {
						fenetre = new FenetrePrincipale(obj,Pers);
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