
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
		
		  JPanel panel = new JPanel();
		  SpaceGame game = new SpaceGame();
		  JLabel label = new JLabel();
		  TextField saisie = new TextField();
		  Button button = new Button();
		  GridBagConstraints gbc;
		  Thread td1, td2, td3;
		  EndGame end;
		  
		  
		  private boolean startGame = true;
		  private String lettreSaisie;
		  private int score = 0;
		  private int  nbSaisie = 0;
		    
		  public Fenetre() {   
			
		    this.setTitle("Lettar Hero");
		    this.setSize(500, 500);
		    this.setLocationRelativeTo(null); 
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    //this.setBackground(Color.GREEN);
		    
		    panel.setLayout(new GridBagLayout());
		    gbc = new GridBagConstraints();
	
			label.setText("Score : " +(int)score);
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.insets = new Insets(10,10,10,10);
			gbc.gridx = 0;
		    gbc.gridy = 0;
		    gbc.weighty = 0.1;
		    panel.add(label,gbc);
		    
		    
		    gbc.anchor = GridBagConstraints.CENTER;
		    gbc.gridwidth = 2;
		    gbc.gridy = 1;
		    gbc.weighty = 1.;
		    gbc.fill = GridBagConstraints.BOTH;
		    panel.add(game,gbc);
		    
		    saisie.setPreferredSize(new Dimension(10, 30));
		    saisie.setFont(new Font("Courier", Font.BOLD, 50));
		    saisie.addTextListener(new SaisieTextListener()); 
		    gbc.anchor = GridBagConstraints.CENTER;
		    gbc.gridwidth = 1;
		    gbc.gridy = 2;
		    gbc.weightx = 0.5;
		    gbc.weighty = 0.1;
		    panel.add(saisie,gbc);
		    
			button.setText("Stop");
			button.setPreferredSize(new Dimension(10, 30));
			button.addActionListener(new BoutonListener()); 
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridx = 1;
		    gbc.gridy = 2;
		    panel.add(button,gbc);
		    
		    this.setContentPane(panel);
		    this.setVisible(true);
		    go();
		    
		  }
			
			public void go() {
				
				while(startGame == true) {
					
				    for(int i = 10; i < 300; i++){
				    	
				      game.setPositionY(game.getPositionY()-1);
				      panel.repaint();
				      
				      try {
				        Thread.sleep(5);
				      } catch (InterruptedException e) {
				        e.printStackTrace();
				      }
				      
				    }
				    game.setAlea((int)(Math.random()*6));
				    game.setPositionY(300);
				}
			}
			
			/*public void test() {
				System.out.println("test");
			}*/

			class BoutonListener implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stud
						
					startGame = false;
					end = new EndGame(nbSaisie, score);
					//gbc.anchor = GridBagConstraints.SOUTH;
				    gbc.gridwidth = 2;
				    gbc.gridx = 0;
				    gbc.gridy = 1;
				    gbc.weighty = 1.;
				    //gbc.fill = GridBagConstraints.HORIZONTAL;
				    panel.add(end, gbc);
		
				}
			}	
			
			class SaisieTextListener implements TextListener{
				public void textValueChanged(TextEvent e) {
					
					ThreadText tdt = new ThreadText(saisie);
					td1 = new Thread(tdt);
					td1.start();
					if (!(saisie.getText().equals(""))) { 
						nbSaisie++;
						game.setTime(20); 
						lettreSaisie = saisie.getText();
						if (lettreSaisie.equals(game.getLettre()) && game.getPositionY()<120 && game.getPositionY()>70) {
							ThreadWin tdw = new ThreadWin();
							td2 = new Thread(tdw);
							td2.start();
							game.setTrouver(2);
							score++;
							label.setText("Score : " +(int)score);
						}
						else { 
							ThreadLose tdl = new ThreadLose();
							td3 = new Thread(tdl);
							td3.start();
							game.setTrouver(1);
						}
					}
					//System.out.println(lettre);
				}
			}	

}

