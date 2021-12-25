import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


public class FenetreRembourser extends JFrame implements ItemListener{
	
		
		public ArrayList<Personne> participant;
		private JTextArea saisieMontant;
		//private ArrayList<JCheckBox> listcheckbox;
		static JComboBox combobox;

		public FenetreRembourser(ArrayList<Personne> participant) throws RemoteException{
			super();
			saisieMontant=null;
			this.participant=participant;
			//this.listcheckbox = new ArrayList<JCheckBox>();
			String[] prenoms = new String[participant.size()];
			for (int i=0;i<prenoms.length;i++) {
				prenoms[i]=participant.get(i).getName();
			}
			combobox = new JComboBox(prenoms);
			combobox.getEditor().getEditorComponent().setBackground(Color.white);
			combobox.setBounds(10, 10, 250, 26);
			//combobox.setVisible(true);
	        combobox.setEditable(true);
			combobox.addItemListener(this);
			
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

		/*public ArrayList<JCheckBox> getListcheckbox() {
			return listcheckbox;
		}

		public void setListcheckbox(ArrayList<JCheckBox> listcheckbox) {
			this.listcheckbox = listcheckbox;
		}*/
		
		
		public JComboBox getCombobox() {
			return combobox;
		}

		public static void setCombobox(JComboBox combobox) {
			FenetreRembourser.combobox = combobox;
		}

		
		private void build(){
			//setTitle("Rembourser"); //On donne un titre à l'application
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
								
				/*for (int i=0;i<participant.size();i++) {
					try {
						listcheckbox.add(new JCheckBox("<html><h3>"+participant.get(i).getName()+"</h3></html>"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					listcheckbox.get(i).setSelected(false);
					CheckboxNom.add(listcheckbox.get(i));
				}*/
				
				

				
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
			
				
			//EstCentre.add(texte,BorderLayout.CENTER);
			EstNord.add(Euro,BorderLayout.EAST);
					
				

			Boutton BoutonAjouterDepense = new Boutton(new RembourserAction2(this, "<html><h4>Rembourser</h4></html>"),new Color(176,242,182));
				
			Est.add(EstNord,BorderLayout.NORTH);
			Est.add(BoutonAjouterDepense,BorderLayout.CENTER);
			
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
	}
