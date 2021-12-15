
public class PersonneImpl implements Personne {
   private String nom;

   public PersonneImpl(String nom){
	this.nom = nom;
	}
   public String getName(){
	return this.nom;
	}
   public void setName(String name){
	this.nom = nom;
	}
}
