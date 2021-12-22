
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Depense extends Remote {
   public int getAcheteur() throws RemoteException;
   public int getReceveur() throws RemoteException;
   public void setAcheteur(int acheteur) throws RemoteException;
   public void setReceveur(int receveur) throws RemoteException;
   public void setValeur(float valeur) throws RemoteException;
   public float getValeur() throws RemoteException;
   public void setId(int id) throws RemoteException;
   public int getId() throws RemoteException;
   public void setCom(String com) throws RemoteException;
   public String getCom() throws RemoteException;
   public String toText() throws RemoteException;

}
