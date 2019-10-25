package ejecutar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecCompilar {

	public static void main(String[] args) {
		
		//Ejecuta control.Compilar
		
		Runtime r= Runtime.getRuntime();
		Process p;
		try {
			p = r.exec("java -cp bin control.Compilar");
			InputStream is = p.getInputStream();
			BufferedReader br= new BufferedReader(new InputStreamReader(is));
			
			String linea=null;
			
			while((linea=br.readLine())!= null)
				System.out.println(linea);
			
			br.close();
			
		} catch (IOException e) {}
		
		
	}//main	

}//class
