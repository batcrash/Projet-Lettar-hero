import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ThreadWin implements Runnable{

	 Sound win = new Sound("ressource/H_jason_atk1.wav");
	 InputStream streamWin = new ByteArrayInputStream(win.getSamples());
		
	public ThreadWin() {
 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		win.play(streamWin);

	}

}
