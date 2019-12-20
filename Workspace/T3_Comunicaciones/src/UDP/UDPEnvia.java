package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEnvia {

	public void envia(String mssg, int bufferlength, String host, int port) throws IOException{
		
		DatagramSocket datagramSocket= new DatagramSocket();
		byte[] buffer= new byte[bufferlength];
		buffer= mssg.getBytes();
		
		DatagramPacket datagramPacket= new DatagramPacket(buffer, mssg.length(), InetAddress.getByName(host), port);
		
		datagramSocket.send(datagramPacket);
		datagramSocket.close();
	}//envia
}//class
