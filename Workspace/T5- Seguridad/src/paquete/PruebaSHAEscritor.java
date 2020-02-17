package paquete;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PruebaSHAEscritor {

	public static void main(String[] args) {
		//Escribe un texto en un archivo y después escribe su resumen con método SHA
		
		String data="En un lugar de la mancha de cuyo nombre no quiero acordarme";
		
		byte[] dataBytes= data.getBytes();
		
		ObjectOutputStream outputStream= null;
		
		
		try {
			
			//Obtener una instancia del algoritmo
			MessageDigest digest= MessageDigest.getInstance("SHA");
			
			
			//pasar los datos al algotritmo
			digest.update(dataBytes);
			
			//calcular el hash	
			byte[] resumen= digest.digest();
			
			//escribir el mensaje y el hash en el archivo
			outputStream= new ObjectOutputStream(new FileOutputStream("quijote.dat"));
			
			outputStream.writeObject(dataBytes);
			outputStream.writeObject(resumen);
			
			outputStream.close();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//main

}//class
