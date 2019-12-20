package direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej1v1 {

	public static void main(String[] args) {
		
		System.out.println("Escribe un nombre de máquina o dominio");
		
		
		try {
			InetAddress[] dirs= InetAddress.getAllByName(args[0]);
			
			for(InetAddress ia: dirs) {
				System.out.println(ia);
			}
				
		} catch (UnknownHostException e) {}
		

	}

}
