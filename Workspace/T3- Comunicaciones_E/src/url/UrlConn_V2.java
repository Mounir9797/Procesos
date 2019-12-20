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

public class UrlConn_V2 {

	public static void main(String[] args) {
		
		/*
		 * Vemos más cosas de la clase UrlConnection
		 */
		
		String s;
		try {
			URL url= new URL("http://www.google.es");
			URLConnection conn= url.openConnection();
			
			System.out.println("Dirección [getUrl()]: "+ conn.getURL());
			
			Date d= new Date(conn.getLastModified());
			System.out.println("Última modificación: "+ d);
			
			System.out.println("\n\nContenido: "+ conn.getContentType());
			
			/*
			 * TODOS LOS CAMPOS DE LA CABECERA
			 */
			
			Map<String, List<String>> datosHeader= conn.getHeaderFields(); //en ocasiones no sólo es lista-valor, puede ser, lista-lista de valores
			Iterator<Entry<String, List<String>>> it= datosHeader.entrySet().iterator();
			
			while(it.hasNext()) {
				Entry<String, List<String>> e= it.next();
				System.out.println(e.getKey()+"..."+e.getValue());
			}
			
			System.out.println("\n\nCampos 1 y 4:");
			System.out.println("getHeaderField(1)=>"+conn.getHeaderField(1));//si yo sé el índice puedo acceder al que yo quiera acceder
			System.out.println("getHeaderField(4)=>"+conn.getHeaderField(4));
					
			
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		

	}//main

}//class
