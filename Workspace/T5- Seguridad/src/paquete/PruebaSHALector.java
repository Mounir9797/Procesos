package paquete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PruebaSHALector {

	public static void main(String[] args) {
		// lee el archivo quijote.dat y comprueba si ha sido alterado calcuklando su hashy comparandolo con el hash recibido
		
		ObjectInputStream inputStream= null;
		
		try {
			inputStream= new ObjectInputStream(new FileInputStream("quijote.dat"));
		
		
		Object o= inputStream.readObject();
		byte[] dataBytes= (byte[]) o;
		System.out.println("DATOS \n"+ dataBytes);
		
		//leer el hash
		o= inputStream.readObject();
		byte[] hashLeido= (byte[]) o;
		
		
		MessageDigest digest= MessageDigest.getInstance("SHA");
		digest.update(dataBytes);
		byte[] hashCalculado= digest.digest();
		
		if(MessageDigest.isEqual(hashLeido, hashCalculado))
			System.out.println("El mensaje no ha sido alterado");
		else
			System.out.println("El mensaje ha sido alterado");
		
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//main	

}//class
