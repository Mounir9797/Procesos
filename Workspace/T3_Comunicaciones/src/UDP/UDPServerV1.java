package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerV1 {

	public static void main(String[] args) {

		//buffer para recibir datagramas
		byte[] buffer = new byte[1024];

		// crear socket asociado a un puerto
		try(DatagramSocket ds = new DatagramSocket(12345)) {
			

			System.out.println("Esperando datagrama..."+InetAddress.getLocalHost()+"...puerto"+ds.getLocalPort());
			
			//Creamos un datagrama vacío para RECIBIR
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

			// esperar que llegue algo >>método bloqueante
			ds.receive(dp);

			//Cuando salimos del bloqueo, es porque hay paquete
			// extraer info y procesar
			int bytesRecibidos= dp.getLength();
			String mensaje= new String(dp.getData());
			
			//procesar, almacenar... lo que sea
			System.out.println("Bytes recibidos..."+bytesRecibidos);
			System.out.println("Mensaje..."+mensaje);
			System.out.println("IP origen..."+dp.getAddress().getHostAddress());
			System.out.println("Puerto..."+ds.getLocalPort());

		} catch (SocketException e) {
			System.out.println("Error general");
		} // try
		catch (IOException e) {
			System.out.println("Error en las comunicaciones");
		}
	}// main

}// class
