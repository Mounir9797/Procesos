package url;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ResourceSaver {

	/*
	 * El mapa socia cada tipo de recurso
	 * a un path de carpeta
	 */
	
	private Map<String, String> tipos= new HashMap<>();
	
	public void addTipo(String pattern, String carpeta) {
		
		tipos.put(pattern, carpeta);
			
	}
	
	private void crearCarpeta(String carpeta) throws IOException {
		
		File f= new File(carpeta);
		if(!f.exists()&& !f.mkdir())
			throw new IOException("Permiso denegado");
	}
	
	public void crearCarpetas() throws IOException {
		
		for(String pattern: tipos.keySet())
			crearCarpeta(tipos.get(pattern));	
		
	}
	
	private void saveTo(InputStream is, String carpeta, String archivo) throws FileNotFoundException, IOException {
		
		int leidos;
		
		FileOutputStream fOut= new FileOutputStream(
				new File(carpeta, archivo));
		
		//leer
		byte[] buffer= new byte[1024];
		
		while((leidos=is.read(buffer))!=-1)
			fOut.write(buffer, 0, leidos);
		
	}
	
	public void descargar(String recurso) throws MalformedURLException, IOException, Exception {
		
		boolean guardado= false;
		
		URL url= new URL(recurso);
		URLConnection conn= url.openConnection();
		
		System.out.println(url.getFile()+": tipo"+conn.getContentType());
		System.out.println("ruta: "+url.getPath());
		
		for(String pattern: tipos.keySet()) {
			if(conn.getContentType().matches(pattern)) { //clasificar
				
				//extraer el nombre de la url
				int ultimoSep= url.getPath().lastIndexOf("/")+1;
				String nombre= url.getPath().substring(ultimoSep);
				saveTo(conn.getInputStream(), tipos.get(pattern), nombre);
				guardado= true;
				break;
			}
		}
		
		
	}
	
}
