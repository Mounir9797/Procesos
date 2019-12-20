package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConn_V3 {

	public static void main(String[] args) {	

		//Ejemplo simple con URLConnection
		URL url= null;
		URLConnection conn= null;
		String linea;
		
		try {
			url= new URL("http://Prof1Dam:9090/helloWorld/reverse?string=Prueba"); //si no lleva un protocolo se sobreentiende que es http
			
			//Accedemos a la p�gina desde la URL, no desde la conexi�n
			//podemos descargar un recurso
			BufferedReader br= new BufferedReader(
					new InputStreamReader(url.openStream())); //descarga desde la url no desde la conexi�n
			
			while((linea=br.readLine())!=null)
				System.out.println(linea);
			
			
			br.close();
			
			
			System.out.println("\n\n Ahora desde la URL.. podemos pasar par�metros por POST");
			
			//ABRIR CONEXI�N
			conn= url.openConnection();
			
			//Enviar par�metro.. solo se puede a trav�s de la conexi�n
			conn.setDoOutput(true);
			OutputStreamWriter out= new OutputStreamWriter(
					conn.getOutputStream()
					);
			out.write("string=\"Hola que tal\"");
			out.close(); //flush impl�cito
			
			//leer la reponse desde la url
			br= new BufferedReader(
					new InputStreamReader(conn.getInputStream())); //se hace desde la conexi�n
			
			while((linea=br.readLine())!=null)
				System.out.println(linea);	
			
			
			br.close();
			
		} catch (MalformedURLException e) {	
			System.out.println("No est� correctamente escrito");
		}catch(IOException e) {}
		

		

	}//main

}//class
