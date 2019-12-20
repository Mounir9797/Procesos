package direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_V1 {

	public static void main(String[] args) {
		
		
		InetAddress dir;
		
		try {
			dir= InetAddress.getLocalHost();
			
			InetAddress[] direcciones= InetAddress.getAllByName(dir.getHostName());
			
			for(InetAddress ia: direcciones)
				System.out.println(ia);
				
			
		} catch (UnknownHostException e) {
			
		}
		
		

	}

}
