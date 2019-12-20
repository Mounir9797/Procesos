package url;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejercicio1_V1 {

	public static void main(String[] args) {
		System.out.println("Escribe un nombre de maquina o dominio");
		Scanner scan = new Scanner(System.in);
		String host = scan.next();
		scan.close();

		try {
			InetAddress[] dirs = InetAddress.getAllByName(host);

			for (InetAddress inetAddress : dirs) {
				System.out.println(inetAddress);
			}
		} catch (UnknownHostException e) {
		}

	}

}
