package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPHoraClient {

	public static void main(String[] args) {
		
		Socket s= null;
		
		try {
			s= new Socket("localhost", 5000);
			
			BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String linea= null;
			
			while((linea=br.readLine())!= null) System.out.println(linea);;
		} catch (IOException e) {
			e.printStackTrace();
		}//try
	}//main

}//class
