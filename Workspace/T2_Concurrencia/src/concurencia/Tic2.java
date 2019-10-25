package concurencia;


public class Tic2 extends Thread{
	
	/*1. Escribir un hilo llamado Tic que escriba una palabra cada segundo.
	 *  Debe tener un constructor que admita como parametro la palabra a escribir. Poner al hilo el nombre de la palabra.
	Escribir tambien un programa que instancie y lance un hilo.
	*/

	private String pal;
	private static String Ultimo;
	private int cont= 10800;
	

	public Tic2(String nombre) {
		this.pal= nombre;
		this.setName(nombre);
		
	}
	
	public Tic2() {
		this("Tic");
	}
	
	
	
	public void run() {
		
		synchronized (getClass()) {
			
	
		Ultimo="TIC";
		
		while(true) {
			
			
			try {
				if(Ultimo.equals(pal)) {
				//getClass().wait();
				}else 
				Ultimo= pal;
				
				escribir();
				cont= cont-2;
			} catch (InterruptedException e) {}
		}//while
		}
		
		

	}//run
	
	public synchronized void escribir() throws InterruptedException{

		
		System.out.println(pal+cont);
		
		sleep(1000);
		
		getClass().notifyAll();
		
	}
}
