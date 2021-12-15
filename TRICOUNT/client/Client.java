import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;
      try {
      Registry registry = LocateRegistry.getRegistry(machine, port);
      Hello obj = (Hello)registry.lookup("HelloExceptions");
      if (args.length == 1)
		if (args[0].equals("division"))
			obj.divisionParZero();
		else 	System.out.println(obj.sayHello(args[0]));
	 else 	System.out.println(obj.sayHello(""));
	
    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
