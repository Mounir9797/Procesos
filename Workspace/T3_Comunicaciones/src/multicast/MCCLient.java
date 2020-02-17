package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCCLient {

	public static void main(String[] args) {
		int puerto= 12345; //puerto UCP del multicast
		
		try {
			MulticastSocket socket= new MulticastSocket(puerto);
			InetAddress address= InetAddress.getByName("225.0.0.1");
			
			//unirse al grupo para escuchar
			socket.joinGroup(address);
			
			System.out.println("Escuchando.....");
			
			//El cliente no lee del teclado si no del DatagramPacket
			//no lee como String si no comoarray de bytes
			
			byte[] bs= new byte[1024];
			String linea="*";
			
			//termina cuando reciba la linea vacía
			while(!linea.isEmpty()) {
				
				DatagramPacket packet= new DatagramPacket(bs, bs.length);
				//no hay direccion ni puerto porque recibimos del grupo
				
				socket.receive(packet);
				
				linea= new String(packet.getData()).substring(0, packet.getLength());
				
				System.out.println("RECIBIDO>>..." + linea);
				
			}//while
			
			socket.leaveGroup(address);
			socket.close();
			System.out.println("Socket cerrado, adiós");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}//main

}//class
