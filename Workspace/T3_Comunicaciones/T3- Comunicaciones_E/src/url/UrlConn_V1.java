package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConn_V1 {

	public static void main(String[] args) {
		
		//Ejemplo simple con URLConnection
		
		URL url= null;
		URLConnection conn= null;
		
		try {
			url= new URL("http://www.google.es"); //si no lleva un protocolo se sobreentiende que es http
			conn= url.openConnection();
			
			BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String linea;
			
			while((linea=br.readLine())!=null)
				System.out.println(linea);
			
			
			br.close();
			
			//Accedemos a la página desde la URL, no desde la conexión
			br= new BufferedReader(new InputStreamReader(url.openStream()));
			
			
		} catch (MalformedURLException e) {	
			System.out.println("No está correctamente escrito");
		}catch(IOException e) {}
		

	}//main

}//class
