
import java.io.Serializable;

public class PersonneImpl implements Personne, Serializable {
   private String nom;
   private int id;
   private double solde;
   
//constructeurs
   
   public PersonneImpl() {
	   this.id=0;
	   this.nom="";
	   this.solde=(double) 0.0;
   }
   
   public PersonneImpl(String name) {
	   this.id=0;
	   this.nom=name;
	   this.solde=(double) 0.0;
   }
   
   public PersonneImpl(String name, int i) {
	   this.id=i;
	   this.nom=name;
	   this.solde=(double) 0.0;
   }

   
//accesseurs
   public int getId() {
	return id;
   }

   public void setId(int id) {
		this.id = id;
   }
	
   public double getSolde() {
		return solde;
   }
	
   public void setSolde(double solde) {
		this.solde = solde;
   }

   public String getName() {
		return nom;
   }
	
   public void setName(String nom) {
		this.nom = nom;
   }
   
//méthodes
   public String toText(){
   	return (this.getId() + " : " + this.getName() + " a un solde de " + this.getSolde());
   }
   
}	   
