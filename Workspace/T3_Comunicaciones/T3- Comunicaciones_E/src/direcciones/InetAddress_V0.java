package direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_V0 {

	public static void main(String[] args){
		
		/*
		 * Observar que nos devuelve cada método 
		 */
		
		InetAddress dir=null;
		
		//Pasamos los métodos a diferentes direcciones para observar los resultados
		
		/*
		 * Los métodos getLocalHost y getByName devuelven un objeto InetAddress
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
		
		//los dmeás métodos devuelven Strings
		
		System.out.println("\tMétodo getByName(): "+dir);
		System.out.println("\tMétodo getHostName(): "+dir.getHostName());
		System.out.println("\tMétodo toString(): "+dir.toString());
		System.out.println("\tMétodo getCanonicalHostName(): "+dir.getCanonicalHostName());
		
		InetAddress local= null;
		
		try {
			local= InetAddress.getLocalHost();
			System.out.println("\tMétodo getLocalHost(): "+dir.getLocalHost());
			
		} catch (UnknownHostException e) {}
		
		
	}

}//class
