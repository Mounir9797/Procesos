package paquete;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class VerificarFirma {

	public static void main(String[] args) {
		/*
		 * Usamos uan clave publica paraq verificar una firma electronica y comprobar la
		 * integridad y autoria el mensaje recibido
		 */

		// obtener la clave pública desde su archivo

		try {
			FileInputStream puIn = new FileInputStream("yo.puk");
			byte[] pukBuff = new byte[puIn.available()];
			puIn.read(pukBuff);
			puIn.close();

			// Decodificar la clave recuperada
			X509EncodedKeySpec pukx509 = new X509EncodedKeySpec(pukBuff);
			KeyFactory keyDSA = KeyFactory.getInstance("DSA");
			PublicKey puK= keyDSA.generatePublic(pukx509);

			//Iniciar el objeto signature con la clave y el tipo de HASH

			Signature signature = Signature.getInstance("SHA1withDSA");
			signature.initVerify(puK);
			
			//Abrir el archivo con la firma
			FileInputStream firmaIn= new FileInputStream("firma.dat");
			byte [] firma= new byte[firmaIn.available()];
			firmaIn.read(firma);
			firmaIn.close();
			
			//abrir el archivo que quiero firmar
			BufferedInputStream bis= new BufferedInputStream(new FileInputStream("quijote.dat"));
			
			byte[] datos= new byte[bis.available()];
			
			//pasar los datos al objeto Signature poco a poco
			int leidos= 0;
			while((leidos=bis.read(datos))>0) signature.update(datos, 0, leidos);
			bis.close();
			
			//Verificar 
			if(signature.equals(firma))
				System.out.println("Archivo verificado");
			else
				System.out.println("Autor desconocido o mensaje alterado");

		} catch (Exception e) {
			e.printStackTrace();
		}//try

	}// main

}// class
