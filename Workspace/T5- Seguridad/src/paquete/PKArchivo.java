package paquete;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class PKArchivo {

	public static void main(String[] args) {
		// Genera un par de claves asimetricas con el algoritmo DSA
		// y almacena cada una en un archivo para su posible distribución o
		// almacenamiento

		try {
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");

			SecureRandom num = SecureRandom.getInstance("SHA1PRNG");
			keygen.initialize(1024, num);

			// generar el par de claves
			KeyPair par = keygen.generateKeyPair();

			// almacenar cada clave EN EL FORMATO ADECUADO

			// Clave privada: PKCS8
			PKCS8EncodedKeySpec pk8 = new PKCS8EncodedKeySpec(par.getPrivate().getEncoded());

			// escribirla en archivo ya formateada a PKCS8
			FileOutputStream privOut = new FileOutputStream("yo.prk");

			privOut.write(pk8.getEncoded());
			privOut.close();

			// Clave pública: X.509
			X509EncodedKeySpec pkx509 = new X509EncodedKeySpec(par.getPublic().getEncoded());

			FileOutputStream pubOut = new FileOutputStream("yo.puk");

			pubOut.write(pkx509.getEncoded());
			pubOut.close();

		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		} // try

	}// main

}// class
