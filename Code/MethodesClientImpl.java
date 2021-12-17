import java.rmi.RemoteException;

public class MethodesClientImpl implements MethodesClient {

	@Override
	public float GetEquilibre(Personne pers) throws RemoteException {
		return pers.getSolde();
	}

	@Override
	public Depense AddDepense(int id, String com, Personne acheteur, float val, Personne receveur) throws RemoteException {
		Depense depense = new DepenseImpl(id,com,acheteur,val,receveur);
		return depense;		
	}

	@Override
	public boolean Connexion(String prenom) throws RemoteException {
		AddPersonne(prenom);
		return false;
	}
  
}