package ejecutar;

import java.io.IOException;

public class NotepadExe_V1 {

	public static void main(String[] args) {
		// Ejecuta Notepad.exe
		
		Runtime r= Runtime.getRuntime();
		
		try {
			Process p= r.exec("NOTEPAD");
		} catch (IOException e) {}
	}//main

}//class
