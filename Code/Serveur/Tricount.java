
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Tricount extends Remote {
	public void AddDepense(int id, String Com, int acheteur, double Val, int[] receveur) throws RemoteException;
	public boolean Connexion (Personne pers) throws RemoteException;
	public ArrayList<Personne> GetParticipants() throws RemoteException;
	public ArrayList<Depense> GetDepense() throws RemoteException;
}
