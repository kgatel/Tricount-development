import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;
import java.util.*;
import javax.swing.SwingUtilities;

public class Client {
		
	public static void main(String args[]) throws RemoteException {
		String machine = "localhost";
		int port = 1099;
		int choix = 0;
		Personne pers;
		boolean connexion;
		ArrayList<String> ip = new ArrayList<String>();
		if (args.length==1) {
			pers = new PersonneImpl(args[0]);
		} else if(args.length==2){
			pers = new PersonneImpl(args[0]);
			machine = args[1];
			try {
			//affichage de l'IP Serveur
			for (
				final Enumeration< NetworkInterface > interfaces =
					NetworkInterface.getNetworkInterfaces();
				interfaces.hasMoreElements();
			){
				final NetworkInterface cur = interfaces.nextElement();

				if ( cur.isLoopback() ){
					continue;
				}

				for ( final InterfaceAddress addr : cur.getInterfaceAddresses() ){
					final InetAddress inet_addr = addr.getAddress();
					if ( !( inet_addr instanceof Inet4Address ) ){
					continue;
				  }
					ip.add(inet_addr.getHostAddress());
				}
			}

			// Choix de l'ip si plusieurs sur la carte réseau
			// nécessaire hors INSA
			System.out.println("Vous avez plusieur IP veuilliez en choisir une."); 
			if (ip.size() > 1) {
				for (int i=0;i<ip.size();i++) {
					System.out.println("IP n° "+i+": " + ip.get(i));
				}
				String scanner = "";
				Scanner sc = new Scanner(System.in);
				System.out.println("Donnez votre choix ");
				scanner = sc.nextLine();
				choix = Integer.parseInt(scanner);
				sc.close();
			}

			System.setProperty("java.rmi.server.hostname", ip.get(choix));
			if(args.length==3)
				port = Integer.parseInt(args[2]);
			} catch (Exception e) {
				System.out.println(e);
			}
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
					IHM fenetre = null;
					try {
						fenetre = new IHM(obj,pers);
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