

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
	System.out.println("Taille du tableau de dépense : "+this.GetDepense().size());
	}

	@Override
	public boolean Connexion(Personne pers) throws RemoteException {
		if (participant.size() < 6) {
			int i = participant.size();
			participant.add(new PersonneImpl(pers.getName(),i));
			pers.setId(i);
			System.out.println("Une Nouvelle Personne vient de se connecter: " + pers.getName());
			System.out.println("Taille du tableau de personne : "+this.GetParticipants().size());
			return true;
		} else {
			System.out.println("Connection refusée de: " + pers.getName());
			return false;
		}
	}

	private Personne trouverPersonne (int id) throws RemoteException {
		Personne res = null;
		for (int i=0;i<this.GetParticipants().size();i++) {
			if (id==this.GetParticipants().get(i).getId()) {
				res=this.GetParticipants().get(i);
			}
		}
		return res;
	}

	public String affichage3Depenses() throws RemoteException {
		String res="";
		int indice = this.GetDepense().size()-1;
		int indice2 = 0;
		while (indice2<3 && indice>=0) {
			res+="<html>"+"<h3>"+trouverPersonne(this.GetDepense().get(indice).getAcheteurID()).getName()+" : ";
			res+=this.GetDepense().get(indice).getValeur()+"€ "+"<i>"+this.GetDepense().get(indice).getCom()+"</i></h3><h5>&nbsp; &nbsp; ";
			res+=trouverPersonne(this.GetDepense().get(indice).getReceveurID()).getName();
			int id=this.GetDepense().get(indice).getId();
			while ((indice-1>=0)&&(this.GetDepense().get(indice-1).getId()==id)){
				indice--;
				res+=","+trouverPersonne(this.GetDepense().get(indice).getReceveurID()).getName();
			}
			res+="</h5>";
			if (indice2 != 2) {
				res+="<br><br>";
			}
			indice--;
			indice2++;
		}
		return res;
	}

	public String affichageEquilibre() throws RemoteException {
		String res="<html>";
		int indice = 0;
		while (indice<this.GetParticipants().size()) {
			res+="<h3>"+this.GetParticipants().get(indice).getName()+" : "+this.GetParticipants().get(indice).getSolde()+"</h3>";
			indice++;
		}
		res+="</html>";
		return res;
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

