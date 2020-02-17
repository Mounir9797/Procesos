package multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCServer {

	public static void main(String[] args) {
		/*Le del teclado y publica lo escrito en el grupo, hasta que reciba una linea vacia.*/
		
			try {
				MulticastSocket socket= new MulticastSocket();
				int puerto= 12345; //puerto UDP
				
				InetAddress grupo= InetAddress.getByName("225.0.0.1");
				
				System.out.println("Publicando....................");
				
				String linea="*";
				BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
				while(!linea.isEmpty()) {
					
					linea = reader.readLine(); 
					//leer la linea y la retransmita aunque este vacía
					System.out.println("ENVIAR>> "+linea);
					
					DatagramPacket packet= new DatagramPacket(linea.getBytes(), linea.length(), grupo, puerto);
					
					socket.send(packet);
				}//while
				
				socket.close();
				System.out.println("Cerrando servidor multicast.....");
			} catch (IOException e) {
				e.printStackTrace();
			}

	}//main

}//class
