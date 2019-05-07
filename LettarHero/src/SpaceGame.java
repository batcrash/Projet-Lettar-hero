import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceGame extends JPanel {

	private String[] lettre = {"a","z","e","r","t","y"};
	private int alea;
	private int positionX, positionY, time = 0, vibra;
	private int trouver = 0; // état 0 : default, état 1 : non trouvé, état 2 : trouvé
	
	Font font = new Font("Courier", Font.BOLD, 80);
	
	public SpaceGame() {   
			
		this.setSize(500, 300);
		alea = (int)(Math.random()*6);
		positionX = 220;
		positionY = 300;
		    
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public void setPositionX(int pos) {
		positionX=pos;
	}
	
	public String getLettre() {
		return lettre[alea];
	}
	
	public void setAlea(int alea) {
		this.alea=alea;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public void setPositionY(int pos) {
		positionY=pos;
	}
	
	public void setTime(int time) {
		this.time=time;
	}
	
	public void setTrouver(int trouver) {
		this.trouver=trouver;
	}
	
	public void paintComponent(Graphics g){		
		
		if (trouver == 2 && time !=0) { 
			time--;
			g.setColor(Color.GREEN);
			g.drawRect(40, 50, 400, 60);
		}
		else if (trouver == 1 && time != 0) {
			time--;
			g.setColor(Color.RED);
			vibra = (int)(Math.random()*10);
			g.drawRect(40-vibra, 50-vibra, 400+2*vibra, 60+2*vibra);
		}
		else {
			trouver = 0;
			g.setColor(Color.BLACK);
			g.drawRect(40, 50, 400, 60);
		}
		
	    g.setFont(font);
	    g.setColor(Color.RED);  
	    g.drawString(lettre[alea], positionX, positionY);
	    //g.drawRect(0, 40, 200, 50);
	    
	} 
	
}
