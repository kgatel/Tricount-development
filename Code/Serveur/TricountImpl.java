import java.rmi.RemoteException;
import java.util.ArrayList;

public class TricountImpl implements Tricount {
	
	private ArrayList<Personne> participant;
	private ArrayList<Depense> depenses;
	
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
	public void AddDepense(int id, String com, int acheteurID, double val, int[] receveurID) throws RemoteException {
		
		//Division de la somme par le nombre de participant
		double montant=val*100/receveurID.length;
		//troncature 2chiffres après la virgule
		int tmp=(int) (montant);
		montant =(double) tmp/100;
				
		for (int i=0; i<receveurID.length; i++){
			this.depenses.add(new DepenseImpl(id, com, acheteurID, val, receveurID[i]));
			this.participant.get(receveurID[i]).setSolde(participant.get(receveurID[i]).getSolde()-montant);
			this.participant.get(acheteurID).setSolde(participant.get(acheteurID).getSolde()+montant);
		}
	System.out.println("Dépense ajoutée");
	}

	@Override
	public boolean Connexion(Personne pers) throws RemoteException {
		if (participant.size() < 6) {
			System.out.println("Une Nouvelle Personne vient de se connecter: " + pers.getName());
			int i = participant.size();
			participant.add(new PersonneImpl(pers.getName(),i));
			pers.setId(i);
			return true;
		} else {
			System.out.println("Connection refusée de: " + pers.getName());
			return false;
		}
	}



	@Override
	public ArrayList<Personne> GetParticipants() throws RemoteException {
		return this.participant ;
	}



	@Override
	public ArrayList<Depense> GetDepense() throws RemoteException {
		return this.depenses;
	}
  
}

