package examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex1819_Ej_1 {

	public static void main(String[] args) {
		
		
		Runtime r= Runtime.getRuntime();
		
		
		
		if(args.length==0) {
			System.out.println("Debe especificar un archivo");
			System.exit(1);//error
		}
		
		String com= args[0];
		System.out.println(com);
		
		File f= new File(args[0]);
		
		
		Process p= null;
		InputStream is= null;
		FileWriter fw=null;
		
		try {
			p = r.exec("tasklist -fi \"status ne running\"");
			is = p.getInputStream();
			
			BufferedReader br= new BufferedReader(new InputStreamReader(is));
			
			String linea=null;
			fw= new FileWriter(f, true);
			
			while((linea=br.readLine())!= null)
				//System.out.println(linea);
			fw.append(linea+'\n');
			
			br.close();
			fw.close();
			
		} catch (IOException e) {}

	}

}
