package concurencia;


public class Tic extends Thread{
	
	/*1. Escribir un hilo llamado Tic que escriba una palabra cada segundo.
	 *  Debe tener un constructor que admita como parametro la palabra a escribir. Poner al hilo el nombre de la palabra.
	Escribir tambien un programa que instancie y lance un hilo.
	*/



	public Tic( String nombre) {
		this.setName(nombre);
	}
	
	public Tic() {
		this("TIC");
	}
	
	public void run() {
		while(true) {
			
			System.out.println(this.getName());
			try {
				sleep(1000); //esperar
			} catch (InterruptedException e) {}
		}//while
		

	}//run
}
