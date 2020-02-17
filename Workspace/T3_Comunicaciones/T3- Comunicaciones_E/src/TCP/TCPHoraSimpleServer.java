package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TCPHoraSimpleServer {

	public static void main(String[] args) {
		
		ServerSocket server=null;
		Socket conn;
		String s;
		int sum;
		OutputStream os;
		Calendar fecha;
		
		try {
			server= new ServerSocket(5000);//se puede usar un constructor con Timeout
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true) {
			try {
				//espera para aceptar una conexión
				conn= server.accept();
				
				//obtener info del socket
				System.out.println(conn.getInetAddress().getHostAddress());
				System.out.println();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}//main

}
