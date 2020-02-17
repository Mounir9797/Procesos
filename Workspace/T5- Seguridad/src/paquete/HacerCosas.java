package paquete;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HacerCosas {

	public static void main(String[] args) throws IOException {
		String miDir= System.getProperty("user.dir");
		
		if(!miDir.isEmpty()) {
			File f= new File(miDir+File.separator+"names.txt");
			System.out.println(f.getCanonicalPath());
			
			if(f.isFile()) {
				Scanner scan= new Scanner(f);
				
				while (scan.hasNext()) {
					String name= scan.nextLine();
					String result="";
					
					InetAddress ip;
					
					ip= InetAddress.getByName(name);
					
					Socket s= new Socket(name, 80);
					System.out.println(ip+"... Disponible");
				}//while
			}//if
		}//if

	}//main

}//class
