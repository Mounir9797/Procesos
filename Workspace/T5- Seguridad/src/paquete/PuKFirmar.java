package paquete;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class PuKFirmar {

	public static void main(String[] args) {
		// Firma un archivo con firma electrónica: calculamos el hash y luego ciframos con PrK
		
		//obtener la PrK desde su archivo
		try {
		FileInputStream prIn= new FileInputStream("yo.prk");
		byte[] pkBuff= new byte[prIn.available()];
		
			prIn.read(pkBuff);
			prIn.close();
			
			//decodificar la clave recuperada
			PKCS8EncodedKeySpec pkcs8= new PKCS8EncodedKeySpec(pkBuff);
			KeyFactory keyDSA= KeyFactory.getInstance("DSA");
			PrivateKey prK= keyDSA.generatePrivate(pkcs8);
			
			//Iniciar el objeto signature con la clave y el tipo de HASH
			
			Signature signature= Signature.getInstance("SHA1withDSA");
			signature.initSign(prK);
			
			//abrir el archivo que quiero firmar
			BufferedInputStream bis= new BufferedInputStream(new FileInputStream("quijote.dat"));
			
			byte[] buffer= new byte[bis.available()];
			
			//pasar los datos al objeto Signature poco a poco
			int leidos= 0;
			while((leidos=bis.read(buffer))>0) signature.update(buffer, 0, leidos);
			bis.close();
			
			//Generar la firma final
			byte[] firma= signature.sign();
			
			//ESCRIBIR la firma en otro archivo 
			FileOutputStream fos= new FileOutputStream("firma.dat");
			fos.write(firma);
			fos.close();
		} catch (IOException | InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}//try
		
	}//main

}//class
