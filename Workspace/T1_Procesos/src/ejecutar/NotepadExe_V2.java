package ejecutar;

import java.io.IOException;

public class NotepadExe_V2 {

	public static void main(String[] args) {
		// Ejecuta Notepad.exe
		
		ProcessBuilder pb= new ProcessBuilder("Notepad");
		
		try {
			pb.start();
		} catch (IOException e) {}
	}//main

}//class
