package url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UrlConn_V1 {

	public static void main(String[] args) {
		//String s;
		try {
			URL url = new URL("http://ies.barajas.madrid.educa.madrid.org/ies/index.php");
			URLConnection conn = url.openConnection();

			System.out.println("Dirección [getUrl()]: " + conn.getURL());

			Date d = new Date(conn.getLastModified());
			System.out.println("Ultima modificacion" + d);

			System.out.println("Contenido: " + conn.getContentType());

			/* TODOS LOS CAMPOS DE LA CABECERA */

			Map<String, List<String>> datos = conn.getHeaderFields();
			Iterator<Entry<String, List<String>>> it = datos.entrySet().iterator();

			while (it.hasNext()) {
				Entry<String, List<String>> entry = (Entry<String, List<String>>) it.next();

				/* Entry<String, List<String>> e= it.next(); */
				System.out.println(entry.getKey() + "..." + entry.getValue());
			}

			System.out.println("\n\nCampos 1 y 4: ");
			System.out.println("getHeaderField(1)=> " + conn.getHeaderField(1));
			System.out.println("getHeaderField(4)=> " + conn.getHeaderField(4));

			System.out.println("\n\nurl.getFile() " + url.getFile());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
