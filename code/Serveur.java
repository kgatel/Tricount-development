import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;


public class Serveur {
	public Personne participants[];
	public Depense tabdepense[];
	public int nbparticipants = 0, nbdepenses=0;
	public boolean Addpersonne(String prenom) {
		if (nbparticipants<6) {
			participants[nbparticipants+1]= new PersonneImpl(prenom);
			try {
				participants[nbparticipants+1].setId(nbparticipants+1);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			nbparticipants+=1;
			return true;
		} else {
			System.out.println("un utlisateur "+prenom+" a essayé de se connecter");
			return false;
		}
		
	}
	
	  public static void main(String args[]) {
		
		
		int port  = 1099;
	    if(args.length==1)
	      port = Integer.parseInt(args[0]);
	    try {
	      MethodesClient skeleton = (MethodesClient)UnicastRemoteObject.exportObject(new MethodesClientImpl(), 0);
	      Registry registry = LocateRegistry.getRegistry(port);
	      if(!Arrays.asList(registry.list()).contains("Demande"))
	        registry.bind("Demande", skeleton);
	      else
	        registry.rebind("Demande", skeleton);
	      System.out.println("Service de Demande lie au registre");
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	  } 
	}