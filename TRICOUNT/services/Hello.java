
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	public Int GetEquilibre(Personne Pers) throws RemoteException;
	public void AddDepense(Int id, String Com, Personne acheteur, Int Val, Personne receveur) throws RemoteException;
	
}
