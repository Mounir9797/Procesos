package procesos;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class ExecHola {

	public static void main(String[] args) {
		

		try {
			
			ProcessBuilder pb = new ProcessBuilder("CMD", "/K", "java", "-cp", "bin", "procesos.Hola");
			//File fout= new File("Hola.txt");
			//File ferr= new File("HolaErr.txt");
			
			pb.redirectOutput(Redirect.INHERIT);
			//pb.redirectError(ferr);
			
			pb.start();
		} catch (IOException e) {}
		
		
	}//main	

}//class
