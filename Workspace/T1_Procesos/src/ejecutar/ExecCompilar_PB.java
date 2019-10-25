package ejecutar;

import java.io.File;
import java.io.IOException;

public class ExecCompilar_PB {

	public static void main(String[] args) {
		
		//Ejecuta control.Compilar, ahora con ProcessBuilder
		
		/*Runtime r= Runtime.getRuntime();
		Process p;*/
		try {
			//p = r.exec("java -cp bin control.Compilar");
			
			ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "control.Compilar");
			File fout= new File("nuevo\\pbout.txt");
			//File fin= new File("pbim");
			File ferr= new File("pberr.txt");
			
			pb.redirectOutput(fout);
			pb.redirectError(ferr);
			
			pb.start();
		} catch (IOException e) {}
		
		
	}//main	

}//class
