import java.rmi.RemoteException;

public class TricountImpl implements Tricount {
	public Personne[] participant;
	public Depense[] depenses;
	public int nb_participants=0;
	public int nb_depenses=0;

	@Override
	public void GetEquilibre(Personne[] pers) throws RemoteException {
		for (int i=0; i<nb_participants ; i++) {
			pers[i].setId(participant[i].getId());
			pers[i].setName(participant[i].getName());
			pers[i].setSolde(participant[i].getSolde());
			// pers[i]=participant[i]; voir si ça foncitonne juste avec cette ligne de commande 
		}
	}

	@Override
	public void AddDepense(int id, String com, int acheteur, float val, int[] receveur, int nb_receveur) throws RemoteException {
		for (int i=0; i<nb_receveur; i++){
			depenses[nb_depenses] = new DepenseImpl(id, com, acheteur, val, receveur[i]);
			nb_depenses++;
			participant[receveur[i]].setSolde(participant[receveur[i]].getSolde()-val);
			participant[acheteur].setSolde(participant[acheteur].getSolde()+val);
		}
	}

	@Override
	public boolean Connexion(String prenom) throws RemoteException {
		if (nb_participants < 6) {
			System.out.println("Une Nouvelle Personne vient de se connecter: " + prenom);
			participant[nb_participants] = new PersonneImpl(prenom);
			nb_participants++;
			return true;
		}else{
			System.out.println("Connection refusée de: " + prenom);
			return false;
		}
	}
  
}