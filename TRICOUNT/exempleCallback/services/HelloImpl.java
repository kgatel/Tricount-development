
import java.rmi.RemoteException;

public class HelloImpl implements Hello {
   public String sayHelloAndChangeName(Guy aGuy) throws RemoteException {
      String name = aGuy.getName();
      System.out.println("Request from a guy: " + name);
      aGuy.setName("Bob Leponge");
      return "Bonjour " + name;
    }
}
