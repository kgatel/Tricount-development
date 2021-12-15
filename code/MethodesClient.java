
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MethodesClient extends Remote {
	public int GetEquilibre(Personne Pers) throws RemoteException;
	public void AddDepense(int id, String Com, Personne acheteur, int Val, Personne receveur) throws RemoteException;
	
}
