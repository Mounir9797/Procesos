package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;

public class PeticionEchoTCP extends Thread {

	private Socket conn;
	private int id;
	private Calendar reloj= null;
	
	public PeticionEchoTCP(Socket conn, int id) {
		this.conn= conn;
		this.id= id;
	}//constructor
	
	public String getHora() {
		
		reloj= Calendar.getInstance();
		return reloj.get(Calendar.HOUR)+":"+reloj.get(Calendar.MINUTE)+":"+reloj.get(Calendar.SECOND);
	}//getHora
	
	public String getHost() {
		return conn.getInetAddress().getCanonicalHostName();
	}//getHost
	
	public void run() {
		
		try {
			BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			PrintStream out= new PrintStream(conn.getOutputStream());
			
			System.out.println("--- Conectado "+getHost()+ " cliente num."+id);
			
			while(true) {
				String linea= br.readLine();
				if(linea.isEmpty())break;
				out.println(linea);
				System.out.println(getHora());
			}//while
			
			System.out.println("--- Desconectado "+getHost()+ " cliente num."+id);
			
			br.close();
			out.close();
			conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}//class
