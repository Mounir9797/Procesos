package direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_V1 {

	public static void main(String[] args) {

		InetAddress dir;

		try {

			dir = InetAddress.getByName("www.google.es");

			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());

			for (InetAddress inetAddress : direcciones) {
				System.out.println(inetAddress);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
