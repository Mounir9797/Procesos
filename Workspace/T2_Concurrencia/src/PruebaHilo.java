
public class PruebaHilo {
	public static void main(String[] args) {
		Hilo_V2 h= null;
		
		for(int i=0; i<3;i++) {
			
			h= new Hilo_V2(i);
			h.start();
		}//for
		System.out.println("HILOS CREADOS...");
	}//main
}
