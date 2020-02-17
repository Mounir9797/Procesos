package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCPEchoClient {

	public static void main(String[] args) {

		Socket s = null;
		BufferedReader in;
		try {
			s = new Socket("localhost", 5010);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));

			PrintStream out = new PrintStream(s.getOutputStream());
			BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Escribe lo que quieras, para salir deja una linea en blanco");

			while (true) {
				String text = consola.readLine();
				out.print(text);
				if (text.isEmpty())break;
				
				System.out.println(in.readLine());

			}

			in.close();
			out.close();
			consola.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();

		}//try

	}// main

}// class
