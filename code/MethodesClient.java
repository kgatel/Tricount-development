
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MethodesClient extends Remote {
	public float GetEquilibre(Personne Pers) throws RemoteException;
	public Depense AddDepense(int id, String Com, Personne acheteur, float Val, Personne receveur) throws RemoteException;
	
}
