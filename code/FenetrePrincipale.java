import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class FenetrePrincipale extends JFrame{
		public FenetrePrincipale(){
			super();
			
			build();//On initialise notre fenêtre
		}
		
		private void build(){
			setTitle("Tricount"); //On donne un titre à l'application
			setSize(820,540); //On donne une taille à notre fenêtre
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); //On interdit la redimensionnement de la fenêtre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
			setContentPane(buildContentPane());
		}
		
		
		private JPanel buildContentPane(){
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
			panel.setLayout(new BorderLayout(10,10));
			Border cadre = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			
			//Création Nord
			JPanel Nord = new JPanel();
			JLabel Titre = new JLabel("<html><h2>TRICOUNT</h2></html>" );
			
			Nord.setBackground(Color.LIGHT_GRAY);
			Nord.add(Titre);
			
			//Création Centre
			JPanel Centre = new JPanel();
			Centre.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreCentre = new JLabel("<html><h3>3 Dernières dépenses:</h3></html>");
				TitreCentre.setBorder(cadre);
				TitreCentre.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel Depenses = new JLabel("<html>" +
						"<h3>Paul : 45€ Pizza</h3><h5>&nbsp; &nbsp; Paul,Michel,Eugène</h5>" +
						"<br><br>" +
						"<h3>Michel : 12€ Glaces</h3><h5>&nbsp; &nbsp; Michel,Jean</h5>" + 
						"<br><br>" +
						"<h3>Jean : 27€ Saucissons</h3><h5>&nbsp; &nbsp; Michel,Eugène</h5>" +
						"</html>");
				Depenses.setBorder(cadre);
				
				//Bouton Actualiser
				JButton BoutonActualiser = new JButton(new ActualiserAction(this, "<html><h3>Demander l'équilibre</h3></html>"));
			
			Centre.add(TitreCentre,BorderLayout.NORTH);
			Centre.add(Depenses,BorderLayout.CENTER);
			Centre.add(BoutonActualiser,BorderLayout.SOUTH);
			Centre.setBackground(Color.WHITE);
			
			//Création Est
			JPanel Est = new JPanel();
			Est.setBackground(Color.WHITE);
			Est.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreEst = new JLabel("<html><h3>Equilibre:</h3></html>");
				TitreEst.setBorder(cadre);
				TitreEst.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel equilibre = new JLabel("<html>" +
						"<h3>Paul : 30€ </h3>" +
						"<h3>Michel : -22.5€ </h3>" +
						"<h3>Jean : 21€ </h3>" +
						"<h3>Eugène : -13.5€ </h3>" +
						"<h3>Edouard : 0€ </h3>" +
						"<h3>Maurice : 0€ </h3>" +
						"</html>");
				equilibre.setBorder(cadre);
				
				//Boutons
				JPanel BouttonSud = new JPanel();
				BouttonSud.setLayout(new BorderLayout());
				JButton BoutonDepense = new JButton(new DepenseAction(this, "<html><h4>Ajouter Depenses</h4></html>"));
				JButton BoutonRembourser = new JButton(new RembourserAction(this, "<html><h4>Rembourser</h4></html>"));
				BouttonSud.add(BoutonDepense,BorderLayout.NORTH);
				BouttonSud.add(BoutonRembourser,BorderLayout.SOUTH);
				
			Est.add(TitreEst,BorderLayout.NORTH);
			Est.add(equilibre,BorderLayout.CENTER);
			Est.add(BouttonSud,BorderLayout.SOUTH);
			
			//Ajout Panel Principal
			panel.setBackground(Color.WHITE);
			panel.add(Nord,BorderLayout.NORTH);
			panel.add(Centre,BorderLayout.CENTER);
			panel.add(Est,BorderLayout.EAST);
			
			
			return panel;
		}	
	}
