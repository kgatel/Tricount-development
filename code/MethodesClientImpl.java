import java.rmi.RemoteException;

public class MethodesClientImpl implements MethodesClient {
   public String sayHelloAndChangeName(Guy aGuy) throws RemoteException {
      String name = aGuy.getName();
      System.out.println("Request from a guy: " + name);
      aGuy.setName("Bob Leponge");
      return "Bonjour " + name;
    }
}