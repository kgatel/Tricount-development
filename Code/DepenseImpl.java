import java.rmi.RemoteException;

public class DepenseImpl implements Depense {
   private int id;
   private String com;
   private int acheteurID;
   private double valeur;
   private int receveurID;

   public DepenseImpl(int id, String com, int acheteur,double d,int receveur){
	this.id = id;
	this.com = com;
	this.acheteurID = acheteur;
	this.valeur = d;
	this.receveurID = receveur;
	}
   public int getId() {
	   return this.id;
   }
   
   public void setId(int id){
	this.id = id;
	}
   
   public int getAcheteurID(){
	return this.acheteurID;
	}
   
   public int getReceveurID(){
	return this.receveurID;
	}
   
   public void setAcheteurID(int acheteurID){
	this.acheteurID = acheteurID;
	}
   
   public void setReceveurID(int receveurID){
	this.receveurID = receveurID;
	}
   
   public void setValeur(double valeur){
	this.valeur = valeur;
	}
   
   public double getValeur(){
	return this.valeur;
	}
   
   public void setCom(String com){
	this.com = com;
	}
   
   public String getCom(){
	return this.com;
	}

	public String toText(){
		return this.id + " : " + this.getCom() + " montant : " + this.getValeur() + " payé par "+this.getAcheteurID()+" pour "+this.getReceveurID();
	}
}
