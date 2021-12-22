
public class PersonneImpl implements Personne {
   private String nom;
   private int id;
   private float solde;
   
//constructeurs
   
   public PersonneImpl() {
	   this.id=0;
	   this.nom="";
	   this.solde=(float) 0.0;
   }
   
   public PersonneImpl(String name) {
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
