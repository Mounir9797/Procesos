package url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ResourceServer {

	/*
	 * El mapa asocia cada tipo de recurso a un path de carpeta
	 */

	private Map<String, String> tipos = new HashMap<>(); // tipo, carpeta

	public void addTipo(String pattern, String carpeta) {
		tipos.put(pattern, carpeta);
	}// addTipo

	private void crearCarpeta(String carpeta) throws IOException {
		File f = new File(carpeta);

		if (!f.exists() && !f.mkdir())
			throw new IOException("permiso denegado");
	}// crearCarpeta

	public void crearCarpetas() throws IOException {
		for (String pattern : tipos.keySet())
			crearCarpeta(tipos.get(pattern));

	}// crearCarpeta

	private void saveTo(InputStream is, String carpeta, String archivo) throws IOException {
		int leidos;

		FileOutputStream fOut = new FileOutputStream(new File(carpeta, archivo));

		// leer
		byte[] buffer = new byte[1024];

		while ((leidos = is.read(buffer)) != -1)
			fOut.write(buffer, 0, leidos);
		
		fOut.close();

	}// saveTo

	public void descargar(String recurso) throws Exception {

		//boolean guardado = false;

		URL url = new URL(recurso);
		URLConnection conn = url.openConnection();

		System.out.println(url.getFile() + ": tipo" + conn.getContentType());
		System.out.println("ruta: " + url.getPath());

		for (String pattern : tipos.keySet()) {
			if (conn.getContentType().matches(pattern)) { // clasificar

				// extraer el nombre de la url
				int ultimoSep = url.getPath().lastIndexOf("/") + 1;
				String nombre = url.getPath().substring(ultimoSep);
				saveTo(conn.getInputStream(), tipos.get(pattern), nombre);
				//guardado = true;
				break;

			} // if
		} // for
	}// descargar

}// class
