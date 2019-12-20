package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPRecibe {
	
	//recibe un mensaje via UDP
	
	//atributos
	DatagramSocket datagramSocket;
	DatagramPacket datagramPacket;
	byte[] buffer;
	
	String remoteIP="";
	
	public String recibe(int port, int maxLength) throws IOException {
		datagramSocket= new DatagramSocket(port);
		
		byte[] buffer= new byte[maxLength];
		datagramPacket= new DatagramPacket(buffer, buffer.length);
		
		datagramSocket.receive(datagramPacket);
		
		datagramSocket.close();
		
		return new String(datagramPacket.getData()).substring(0, datagramPacket.getLength()).toUpperCase();
	}//recibe
	
	public synchronized String recibe(int port, int maxLength, int tOut) throws IOException {
		datagramSocket= new DatagramSocket(port);
		datagramSocket.setSoTimeout(tOut);
		byte[] buffer= new byte[maxLength];
		datagramPacket= new DatagramPacket(buffer, buffer.length);
		
		datagramSocket.receive(datagramPacket);
		remoteIP= datagramPacket.getAddress().getHostAddress();
		System.out.println(remoteIP);
		datagramSocket.close();
		return new String(datagramPacket.getData()).substring(0, datagramPacket.getLength());
	}

	public String getRemoteIP() {
		return remoteIP;
	}

	public void setRemoteIP(String remoteIP) {
		this.remoteIP = remoteIP;
	}
	
	

}//class
