import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;


public class Serveur {
  public static void main(String args[]) {
    int port  = 1099;
    if(args.length==1)
      port = Integer.parseInt(args[0]);
    try {
      Hello skeleton = (Hello)UnicastRemoteObject.exportObject(new HelloImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      if(!Arrays.asList(registry.list()).contains("HelloExceptions"))
        registry.bind("HelloExceptions", skeleton);
      else
        registry.rebind("HelloExceptions", skeleton);
      System.out.println("Service HelloExceptions lie au registre");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
