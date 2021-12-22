
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Tricount extends Remote {
	public void GetEquilibre(Personne[] Pers) throws RemoteException;
	public void AddDepense(int id, String Com, int acheteur, float Val, int[] receveur, int nb_receveur) throws RemoteException;
	public boolean Connexion (String prenom) throws RemoteException;

}
