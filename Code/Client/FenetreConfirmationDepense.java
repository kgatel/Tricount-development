


import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


public class FenetreConfirmationDepense extends JFrame implements ItemListener{
	
		private FenetreDepense fenetreDepense;
		private double montant;
		private String commentaire;
		private Personne[] personneTab;

		public FenetreConfirmationDepense(FenetreDepense fenetreDepense,double montant,String commentaire,Personne[] personneTab) throws RemoteException{
			super();
			this.fenetreDepense=fenetreDepense;
			this.montant=montant;
			this.commentaire=commentaire;
			this.personneTab=personneTab;
			build();//On initialise notre fenêtre
		}
		
		public FenetreDepense getFenetreDepense() {
			return fenetreDepense;
		}


		public void setFenetreDepense(FenetreDepense fenetreDepense) {
			this.fenetreDepense = fenetreDepense;
		}


		public double getMontant() {
			return montant;
		}

		public void setMontant(double montant) {
			this.montant = montant;
		}

		public String getCommentaire() {
			return commentaire;
		}

		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}

		public Personne[] getPersonneTab() {
			return personneTab;
		}

		public void setPersonneTab(Personne[] personneTab) {
			this.personneTab = personneTab;
		}

		private void build() throws RemoteException{
			//setTitle("Rembourser"); //On donne un titre à l'application
			setSize(600,400); //On donne une taille à notre fenêtre
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); //On interdit la redimensionnement de la fenêtre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
			setContentPane(buildContentPane());
		}
		
	
		private JPanel buildContentPane() throws RemoteException{
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
			panel.setLayout(new BorderLayout(10,10));
			Border cadre = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			
			//Création Nord
			JPanel Nord = new JPanel();
				JLabel Titre = new JLabel("<html><h3>Confirmation Dépense</h3></html>" );
			
				Nord.setBackground(new Color(246,209,216));
				Nord.add(Titre);
			
			//Création Centre
			JPanel Centre = new JPanel();
				Centre.setBackground(Color.WHITE);
				Centre.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
				Centre.setLayout(new BorderLayout(10,10));
					//Text Centre
					JLabel TitreCentre = new JLabel("<html><h3>Pour qui :</h3></html>");
					TitreCentre.setBackground(new Color(255,183,244));
					TitreCentre.setBorder(cadre);
					TitreCentre.setHorizontalAlignment(SwingConstants.CENTER);
				
					//Checkbox de Nom
					JLabel ListeReceveur = new JLabel(this.affichageReceveur());
							
			Centre.add(TitreCentre,BorderLayout.NORTH);
			Centre.add(ListeReceveur,BorderLayout.CENTER);
			
			
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
					
						JLabel Montant = new JLabel("<html><h3>"+this.montant+"</h3></html>");
						Montant.setHorizontalAlignment(SwingConstants.CENTER);
				
						JLabel Euro = new JLabel("<html><h3>€</h3></html>");
						Euro.setHorizontalAlignment(SwingConstants.CENTER);
						
				EstNord.add(TitreEstNord,BorderLayout.NORTH);	
				EstNord.add(Montant,BorderLayout.CENTER);
				EstNord.add(Euro,BorderLayout.EAST);

			
				JPanel EstCentre = new JPanel();
				EstCentre.setBorder(cadre);
				EstCentre.setBackground(Color.WHITE);
				EstCentre.setLayout(new BorderLayout(10,10));
					JLabel TitreEstCentre = new JLabel("<html><h3>Commentaire</h3></html>");
					TitreEstCentre.setBackground(new Color(255,183,244));
					TitreEstCentre.setBorder(cadre);
					TitreEstCentre.setHorizontalAlignment(SwingConstants.CENTER);
			
					JLabel Commentaire = new JLabel("<html><h3>"+this.commentaire+"</h3></html>");
					Commentaire.setHorizontalAlignment(SwingConstants.CENTER);
			
			
				EstCentre.add(TitreEstCentre,BorderLayout.NORTH);
				EstCentre.add(Commentaire,BorderLayout.CENTER);
					
				JPanel EstSud = new JPanel();
					Boutton BoutonConfirmerDepense = new Boutton(new ConfirmerDepenseAction(this, "<html><h4>Confirmer</h4></html>"),new Color(246,209,216));
					Boutton BoutonAnnulerDepense = new Boutton(new AnnulerAction(this),new Color(190,190,190));
				EstSud.add(BoutonConfirmerDepense,BorderLayout.CENTER);
				EstSud.add(BoutonAnnulerDepense,BorderLayout.SOUTH);
					
			Est.add(EstNord,BorderLayout.NORTH);
			Est.add(EstCentre,BorderLayout.CENTER);
			Est.add(EstSud,BorderLayout.SOUTH);
			
			//Ajout Panel Principal
			panel.setBackground(Color.GRAY);
			panel.add(Nord,BorderLayout.NORTH);
			panel.add(Centre,BorderLayout.CENTER);
			panel.add(Est,BorderLayout.EAST);
			
			
			return panel;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		private String affichageReceveur() throws RemoteException {
			String res="<html>";
			for (int i=0;i<personneTab.length;i++) {
				res+="<h3>"+" - "+this.personneTab[i].getName()+"</h3>";
			}
			res+="</html>";
			return res;
		}
	}
