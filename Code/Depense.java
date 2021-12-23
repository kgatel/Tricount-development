
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Depense extends Remote {
   public int getAcheteurID() throws RemoteException;
   public int getReceveurID() throws RemoteException;
   public void setAcheteurID(int acheteur) throws RemoteException;
   public void setReceveurID(int receveur) throws RemoteException;
   public void setValeur(double valeur) throws RemoteException;
   public double getValeur() throws RemoteException;
   public void setId(int id) throws RemoteException;
   public int getId() throws RemoteException;
   public void setCom(String com) throws RemoteException;
   public String getCom() throws RemoteException;
   public String toText() throws RemoteException;

}
