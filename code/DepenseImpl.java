import java.rmi.RemoteException;

public class DepenseImpl implements Depense {
   private int id;
   private String com;
   private Personne acheteur;
   private float valeur;
   private Personne receveur;

   public DepenseImpl(int id, String com, Personne acheteur,float valeur,Personne receveur){
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
   
   public Personne getAcheteur(){
	return this.acheteur;
	}
   
   public Personne getReceveur(){
	return this.receveur;
	}
   
   public void setAcheteur(Personne acheteur){
	this.acheteur = acheteur;
	}
   
   public void setReceveur(Personne receveur){
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
}
