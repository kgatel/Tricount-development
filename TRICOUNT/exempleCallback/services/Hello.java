
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
   public String sayHelloAndChangeName(Guy aGuy) throws RemoteException;
}
