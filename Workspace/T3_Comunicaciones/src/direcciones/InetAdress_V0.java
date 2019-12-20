package direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdress_V0 {

	public static void main(String[] args) {

		InetAddress dir = null;

		// pasamos los métodos a diferentes direcciones a ver que sale

		// los métodos getlocalhost y getByName devuelen un InetAddress, los demás un String.

		System.out.println("\nSalida para LOCALHOST");

		try {
			dir = InetAddress.getLocalHost();
			pruebaMetodos(dir);

			System.out.println("\nSalida para ProfeDAM1");
			dir = InetAddress.getByName("ProfeDAM1");
			pruebaMetodos(dir);

			System.out.println("\nSalida para GOOGLE");
			dir = InetAddress.getByName("www.google.es");
			pruebaMetodos(dir);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}// main

	private static void pruebaMetodos(InetAddress dir) throws UnknownHostException {
		System.out.println("\tMétodo getByName(): " + dir);
		System.out.println("\tMétodo getHostName(): " + dir.getHostName());
		System.out.println("\tMétodo toString(): " + dir.toString());
		System.out.println("\tMétodo getCanonicalHostName(): " + dir.getCanonicalHostName());

		InetAddress local = null;

		local = InetAddress.getLocalHost();
		System.out.println("\tMétodo getLocalHost: " + local);

	}

}// class
