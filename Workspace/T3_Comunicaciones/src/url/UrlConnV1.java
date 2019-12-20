package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnV1 {

	public static void main(String[] args) {
		// Ejemplo simple con url y URLConnection

		URL url = null;
		URLConnection conn = null;
		String linea;

		try {
			url = new URL("http://Prof1Dam:9090/helloWorld/reverse?string=Prueba");

			// accedemos a la pagina desde la URL, no desde la conexion
			// podemos descargar un recurso

			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())); // descarga desde la URL

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

			br.close();

			System.out.println("\n\n Ahora desde la URL... podemos pasar parametrod por POST");

			conn = url.openConnection();

			// Enviar parámetro... solo se puede atraves de la conexión

			conn.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());

			out.write("string=\"Hola que tal\"");
			out.close();// flush implicito
			// leer la response desde la url
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
