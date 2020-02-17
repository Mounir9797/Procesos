package paquete;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class PruebaAESCBC {

	// cifrado simetrico en bloque

	public static final byte[] IV_PARAM = { // poner los valores que se quieran

			0x00, 0x01, 0x02, 0x03, 
			0x00, 0x01, 0x02, 0x03, 
			0x00, 0x01, 0x02, 0x03, 
			0x00, 0x01, 0x02, 0x03 
			
	};

	public static void main(String[] args) {
		/*
		 * Pide al usuario una archivo y una contraseña. Si el archivo tiene extension
		 * .aes, entiende que está cifrado e intenta desencriptarlo
		 */

		Scanner scan = new Scanner(System.in);
		System.out.println("Archivo:\n");
		String f = scan.nextLine();
		System.out.println("Contraseña:\n");
		String pwd = scan.nextLine();

		// comprobamos que el archivo existe

		File fIn = new File(f);
		if (fIn.isFile()) {
			try {
				SecretKey sk = myKeyGenerator(pwd);
				System.out.println(sk.toString());

				// obtener en Cipher con los parámetros adecuados
				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
				IvParameterSpec iv = new IvParameterSpec(IV_PARAM);

				String nombreIn = fIn.getName();
				String nombreOut;

				if (nombreIn.endsWith(".aes")) {// TOCA desencriptar

					// cifrado simétrico: necesitanos la misma clave
					cipher.init(Cipher.DECRYPT_MODE, sk, iv);

					// quitar la extnesión .aes
					nombreOut = nombreIn.substring(0, nombreIn.length() - 4);

				} else { // TOCA encriptar
					cipher.init(Cipher.ENCRYPT_MODE, sk, iv);
					nombreOut = nombreIn + ".aes";
				} // if

				// leer los datos bloque a bloque y hacer lo que diga cipher
				byte[] datos = new byte[1024];// Buffer de lectura
				byte[] result;// buffer de datos encriptados

				ByteArrayOutputStream salida = new ByteArrayOutputStream();
				FileInputStream entrada = new FileInputStream(fIn);

				int leido = entrada.read(datos);
				while (leido > 0) {
					result = cipher.update(datos, 0, leido);// cifra y tambien descifra
					salida.write(result);
					leido = entrada.read(datos);
				} // while

				// FINALIZAR

				result = cipher.doFinal();// Paso necesario
				salida.write(result);

				// Escribir la salida del archivo
				FileOutputStream fOut = new FileOutputStream(nombreOut);
				fOut.write(salida.toByteArray());

				System.out.println("Archivo generado: " + nombreOut);

				// Cerrar flujos
				fOut.close();
				entrada.close();
				salida.close();

				// podemos borrar el archivo original
				fIn.delete();

			} catch (Exception e) {
				e.printStackTrace();
			} // try
		} // if

	}// main

	private static SecretKey myKeyGenerator(String pwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		// generamos un objeto Secret key a partir de un String

		// primero, generamos el hash de la password
		byte[] datos = pwd.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(datos);

		byte[] key = Arrays.copyOf(hash, 128 / 8);

		return new SecretKeySpec(key, "AES");
	}// myKeyGenerator

}// class
