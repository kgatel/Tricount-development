import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;

import javax.swing.AbstractAction;
import javax.swing.JButton;

final class Boutton extends JButton{
	
	private Color couleur;
	
	public Boutton(AbstractAction a,Color couleur){
		super(a);
		this.couleur=couleur;
		setContentAreaFilled(false);
	}
	
	
	public Color getCouleur() {
		return couleur;
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setPaint((Paint) new GradientPaint(
		new Point(0, 0), 
		getBackground(), 
		new Point(0, getHeight()/3), 
		couleur));
		g2.fillRect(0, 0, getWidth(), getHeight()/3);
		g2.setPaint(new GradientPaint(
		new Point(0, getHeight()/3), 
		couleur, 
		new Point(0, getHeight()), 
		getBackground()));
		g2.fillRect(0, getHeight()/3, getWidth(), getHeight());
		g2.dispose();
		super.paintComponent(g);
	}
}