import java.rmi.RemoteException;

public class DepenseImpl implements Depense {
   private int id;
   private String com;
   private int acheteur;
   private float valeur;
   private int receveur;

   public DepenseImpl(int id, String com, int acheteur,float valeur,int receveur){
	this.id = id;
	this.com = com;
	this.acheteur = acheteur;
	this.valeur = valeur;
	this.receveur = receveur;
	}
   public int getId() {
	   return this.id;
   }
   
   public void setId(int id){
	this.id = id;
	}
   
   public int getAcheteur(){
	return this.acheteur;
	}
   
   public int getReceveur(){
	return this.receveur;
	}
   
   public void setAcheteur(int acheteur){
	this.acheteur = acheteur;
	}
   
   public void setReceveur(int receveur){
	this.receveur = receveur;
	}
   
   public void setValeur(float valeur){
	this.valeur = valeur;
	}
   
   public float getValeur(){
	return this.valeur;
	}
   
   public void setCom(String com){
	this.com = com;
	}
   
   public String getCom(){
	return this.com;
	}

	public String toText(){
		return this.id + " : " + this.getCom() + " montant : " + this.getValeur() + " payé par "+this.getAcheteur()+" pour "+this.getReceveur();
	}
}
