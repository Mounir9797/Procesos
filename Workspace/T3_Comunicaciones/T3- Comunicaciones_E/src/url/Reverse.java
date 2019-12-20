package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Reverse {

	public static void main(String[] args){
		
		/*Recibe como argumentos la url del servicio reverse y un string.
		 * Establece conexión con el servicio y le envía el string.
		 * Recibe la respuesta y la muestra por consola.
		 */
		
		if(args.length!=2) {
			System.err.println("java Reverse url string");
			System.exit(1);
		}else {
			String s;
			
			//parsear la URL desde el parámetro 
				try {
				URL url= new URL(args[0]);
				
				//codificar el String a un charset válido
				s= URLEncoder.encode(args[1], "UTF-8");
				
				//establecer conexión
				URLConnection conn= url.openConnection();
					
				//habilitar el envío de parámetros por la conexión... habilita el programa para que reciba parámetros
				conn.setDoOutput(true);
				
				//abrir el stream de salida
				OutputStreamWriter opw= new OutputStreamWriter(conn.getOutputStream());
				
				//enviar el parámetro en formato nombre=valor
				//el nombre del parámetro no es casual; es el que observamos en la petición por navegador
				opw.write("string="+s); //formato que sabemos que acepta ese servidor
				
				//si hay más parámetros se separan con un &
				//cerrar el envío
				
				opw.close();
				
				//leer la response desde la url
				BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String linea=null;
				
				while((linea=br.readLine())!=null) {
					System.out.println(linea);
				}
				//cerrar 
				br.close();
				
				
				} catch (MalformedURLException e) {	
				} catch (UnsupportedEncodingException e) {						
				} catch (IOException e) {}
				
		}
		
		

	}//main

}//class
