package url;

public class PruebaResourceServer {

	public static void main(String[] args) {

		ResourceServer rs = new ResourceServer();
		rs.addTipo(".*/pdf", "pdfs");
		rs.addTipo(".*steam", "exe");
		rs.addTipo("audio/.*", "audio");
		rs.addTipo(".*/zip", "zips");
		rs.addTipo("text/plain", "txts");
		rs.addTipo(".*html", "htmls");
		rs.addTipo("video/.*", "video");

		try {
			rs.crearCarpetas();
			rs.descargar("https://aulavirtual32.educa.madrid.org/ies.barajas.madrid/pluginfile.php/8991/assignsubmission_file/submission_files/7339/102-DI-MZS.zip");
			rs.descargar("https://1.bp.blogspot.com/-GEJK4jvWSIg/XIMZ7teAwcI/AAAAAAAABLI/zHwwYPH6t_Y5b_BzZqdSYjuEdZJ8NfP1ACLcBGAs/s1600/PashGioBruno.png");
			rs.descargar("https://www.google.com");
			rs.descargar("https://www.youtube.com/audiolibrary_download?vid=7caa183b14503ee4");
			rs.descargar("https://www.sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4");
			rs.descargar("https://aulavirtual32.educa.madrid.org/ies.barajas.madrid/mod/resource/view.php?id=4633");
			rs.descargar("ftp://ftp.man.lodz.pL/pub/security/README.html");
			rs.descargar("http://25.io/toau/audio/sample.txt");
			
			System.out.println("FIN");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}// main

}// class
