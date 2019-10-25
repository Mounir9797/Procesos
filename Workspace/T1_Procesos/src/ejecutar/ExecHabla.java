package ejecutar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExecHabla {

	public static void main(String[] args) throws IOException {
		// Habla interactua con el usuario en tiempo de ejecucuin asi que exec habla debe pedir datos y pasarselos a habla
		
		Runtime r= Runtime.getRuntime();
		
		//ProcessBuilder pb = new ProcessBuilder("CMD", "/K", "java", "-cp", "bin", "ejecutar.Mensaje", args[0], args[1]);
		
		//pb.redirectOutput(Redirect.INHERIT);
		Scanner scan= new Scanner(System.in);
		
		try {
			Process p = r.exec("CMD /K java -cp bin ejecutar.Habla");
			
			
			BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
			PrintWriter pw= new PrintWriter(p.getOutputStream());
			/*OutputStream os= p.getOutputStream();
			os.write(s.getBytes());
			os.close();*/
			
			/*System.out.println("Escribe una número para habla");
			os= p.getOutputStream();
			int n=scan.nextInt();
			DataOutputStream dos= new DataOutputStream(os);
			dos.writeBytes(s);
			dos.flush();
			os.close();
			dos.close();
			
			os.write(n);
			os.close();
			
			InputStream is= p.getInputStream();*/
			
			System.out.println("Escribe una palabra para habla");
			String pal= scan.next();
			

			
			System.out.println("Escribe una número para habla");
			String n= scan.next();
			
			pw.write(pal+'\n'+n);
			
			pw.close();
											
			String result= br.lines().collect(Collectors.joining("\n"));
			System.out.println(result);
				
		
			
			if(p.waitFor()==0)
				System.out.println("Fin de Programa");
			else
				System.out.println("Error");
			
			br.close();
		} catch (IOException | InterruptedException e) {}
		
		scan.close();

	}//main

}//class
