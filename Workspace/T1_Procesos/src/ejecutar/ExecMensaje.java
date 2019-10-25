package ejecutar;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class ExecMensaje {

	public static void main(String[] args) throws IOException {
		
		//int num= Integer.parseInt(args[1]);
		ProcessBuilder pb = new ProcessBuilder("CMD", "/K", "java", "-cp", "bin", "ejecutar.Mensaje", args[0], args[1]);
		
		pb.redirectOutput(Redirect.INHERIT);
		
		pb.start();
	}//main

}//class
