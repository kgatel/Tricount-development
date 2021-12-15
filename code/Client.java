import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class Client {
  public static void main(String args[]) {
	Scanner clavier = new Scanner(System.in);
	int choix=0;
    String machine = "localhost";
    int port = 1099;
    Personne stubpers,pers = new PersonneImpl(args[args.lenght-1]);
    if(args.length==3) {
      machine = args[0];
      port = Integer.parseInt(args[1]);
    } else if(args.length==2)
      machine = args[0];
    try {
    	 Registry registry = LocateRegistry.getRegistry(machine, port);
         MethodesClient obj = (MethodesClient)registry.lookup("Demande");
         stubpers = (Personne)UnicastRemoteObject.exportObject(pers,0);
    	while (choix!=4) {
	    	while ((choix<1) && (choix >4)) {	
	    		System.out.println("que voulez vous faire ? :");
	    		System.out.println("\t- 1 : demander equilibre");
	    		System.out.println("\t- 2 : ajouter dépense");
	    		System.out.println("\t- 3 : rembourser");
	    		System.out.println("\t- 4 : se déconnecter");
	    		choix=clavier.nextInt();	
	    	}
		    	switch (choix) {
		    		case 1:
		    			System.out.println(MethodesClient.GetEquilibre(stubpers));
		    			UnicastRemoteObject.unexportObject(pers, true);
		    			System.out.println("Nouveau solde : " + pers.getSolde());
		    			break;
		    		case 2:
		    			System.out.println(MethodesClient.AddDepense(stubpers));
		    			UnicastRemoteObject.unexportObject(pers, true);
		    			System.out.println("Nouveau solde : " + pers.getSolde());
		    			break;	
		    		case 3:
		    			System.out.println(MethodesClient.AddDepense(stubpers));
		    			UnicastRemoteObject.unexportObject(pers, true);
		    			System.out.println("Nouveau solde : " + pers.getSolde());
		    			break;
		    	}
    	}
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
    clavier.close();
  }
}
