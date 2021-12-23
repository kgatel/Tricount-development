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
      Tricount stub = (Tricount)UnicastRemoteObject.exportObject(new TricountImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      if(!Arrays.asList(registry.list()).contains("Tricountdesfamilles"))
          registry.bind("Tricountdesfamilles", stub);
      else
          registry.rebind("Tricountdesfamilles", stub);
      System.out.println("Serveur lancé sous le nom Tricountdesfamilles");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}