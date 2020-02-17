package paquete;

import java.util.Properties;

public class PropiedadesJava {

	public static void main(String[] args) {
		
		Properties props= System.getProperties();
		
		props.list(System.out);

	}//main

}//class
