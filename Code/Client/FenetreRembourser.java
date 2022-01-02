
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.border.*;


public class FenetreRembourser extends JFrame implements ItemListener{
	
		private IHM fenetrePrincipale; 
		private JTextArea saisieMontant;
		static JComboBox combobox;

		public FenetreRembourser(IHM fenetrePrincipale) throws RemoteException{
			super();
			this.fenetrePrincipale=fenetrePrincipale;
			saisieMontant=null;
			String[] prenoms = new String[this.fenetrePrincipale.getTricount().GetParticipants().size()];
			for (int i=0;i<prenoms.length;i++) {
				prenoms[i]=this.fenetrePrincipale.getTricount().GetParticipants().get(i).getName();
			}
			combobox = new JComboBox(prenoms);
			combobox.getEditor().getEditorComponent().setBackground(Color.white);
			combobox.setBounds(10, 10, 250, 26);
	        combobox.setEditable(true);
			combobox.addItemListener(this);
			
			build();//On initialise notre fenêtre
		}
		
		public IHM getFenetrePrincipale() {
			return fenetrePrincipale;
		}

		public void setFenetrePrincipale(IHM fenetrePrincipale) {
			this.fenetrePrincipale = fenetrePrincipale;
		}

		public JTextArea getSaisieMontant() {
			return saisieMontant;
		}

		public void setSaisieMontant(JTextArea saisieMontant) {
			this.saisieMontant = saisieMontant;
		}

		
		public JComboBox getCombobox() {
			return combobox;
		}

		public static void setCombobox(JComboBox combobox) {
			FenetreRembourser.combobox = combobox;
		}

		
		private void build() throws RemoteException {
			setTitle(this.fenetrePrincipale.getUtilisateur().getName()); //On donne un titre à l'application
			setSize(540,340); //On donne une taille à notre fenêtre
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
			JLabel Titre = new JLabel("<html><h3>Rembourser</h3></html>" );
			
			Nord.setBackground(new Color(176,242,182));
			Nord.add(Titre);
			
			//Création Centre
			JPanel Centre = new JPanel();
			Centre.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			Centre.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreCentre = new JLabel("<html><h3>Qui :</h3></html>");
				TitreCentre.setBackground(new Color(104,229,100));
				TitreCentre.setBorder(cadre);
				TitreCentre.setHorizontalAlignment(SwingConstants.CENTER);
				
				//Checkbox de Nom
				JPanel CheckboxNom = new JPanel();
				CheckboxNom.setBackground(Color.white);
				CheckboxNom.setLayout(new BoxLayout(CheckboxNom, BoxLayout.Y_AXIS));		
				CheckboxNom.setBorder(cadre);
				CheckboxNom.add(combobox);			
				
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
				TitreEstNord.setBackground(new Color(104,229,100));
				TitreEstNord.setBorder(cadre);
				TitreEstNord.setHorizontalAlignment(SwingConstants.CENTER);
				
				this.saisieMontant = new JTextArea(3,3);
				saisieMontant.setText("-> ");
			
				
			EstNord.add(TitreEstNord,BorderLayout.NORTH);
			EstNord.add(this.saisieMontant,BorderLayout.CENTER);
			

			JLabel Euro = new JLabel("<html><h3>€</h3></html>");
			Euro.setHorizontalAlignment(SwingConstants.CENTER);
			
				
			EstNord.add(Euro,BorderLayout.EAST);
					
			JPanel EstSud = new JPanel();
			
			Boutton BoutonAjouterRembourser = new Boutton(new RembourserAction2(this, "<html><h4>Rembourser</h4></html>"),new Color(176,242,182));
			Boutton BoutonAnnulerRembourser = new Boutton(new AnnulerAction(this),new Color(190,190,190));
			
			EstSud.add(BoutonAjouterRembourser,BorderLayout.NORTH);
			EstSud.add(BoutonAnnulerRembourser,BorderLayout.CENTER);
			EstNord.setBackground(Color.WHITE);
			EstNord.setBorder(cadre);
			
			Est.add(EstNord,BorderLayout.CENTER);
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
		}
	}
