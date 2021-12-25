import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class FenetreDepense extends JFrame{
		
		public ArrayList<Personne> participant;
		private JTextArea saisieMontant,saisieCommentaire;
		private ArrayList<JCheckBox> listcheckbox;

		public FenetreDepense(ArrayList<Personne> participant){
			super();
			this.participant=participant;
			saisieMontant=null;
			saisieCommentaire=null;
			listcheckbox=new ArrayList<JCheckBox>();
			build();//On initialise notre fenêtre
		}
		
		public ArrayList<Personne> getParticipant() {
			return participant;
		}

		public void setParticipant(ArrayList<Personne> participant) {
			this.participant = participant;
		}

		public JTextArea getSaisieMontant() {
			return saisieMontant;
		}

		public void setSaisieMontant(JTextArea saisieMontant) {
			this.saisieMontant = saisieMontant;
		}

		public JTextArea getSaisieCommentaire() {
			return saisieCommentaire;
		}

		public void setSaisieCommentaire(JTextArea saisieCommentaire) {
			this.saisieCommentaire = saisieCommentaire;
		}
		
		public ArrayList<JCheckBox> getListcheckbox() {
			return listcheckbox;
		}

		public void setListcheckbox(ArrayList<JCheckBox> listcheckbox) {
			this.listcheckbox = listcheckbox;
		}
		
		
		private void build(){
			setTitle(""); //On donne un titre à l'application
			setSize(820,540); //On donne une taille à notre fenêtre
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); //On interdit la redimensionnement de la fenêtre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
			setContentPane(buildContentPane());
		}
		
		
		private JPanel buildContentPane() {
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
			panel.setLayout(new BorderLayout(10,10));
			Border cadre = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			
			//Création Nord
			JPanel Nord = new JPanel();
			JLabel Titre = new JLabel("<html><h3>Ajouter une dépense</h3></html>" );
			
			Nord.setBackground(new Color(246,209,216));
			Nord.add(Titre);
			
			//Création Centre
			JPanel Centre = new JPanel();
			Centre.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			Centre.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreCentre = new JLabel("<html><h3>Pour qui :</h3></html>");
				TitreCentre.setBackground(new Color(255,183,244));
				TitreCentre.setBorder(cadre);
				TitreCentre.setHorizontalAlignment(SwingConstants.CENTER);
				
				//Checkbox de Nom
				JPanel CheckboxNom = new JPanel();
				CheckboxNom.setBackground(Color.white);
				CheckboxNom.setLayout(new BoxLayout(CheckboxNom, BoxLayout.Y_AXIS));		
				CheckboxNom.setBorder(cadre);
				
								
				for (int i=0;i<participant.size();i++) {
					try {
						listcheckbox.add(new JCheckBox("<html><h3>"+participant.get(i).getName()+"</h3></html>"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					listcheckbox.get(i).setSelected(false);
					CheckboxNom.add(listcheckbox.get(i));
				}
				
				

				
			Centre.add(TitreCentre,BorderLayout.NORTH);
			Centre.add(CheckboxNom,BorderLayout.CENTER);
			Centre.setBackground(Color.WHITE);
			
			//Création Est
			JPanel Est = new JPanel();
			Est.setBackground(Color.WHITE);
			Est.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			Est.setLayout(new BorderLayout(10,10));
			
			
			JPanel EstNord = new JPanel();
			EstNord.setBackground(Color.WHITE);
			EstNord.setLayout(new BorderLayout(10,10));
			EstNord.setBorder(cadre);
				
				JLabel TitreEstNord = new JLabel("<html><h3>Montant</h3></html>");
				TitreEstNord.setBackground(new Color(255,183,244));
				TitreEstNord.setBorder(cadre);
				TitreEstNord.setHorizontalAlignment(SwingConstants.CENTER);
				
				this.saisieMontant = new JTextArea(3,3);
				saisieMontant.setText("-> ");
			
				
			EstNord.add(TitreEstNord,BorderLayout.NORTH);
			EstNord.add(this.saisieMontant,BorderLayout.CENTER);
				
			JPanel EstCentre = new JPanel();
			EstCentre.setBackground(Color.WHITE);
			EstCentre.setLayout(new BorderLayout(10,10));
			EstCentre.setBorder(cadre);
				
			JLabel TitreEstCentre = new JLabel("<html><h3>Commentaire</h3></html>");
				TitreEstCentre.setBackground(new Color(255,183,244));
				TitreEstCentre.setBorder(cadre);
				TitreEstCentre.setHorizontalAlignment(SwingConstants.CENTER);
				
			
			EstCentre.add(TitreEstCentre,BorderLayout.NORTH);
				

				JLabel Euro = new JLabel("<html><h3>€</h3></html>");
				Euro.setHorizontalAlignment(SwingConstants.CENTER);
			
				this.saisieCommentaire = new JTextArea(10,25);
				saisieCommentaire.setText("-> ");
				
				
			//EstCentre.add(texte,BorderLayout.CENTER);
			EstNord.add(Euro,BorderLayout.EAST);
			EstCentre.add(this.saisieCommentaire,BorderLayout.CENTER);
					
				
			
			Boutton BoutonAjouterDepense = new Boutton(new AjouterDepenseAction2(this, "<html><h4>Ajouter la dépense</h4></html>"),new Color(246,209,216));
				
			Est.add(EstNord,BorderLayout.NORTH);
			Est.add(EstCentre,BorderLayout.CENTER);
			Est.add(BoutonAjouterDepense,BorderLayout.SOUTH);
			
			//Ajout Panel Principal
			panel.setBackground(Color.GRAY);
			panel.add(Nord,BorderLayout.NORTH);
			panel.add(Centre,BorderLayout.CENTER);
			panel.add(Est,BorderLayout.EAST);
			
			
			return panel;
		}

	}
