package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {

	public static void main(String[] args) {
		
		
		ServerSocket s= null;
		Socket conn= null;
		
		int numCli= 0;
		int port = (args.length==1)? Integer.parseInt(args[0]):5010;
		
		try {
			s= new ServerSocket(port);
			
			System.out.println("Servidor de Hora TCP creado en el puerto"+port);
			
			while(true) {
				conn= s.accept();
				new PeticionEchoTCP(conn, numCli).start();
				numCli++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//BufferedReader 
		
		

	}//main

}//class
