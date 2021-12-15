import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;


public class Serveur {
	  public static void main(String args[]) {
		Personne participants[];
		Depense tabdepense[];
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