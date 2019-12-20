package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerV1 {

	public static void main(String[] args) {
		
		byte[] buffer= new byte[1024];
		
		//crear socket asociado a un puerto
		try {
			DatagramSocket ds= new DatagramSocket(34902);
			
			System.out.println("Esperando datagrama...");
			DatagramPacket dp= new DatagramPacket(buffer, buffer.length);
			
			//esperar que llegue algo 
			ds.receive(dp);//en el momento que pase de aquí, quiere decir, que hemos extraído algo
			
			//extraer información
			int bytesRecibidos= dp.getLength();
			String mensaje= new String(dp.getData());
			
			//procesar, almacenar... lo que sea 
			System.out.println("Bytes recibidos..."+ bytesRecibidos);
			System.out.println("Mensaje..."+ mensaje);
			System.out.println("Ip origen.."+ dp.getAddress().getHostAddress());
			System.out.println("Puerto.."+ ds.getLocalPort());


			ds.close();
			
		} catch (SocketException e) {
			System.out.println("Error general");
		} catch (IOException e) {
			System.out.println("Error de las comunicaciones");
		}
		

	}

}
