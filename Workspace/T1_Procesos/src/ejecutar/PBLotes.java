package ejecutar;

import java.io.File;
import java.io.IOException;

public class PBLotes {

	public static void main(String[] args) {
		// Ejecuta los comandos de un archivo por lotes pbin.bat

		ProcessBuilder pb= new ProcessBuilder("CMD");
		
		//REDIRIGIR la salida, la entrada y el error
		
		File fout= new File("pbout.txt");
		File fin= new File("pbin.bat");
		File ferr= new File("pberr.txt");
		
		pb.redirectInput(fin);
		pb.redirectError(ferr);
		pb.redirectOutput(fout);
		
		try {
			pb.start();
		} catch (IOException e) {}
		
	}//main

}//class
