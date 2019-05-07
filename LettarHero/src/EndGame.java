import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EndGame extends JPanel {

	private int positionX, positionY;
	private double nbSaisie;
	private double score;
	
	Font font = new Font("Courier", Font.BOLD, 40);
	
	public EndGame(int nbSaisie, int score) {   
		
		this.setSize(500, 300);
		this.nbSaisie=nbSaisie;
		this.score=score;
		positionX = 0;
		positionY = 200;
		this.requestFocus();
		    
	}
	
	public void paintComponent(Graphics g){	
		
		
		g.setFont(font);
	    g.setColor(Color.BLUE); 
	   
	    try {
	    	double resultat =  (score / nbSaisie) * 100;
	    	System.out.println((int)nbSaisie);
	    	g.drawString("Partie terminée !", this.getWidth()/8, positionY);
	    	g.drawString("Réussite : " +(int)resultat+ " %", this.getWidth()/8, positionY+font.getSize());
	    }
	    catch (ArithmeticException e) {
	    	g.drawString("Euuhhh ... !", this.getWidth()/4, positionY);
	    	g.drawString("Tu joues ?", this.getWidth()/4, positionY+font.getSize());
	    }
	    
	}
	
}
