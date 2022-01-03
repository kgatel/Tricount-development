import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {
  public static void main(String args[]) {
    int port  = 1099;
    int choix = 0;
    ArrayList<String> ip = new ArrayList<String>();

    if(args.length==1)
      port = Integer.parseInt(args[0]);

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
      if (ip.size() > 1) {
        System.out.println("Vous avez plusieur IP veuilliez en choisir une."); 
        for (int i=0;i<ip.size();i++) {
          System.out.println("IP n° "+i+": " + ip.get(i));
        }
        String scanner = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez votre choix ");
        scanner = sc.nextLine();
        choix = Integer.parseInt(scanner);
        sc.close();
      }else{
        System.out.println("Address IP: " + ip.get(0)); 
        System.out.println("Port: " + port);
      }

      System.setProperty("java.rmi.server.hostname", ip.get(choix));
      Tricount stub = (Tricount)UnicastRemoteObject.exportObject(new TricountImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      if(!Arrays.asList(registry.list()).contains("Tricount"))
          registry.bind("Tricount", stub);
      else
          registry.rebind("Tricount", stub);
      System.out.println("Serveur lancé sous le nom Tricount");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}