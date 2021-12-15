
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Depense extends Remote {
   public Personne getAcheteur() throws RemoteException;
   public Personne getReceveur() throws RemoteException;
   public void setAcheteur(Personne acheteur) throws RemoteException;
   public void setReceveur(Personne receveur) throws RemoteException;
   public void setValeur(Int valeur) throws RemoteException;
   public Int getValeur() throws RemoteException;
   public void setId(Int id) throws RemoteException;
   public Int getId() throws RemoteException;
   public void setCom(String com) throws RemoteException;
   public String getCom() throws RemoteException;

}
