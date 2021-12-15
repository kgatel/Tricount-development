import javax.swing.*;

public class ihm {
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre SimpleFenetre
				FenetrePrincipale fenetre = new FenetrePrincipale();
				fenetre.setVisible(true);//On la rend visible
			}
		});
	
	}
}