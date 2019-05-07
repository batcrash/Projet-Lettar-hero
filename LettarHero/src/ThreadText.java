import java.awt.TextField;
import java.net.Socket;

public class ThreadText implements Runnable {

	TextField saisie;
	
	//private String lettre;
	
	public ThreadText(TextField saisie) {
		
		  this.saisie=saisie;	 
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saisie.setText("");
		
	}

}
