package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientV1 {

	public static void main(String[] args) throws IOException {
		InetAddress server= InetAddress.getLocalHost();
		//.getByName("Prof1Dam");
		int port= 12345;
		
		//crear y codificar el mensaje
		
		byte [] msg= new byte[1024];
		String saludo= "Hola que tal";
		msg= saludo.getBytes();
		
		//crear el paquete
		DatagramPacket dp= new DatagramPacket(msg, msg.length, server, port);
		
		//crear un socket UDP para Enviar; el puerto ser´ña diferente
		DatagramSocket ds= new DatagramSocket(34567);

		ds.send(dp); //método BLOQUEANTE
		
		ds.close();
	}//main

}//class
