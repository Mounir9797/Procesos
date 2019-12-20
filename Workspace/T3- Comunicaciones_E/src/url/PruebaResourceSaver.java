package url;

import java.io.IOException;

public class PruebaResourceSaver {

	public static void main(String[] args) {
		
		ResourceSaver rs= new ResourceSaver();
		rs.addTipo(".*/pdf", "pdfs");
		rs.addTipo(".*stream", "exe");
		rs.addTipo("image/.*", "img");
		rs.addTipo("audio/.*", "audio");
		rs.addTipo(".*/zip", "zips");
		rs.addTipo("text/plain", "txts");
		rs.addTipo(".*/html", "htmls");
		rs.addTipo("video/.*", "videos");
		
	try {
		rs.crearCarpetas();
		rs.descargar("https://www.eclipse.org/downloads/download.php?file=/eclipse/downloads/drops4/R-4.13-201909161045/eclipse-Automated-Tests-4.13.zip");
		rs.descargar("https://upload.wikimedia.org/wikipedia/commons/6/67/Girasol.JPG");
		rs.descargar("https://www.google.es");
		rs.descargar("harry_styles_lights_up_official_video_9NZvM1918_E_1080p.mp4");
		rs.descargar("http://www.posgrado.unam.mx/filosofiadelaciencia/media/uploaded_files/2012/04/guia_digit_conacyt.pdf");
		
		
	} catch (IOException e) {
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}//main
}//class
