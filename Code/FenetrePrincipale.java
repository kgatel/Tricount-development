import java.awt.*;
import java.rmi.RemoteException;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


public class FenetrePrincipale extends JFrame{
		
		//private ArrayList<Personne> participant;
		private Tricount tricount;
		
		public Tricount getTricount() {
			return tricount;
		}

		public void setTricount(Tricount tricount) {
			this.tricount = tricount;
		}

		public FenetrePrincipale(Tricount tri) throws RemoteException{
			super();
			this.tricount=tri;
									
			build();//On initialise notre fenêtre
		}
		
		private void build() throws RemoteException{
			setTitle("Tricount"); //On donne un titre à l'application
			setSize(820,540); //On donne une taille à notre fenêtre
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
			JLabel Titre = new JLabel("<html><h2>TRICOUNT</h2></html>" );
			
			Nord.setBackground(new Color(121,210,230));
			Nord.add(Titre);
			
			//Création Centre
			JPanel Centre = new JPanel();
			Centre.setLayout(new BorderLayout(10,10));
			Centre.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
				//Text Centre
				JLabel TitreCentre = new JLabel("<html><h3>3 Dernières dépenses:</h3></html>");
				TitreCentre.setBackground(new Color(121,210,230));
				TitreCentre.setBorder(cadre);
				TitreCentre.setHorizontalAlignment(SwingConstants.CENTER);
				
				/*JLabel Depenses = new JLabel("<html>" +
						"<h3>Paul : 45€ Pizza</h3><h5>&nbsp; &nbsp; Paul,Michel,Eugène</h5>" +
						"<br><br>" +
						"<h3>Michel : 12€ Glaces</h3><h5>&nbsp; &nbsp; Michel,Jean</h5>" + 
						"<br><br>" +
						"<h3>Jean : 27€ Saucissons</h3><h5>&nbsp; &nbsp; Michel,Eugène</h5>" +
						"</html>");*/
				
				
			ArrayList<Depense> test = new ArrayList<Depense>();
			//DepenseImpl(int id, String com, int acheteur,double d,int receveur){
			DepenseImpl d1 = new DepenseImpl(0, "Pizzas", 3,35.7,2);
			test.add(d1);
			DepenseImpl d2 = new DepenseImpl(0, "Pizzas", 3,35.7,4);
			test.add(d2);
			DepenseImpl d3 = new DepenseImpl(1, "Paellas", 4,51.3,1);
			test.add(d3);
			DepenseImpl d4 = new DepenseImpl(1, "Paellas", 4,51.3,2);
			test.add(d4);
			DepenseImpl d5 = new DepenseImpl(1, "Paellas", 4,51.3,3);
			test.add(d5);
			DepenseImpl d6 = new DepenseImpl(2, "Sapin de noel pour le voisin", 0,99.99,1);
			test.add(d6);
			JLabel Depenses = new JLabel(affichage3Depenses());
			Depenses.setBackground(new Color(121,210,230));
			Depenses.setBorder(cadre);
			
			//Bouton Actualiser
			Boutton BoutonDemanderEquilibre = new Boutton(new DemanderEquilibreAction(this.tricount.GetParticipants(),this, "<html><h4>Demander Equilibre</h4></html>"),new Color(253,252,150));
	
			Centre.add(TitreCentre,BorderLayout.NORTH);
			Centre.add(Depenses,BorderLayout.CENTER);
			Centre.add(BoutonDemanderEquilibre,BorderLayout.SOUTH);
			Centre.setBackground(Color.WHITE);
			
			//Création Est
			JPanel Est = new JPanel();
			Est.setBackground(Color.WHITE);
			Est.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			Est.setLayout(new BorderLayout(10,10));
				//Text Centre
				JLabel TitreEst = new JLabel("<html><h3>Equilibre:</h3></html>");
				TitreEst.setBackground(new Color(121,210,230));
				TitreEst.setBorder(cadre);
				TitreEst.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel equilibre = new JLabel(affichageEquilibre());
				/*JLabel equilibre = new JLabel("<html>" +
						"<h3>Paul : 30€ </h3>" +
						"<h3>Michel : -22.5€ </h3>" +
						"<h3>Jean : 21€ </h3>" +
						"<h3>Eugène : -13.5€ </h3>" +
						"<h3>Edouard : 0€ </h3>" +
						"<h3>Maurice : 0€ </h3>" +
						"</html>");*/
				equilibre.setBackground(new Color(121,210,230));
				equilibre.setBorder(cadre);
				
				//Boutons
				JPanel BouttonSud = new JPanel();
				BouttonSud.setLayout(new BorderLayout());
				Boutton BoutonAjouterDepense = new Boutton(new AjouterDepenseAction(this.tricount.GetParticipants(),this, "<html><h4>Ajouter une dépense</h4></html>"),new Color(246,209,216));
				Boutton BoutonRembourser = new Boutton(new RembourserAction(this.tricount.GetParticipants(),this, "<html><h4>Rembourser</h4></html>"),new Color(176,242,182));
				
				BouttonSud.add(BoutonAjouterDepense,BorderLayout.NORTH);
				BouttonSud.add(BoutonRembourser,BorderLayout.SOUTH);
				
			Est.add(TitreEst,BorderLayout.NORTH);
			Est.add(equilibre,BorderLayout.CENTER);
			Est.add(BouttonSud,BorderLayout.SOUTH);
			
			//Ajout Panel Principal
			panel.setBackground(Color.gray);
			panel.add(Nord,BorderLayout.NORTH);
			panel.add(Centre,BorderLayout.CENTER);
			panel.add(Est,BorderLayout.EAST);
			
			
			return panel;
		}	
		
	public String affichage3Depenses() throws RemoteException {
		String res="";
		int indice = tricount.GetDepense().size()-1;
		while (indice>=0) {
			res+="<html>"+"<h3>"+trouverPersonne(tricount.GetDepense().get(indice).getAcheteurID()).getName()+" : ";
			res+=tricount.GetDepense().get(indice).getValeur()+"€ "+"<i>"+tricount.GetDepense().get(indice).getCom()+"</i></h3><h5>&nbsp; &nbsp; ";
			res+=trouverPersonne(tricount.GetDepense().get(indice).getReceveurID()).getName();
			int id=tricount.GetDepense().get(indice).getId();
			while ((indice-1>=0)&&(tricount.GetDepense().get(indice-1).getId()==id)){
				indice--;
				res+=","+trouverPersonne(tricount.GetDepense().get(indice).getReceveurID()).getName();
			}
			res+="</h5>";
			if (indice>0) {
				res+="<br><br>";
			}
			indice--;
		}
		return res;
	}
	
	private String affichageEquilibre() throws RemoteException {
		String res="<html>";
		int indice = 0;
		while (indice<this.tricount.GetParticipants().size()) {
			res+="<h3>"+this.tricount.GetParticipants().get(indice).getName()+" : "+this.tricount.GetParticipants().get(indice).getSolde()+"</h3>";
			indice++;
		}
		res+="</html>";
		return res;
	}
	
	private Personne trouverPersonne (int id) throws RemoteException {
		Personne res = null;
		for (int i=0;i<this.tricount.GetParticipants().size();i++) {
			if (id==this.tricount.GetParticipants().get(i).getId()) {
				res=this.tricount.GetParticipants().get(i);
			}
		}
		return res;
	}
	
		
		
		
	}
