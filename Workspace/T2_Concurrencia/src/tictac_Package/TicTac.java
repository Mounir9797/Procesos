package tictac_Package;


public class TicTac extends Thread{
	
	/*1. Escribir un hilo llamado Tic que escriba una palabra cada segundo.
	 *  Debe tener un constructor que admita como parametro la palabra a escribir. Poner al hilo el nombre de la palabra.
	Escribir tambien un programa que instancie y lance un hilo.
	*/


	protected String pal;
	private Turno t;
	

	public TicTac(String nombre, Turno t) {
		this.pal= nombre;
		this.t=t;
		this.setName(pal);
	}
	
	public TicTac(Turno t) {
		this("Tic", t);
	}
	
	public void run() {
		
		while(true) {
			
			try {
				t.entrar();
				
				t.escribir();
				
				t.salir();

			} catch (InterruptedException e) {}
		}//while	

	}//run
	
}//class
