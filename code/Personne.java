
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Personne extends Remote {
   public String getName() throws RemoteException;
   public void setName(String nom) throws RemoteException;
}
