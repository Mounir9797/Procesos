package ejercicios;


public class Monitor {

	private int contador;
	private boolean ocupado;
	
	private Monitor(int contador) {
		this.contador=contador;
		this.ocupado=false;
		System.out.println("CONTADOR "+contador);
		
	}//constructor
	

	public Monitor() {
		this(0);
	}


	public synchronized void entrar (int n) throws InterruptedException{ 
		
		//n dice que cantidad (positiva o negativa) queremos poner
		
		
		/*Si llega alguien y hay alguien dentro >> BLOQUEO
		 * 
		 * Si no hay nadie dentro
		 * 		si soy consumidor y no hay suficiente >> BLOQUEO
		 * 
		 * Resumiendo: hay BLOQUEO si
		 * 		el monitor esta ocupado 
		 * 		o 
		 * 		si soy consumidor y no hay suficiente
		 */
		
		//while(n<0) if(contador+n<0)  wait(); 	

		System.out.println(Thread.currentThread().getName()+"INTENTA "+n);
		while (ocupado || (n<0)&&(contador<Math.abs(n))) wait();
		ocupado=true;
		
	}//entrar
	
	
	public synchronized void actualizar(int n) {
		
		
		System.out.println(Thread.currentThread().getName()+"..."+n);
		
		contador+=n;
		System.out.println("NUEVO contador..."+contador);
		//sumar o restar al contador
		
		
	}//actualizar
	
	public synchronized void salir(){
	
		//liberar y notificar
		ocupado=false;
		notifyAll();
	}//salir

}
