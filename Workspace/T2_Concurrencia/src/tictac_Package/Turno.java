package tictac_Package;

public class Turno {

	public volatile String ultimo;
	
	public Turno() {
		this.ultimo= "TAC";
	}//constructor
	
	public synchronized void entrar () throws InterruptedException{ 
		if(ultimo.equals(Thread.currentThread().getName())) wait();
	}
	
	
	public void escribir() {
		
			//SECCIÓN CRÍTICA
			System.out.println(Thread.currentThread().getName());
			
	}//escribir
	
	public synchronized void salir() throws InterruptedException {
		
		TicTac.sleep(1000);
		
		//actualizar turno y notificar
		ultimo=Thread.currentThread().getName();
		notifyAll();
	}
}//class
