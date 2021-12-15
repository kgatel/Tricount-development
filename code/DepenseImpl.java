
public class DepenseImpl implements Depense {
   private Int id;
   private String com;
   private Personne acheteur;
   private Int valeur;
   private Personne receveur;

   public PersonneImpl(Int id, String com, Personne acheteur,Int valeur,Personne receveur){
	this.id = id;
	this.com = com;
	this.acheteur = acheteur;
	this.valeur = valeur;
	this.receveur = receveur;
	}
   public void setId(Int id){
	this.valeur = valeur;
	}
   public Int getId(){
	return this.id;
	}
   public Personne getAcheteur(){
	return this.acheteur;
	}
   public Personne getReceveur(){
	return this.nom;
	}
   public void setAcheteur(Personne acheteur){
	this.acheteur = acheteur;
	}
   public void setReceveur(Personne receveur){
	this.receveur = receveur;
	}
   public void setValeur(Int valeur){
	this.valeur = valeur;
	}
   public Int getValeur(){
	return this.valeur;
	}
   public void setCom(String com){
	this.com = com;
	}
   public String getCom(){
	return this.com;
	}
}
