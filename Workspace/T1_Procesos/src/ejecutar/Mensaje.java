package ejecutar;

public class Mensaje {
	
	public static void main(String[] args) {
		/*Recibe como argumentos una plabra y un numero
		 * Escribela palabra recibida tantas veces como diga el número
		 */
		
		if(args.length<2)
			System.out.println("Se necesitan una palabra y un número");
		else {
			int num=Integer.parseInt(args[1]);
			for (int i = 0; i < num; i++) System.out.println(args[0]);
		}//if
	}//main

}//class
