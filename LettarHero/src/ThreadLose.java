import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ThreadLose implements Runnable{

	Sound lose = new Sound("ressource/troj_jav_die.wav");
	InputStream streamLose = new ByteArrayInputStream(lose.getSamples());
		
	public ThreadLose() {
 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		lose.play(streamLose);

	}

}