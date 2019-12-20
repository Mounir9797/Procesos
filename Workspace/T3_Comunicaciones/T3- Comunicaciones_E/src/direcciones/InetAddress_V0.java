package direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_V0 {

	public static void main(String[] args){
		
		/*
		 * Observar que nos devuelve cada m�todo 
		 */
		
		InetAddress dir=null;
		
		//Pasamos los m�todos a diferentes direcciones para observar los resultados
		
		/*
		 * Los m�todos getLocalHost y getByName devuelven un objeto InetAddress
		 */
		
		System.out.println("\nSalida para LOCALHOST");
		
		try {
			dir= InetAddress.getLocalHost();
			pruebaMetodos(dir);
			
		
		System.out.println("\nSalida para Prof1DAM");
		dir= InetAddress.getByName("Prof1DAM");
		pruebaMetodos(dir);
		
		System.out.println("\nSalida para GOOGLE");
		dir= InetAddress.getByName("www.google.es");
		pruebaMetodos(dir);
		
		} catch (UnknownHostException e) {}
		

	}//main

	private static void pruebaMetodos(InetAddress dir) {
		
		//los dme�s m�todos devuelven Strings
		
		System.out.println("\tM�todo getByName(): "+dir);
		System.out.println("\tM�todo getHostName(): "+dir.getHostName());
		System.out.println("\tM�todo toString(): "+dir.toString());
		System.out.println("\tM�todo getCanonicalHostName(): "+dir.getCanonicalHostName());
		
		InetAddress local= null;
		
		try {
			local= InetAddress.getLocalHost();
			System.out.println("\tM�todo getLocalHost(): "+dir.getLocalHost());
			
		} catch (UnknownHostException e) {}
		
		
	}

}//class
