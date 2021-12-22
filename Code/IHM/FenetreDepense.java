import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class FenetreDepense extends JFrame {
		public static Personne[] pers = {new PersonneImpl(), new PersonneImpl(), new PersonneImpl(), new PersonneImpl(), new PersonneImpl(), new PersonneImpl()};
		public static int nb_participants=0;

		public FenetreDepense(Personne[] participant,int nb_participants){
			super();
			for (int i=0; i<nb_participants ; i++) {
				try {
					pers[i].setId(participant[i].getId());
					pers[i].setName(participant[i].getName());
					pers[i].setSolde(participant[i].getSolde());
					// pers[i]=participant[i]; voir si ça foncitonne juste avec cette ligne de commande 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				System.out.println(pers[3].toText());
			} catch (Exception e) {
				e.printStackTrace();
			}
			build();//On initialise notre fenêtre
		}
		
		private void build(){
			setTitle("Ajouter une Dépenses"); //On donne un titre à l'application
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
			JLabel Titre = new JLabel("<html><h3>Ajouter un dépense</h3></html>" );
			
			Nord.setBackground(Color.LIGHT_GRAY);
			Nord.add(Titre);
			
			//Création Centre
			JPanel Centre = new JPanel();
			Centre.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreCentre = new JLabel("<html><h3>Pour qui:</h3></html>");
				TitreCentre.setBorder(cadre);
				TitreCentre.setHorizontalAlignment(SwingConstants.CENTER);
				
				//Checkbox de Nom
				JPanel CheckboxNom = new JPanel();
				CheckboxNom.setLayout(new BoxLayout(CheckboxNom, BoxLayout.Y_AXIS));		
				CheckboxNom.setBorder(cadre);
				
				JCheckBox[] listcheckbox = {new JCheckBox("TEST"), new JCheckBox(), new JCheckBox(), new JCheckBox(), new JCheckBox(), new JCheckBox()};
				
				for (int i=0;i<nb_participants;i++) {
					try {
						listcheckbox[i].setText(pers[i].getName());
					} catch (Exception e) {
						e.printStackTrace();
					}

					listcheckbox[i].setSelected(false);
					CheckboxNom.add(listcheckbox[i]);
				}
				CheckboxNom.add(listcheckbox[0]);
				CheckboxNom.add(new JCheckBox("Bite"));
				CheckboxNom.add(new JCheckBox("Bite"));
				

				
			Centre.add(TitreCentre,BorderLayout.NORTH);
			Centre.add(CheckboxNom,BorderLayout.CENTER);
			Centre.setBackground(Color.WHITE);
			
			//Création Est
			JPanel Est = new JPanel();
			Est.setBackground(Color.WHITE);
			Est.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreEst = new JLabel("<html><h3>Info:</h3></html>");
				TitreEst.setBorder(cadre);
				TitreEst.setHorizontalAlignment(SwingConstants.CENTER);
				/*
				// Fields du centre
				JPanel FieldDepense = new JPanel();
				FieldDepense.setLayout(new BoxLayout(CheckboxNom, BoxLayout.Y_AXIS));
				FieldDepense.setBorder(cadre);

				JTextField textCommentaire = new JTextField("Commentaire", 20);
				JTextField textPrix = new JTextField("€", 20);
				FieldDepense.add(textCommentaire);
				FieldDepense.add(textPrix);
				*/
				//Boutons
				JButton BoutonAjouterDepense = new JButton(new DepenseAction(this, "<html><h4>Ajouter la dépense</h4></html>"));
				
			Est.add(TitreEst,BorderLayout.NORTH);
			//Est.add(FieldDepense,BorderLayout.CENTER);
			Est.add(BoutonAjouterDepense,BorderLayout.SOUTH);
			
			//Ajout Panel Principal
			panel.setBackground(Color.WHITE);
			panel.add(Nord,BorderLayout.NORTH);
			panel.add(Centre,BorderLayout.CENTER);
			panel.add(Est,BorderLayout.EAST);
			
			
			return panel;
		}	
	}
