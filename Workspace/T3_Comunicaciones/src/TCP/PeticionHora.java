package TCP;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;

class PeticionHora extends Thread{
	Socket conn;
	public PeticionHora(Socket c) {
		this.conn= c;
	}//constructor
	
	public String getHost() {
		return conn.getInetAddress().getHostName();
	}//getHost
	
	public void run() {
		PrintStream so;
		StringBuilder sb;
		
			try {
				so= new PrintStream(conn.getOutputStream());
				
				//componer la respuesta
				Calendar fecha= Calendar.getInstance();
				sb= new StringBuilder("La hora actual es: \n");
				sb.append(fecha.get(Calendar.HOUR));
				sb.append(":"+fecha.get(Calendar.MINUTE));
				sb.append(":"+fecha.get(Calendar.SECOND));
				
				//escribir la respuesta
				so.write(sb.toString().getBytes());
				System.out.println(getHost());
				
				//cerrar
				so.close();
				conn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//try
			
			
			
	}//run
}//class