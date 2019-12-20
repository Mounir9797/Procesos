package direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej1v2 {

	public static void main(String[] args) {
		
		System.out.println("Escribe un nombre de máquina o dominio");
		
		Scanner scan = new Scanner(System.in);
		String host= scan.next();
		scan.close();
		
		try {
			InetAddress[] dirs= InetAddress.getAllByName(host);
			
			for(InetAddress ia: dirs) {
				System.out.println(ia);
			}
				
			
		} catch (UnknownHostException e) {}
		

	}

}
