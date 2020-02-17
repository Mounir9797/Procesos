package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPHoraServer {

	public static void main(String[] args) {
		ServerSocket server= null;
		Socket conn;
		StringBuilder sb;
		
		
			try {
				
				server= new ServerSocket(5000);
				
				System.out.println("Algo, no lo copie");
				while(true) {
				conn= server.accept();
				new PeticionHora(conn).start();
				

				conn.close();//primero el stram y luego la conexion
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		
		//secribir la respuesta
		//os.write(sb.toString().getBytes());
		
		//cerrar el stream
		//os.close();
		

	}//main
	
	
	


}//class


