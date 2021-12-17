
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Depense extends Remote {
   public Personne getAcheteur() throws RemoteException;
   public Personne getReceveur() throws RemoteException;
   public void setAcheteur(Personne acheteur) throws RemoteException;
   public void setReceveur(Personne receveur) throws RemoteException;
   public void setValeur(float valeur) throws RemoteException;
   public float getValeur() throws RemoteException;
   public void setId(int id) throws RemoteException;
   public int getId() throws RemoteException;
   public void setCom(String com) throws RemoteException;
   public String getCom() throws RemoteException;

}
