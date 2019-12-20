package url;

import java.net.MalformedURLException;
import java.net.URL;

public class Url_V1 {

	public static void main(String[] args) {
		
		//probrar cosas que se puedean hacer con una url
		
		URL url;
		
		System.out.println("Usamos diferentes constructores de url");
		
		try {
			url= new URL("http://docs.oracle.com/");
			pruebaMetodos(url);
			
			url= new URL("http://Prof1Dam:9090/helloWorld/reverse?string=hola+buen+dia");
			pruebaMetodos(url);
			
			url= new URL("file:///E://erika_castro//GestionEmpre//Gestion_empresarial.txt");
			pruebaMetodos(url);
			
			url= new URL("http", "docs.oracle.com/", "/javase/8");
			pruebaMetodos(url);
			
			url= new URL("MM");
			
		} catch (MalformedURLException e) {
			
			System.err.println("\nNo se encuentra la URL");
		}
		
		

	}//main

	private static void pruebaMetodos(URL url) {
		
		System.out.println("\nURL completa: "+url.toString());
		System.out.println("\tgetProtocol: "+url.getProtocol());
		System.out.println("\tgetHost: "+url.getHost());
		System.out.println("\tgetFile: "+url.getFile());
		System.out.println("\tgetUserInfor: "+url.getUserInfo());
		System.out.println("\tgetPath: "+url.getPath());
		System.out.println("\tgetAuthority: "+url.getAuthority());
		System.out.println("\tgetQuery: "+url.getQuery());
		
		
	}

}//class
