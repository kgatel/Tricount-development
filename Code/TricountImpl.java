import java.rmi.RemoteException;
import java.util.ArrayList;

public class TricountImpl implements Tricount {
	public ArrayList<Personne> participant;
	public ArrayList<Depense> depenses;
	
	public TricountImpl() throws RemoteException {
		this.participant=new ArrayList<Personne>();
		this.depenses=new ArrayList<Depense>();
	}

	
	
	public TricountImpl(Personne[] participants) throws RemoteException {
		this.participant=new ArrayList<Personne>();
		for (int i=0;i<participants.length;i++) {
			this.participant.add(participants[i]);
		}
		this.depenses=new ArrayList<Depense>();
	}
	
	@Override
	public void GetEquilibre(Personne[] pers) throws RemoteException {
		for (int i=0; i<pers.length ; i++) {
			pers[i].setId(participant.get(i).getId());
			pers[i].setName(participant.get(i).getName());
			pers[i].setSolde(participant.get(i).getSolde());
			// pers[i]=participant[i]; voir si ça foncitonne juste avec cette ligne de commande 
		}
	}

	@Override
	public void AddDepense(int id, String com, int acheteur, float val, int[] receveur, int nb_receveur) throws RemoteException {
		for (int i=0; i<nb_receveur; i++){
			depenses.add(new DepenseImpl(id, com, acheteur, val, receveur[i]));
			participant.get(receveur[i]).setSolde(participant.get(receveur[i]).getSolde()-val);
			participant.get(acheteur).setSolde(participant.get(acheteur).getSolde()+val);
		}
	}

	@Override
	public boolean Connexion(String prenom) throws RemoteException {
		if (participant.size() < 6) {
			System.out.println("Une Nouvelle Personne vient de se connecter: " + prenom);
			participant.add(new PersonneImpl(prenom));
			return true;
		}else{
			System.out.println("Connection refusée de: " + prenom);
			return false;
		}
	}



	@Override
	public ArrayList<Personne> GetParticipants() throws RemoteException {
		// TODO Auto-generated method stub
		return this.participant;
	}



	@Override
	public ArrayList<Depense> GetDepense() throws RemoteException {
		// TODO Auto-generated method stub
		return this.depenses;
	}
  
}
