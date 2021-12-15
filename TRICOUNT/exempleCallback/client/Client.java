import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;
    Guy stubGuy, aGuy = new GuyImpl(args[args.length-1]);
    if(args.length==3) {
      machine = args[0];
      port = Integer.parseInt(args[1]);
    } else if(args.length==2)
      machine = args[0];
    try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      Hello obj = (Hello)registry.lookup("HelloCallback");
      stubGuy = (Guy)UnicastRemoteObject.exportObject(aGuy,0);
      System.out.println(obj.sayHelloAndChangeName(stubGuy));
      UnicastRemoteObject.unexportObject(aGuy, true);
      System.out.println("Nouveau nom : " + aGuy.getName());
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
