import javax.swing.*;

public class ihm {
	public static Personne[] pers = {new PersonneImpl(), new PersonneImpl(), new PersonneImpl(), new PersonneImpl(), new PersonneImpl(), new PersonneImpl()};
	public static int nb_participants=0;

	public static void main(String[] args){
		
		//ICI ON SE CONNECTE

		//TESSSSSST
		System.out.println("Début du test");
		pers[1] = new PersonneImpl("Paul");
		pers[2] = new PersonneImpl("Jack");
		pers[3] = new PersonneImpl("Eugène");
		pers[4] = new PersonneImpl("Michèle");
		nb_participants = 4;
		System.out.println("Fin du test");

		
		//Fin TESSSSSST

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre SimpleFenetre
				//FenetrePrincipale fenetre = new FenetrePrincipale();
				//fenetre.setVisible(true);//On la rend visible
				FenetreDepense fenetredep = new FenetreDepense(pers,nb_participants);
				fenetredep.setVisible(true);//On la rend visible
			}
		});
	
	}
}