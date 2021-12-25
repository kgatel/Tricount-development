
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Tricount extends Remote {
	public void GetEquilibre(Personne[] Pers) throws RemoteException;
	public void AddDepense(int id, String Com, int acheteur, float Val, int[] receveur, int nb_receveur) throws RemoteException;
	public boolean Connexion (String prenom) throws RemoteException;
	public ArrayList<Personne> GetParticipants() throws RemoteException;
	public ArrayList<Depense> GetDepense() throws RemoteException;
	public boolean Clone(Tricount tri) throws RemoteException;
}
