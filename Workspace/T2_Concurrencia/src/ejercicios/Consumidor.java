package ejercicios;

public class Consumidor extends Thread{

	private int cantidad;
	private Monitor m;
	private boolean parar;
	
	public Consumidor(int n,Monitor m, int cantidad) {
		
		this.cantidad= cantidad;
		this.m=m;
		this.setName("c"+n);
		this.parar=false;
	}
	
	public Consumidor(int n,Monitor m) {
		
		this(n, m, 1);
	}

	public void run() {
		
		while(!parar) {
			try {
				m.entrar(cantidad);
				//si no puede entrar se va a bloquear
				//cuando se desbloquee tendrá el cerrojo del monitor
				
				m.actualizar(cantidad);
				m.salir();
				
				sleep(5000L);
			} catch (InterruptedException e) {
				parar=true;
			}//try
			
		}//while
		
	}//run
}//class
