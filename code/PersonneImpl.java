
public class PersonneImpl1 implements Personne {
   private String nom;
   private int id;
   private float solde;
   
//constructeurs
   
   public PersonneImpl1() {
	   this.id=0;
	   this.nom="";
	   this.solde=(float) 0.0;
   }
   
   public PersonneImpl1(String name) {
	   this.id=0;
	   this.nom=name;
	   this.solde=(float) 0.0;
   }

   
//accesseurs
   public int getId() {
	return id;
   }

   public void setId(int id) {
		this.id = id;
   }
	
   public float getSolde() {
		return solde;
   }
	
   public void setSolde(float solde) {
		this.solde = solde;
   }
	
   public PersonneImpl(String nom){
		this.nom = nom;
   }

   public String getName() {
		return nom;
   }
	
   public void setName(String nom) {
		this.nom = nom;
   }
   
//méthodes
   
   
}	   
