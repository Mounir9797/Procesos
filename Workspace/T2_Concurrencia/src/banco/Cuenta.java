package banco;

public class Cuenta {

	private volatile int saldo;
	private volatile boolean libre;
	
	public Cuenta(int saldo) {
		this.saldo= saldo;
		this.libre= true;
	}//constructor
	
	public Cuenta() {this(0);}//constructor vacio
	
	public synchronized void entrar(int mov) throws InterruptedException {
		//decidir en qué condiciones se bloquee un hilo
		/*bloquear SI 
		 * no esta libre
		 *OR quiero sacar AND no hay suficiente
		 * 
		 */
		while (!libre || (mov<0) && (saldo<Math.abs(mov))) wait();
		libre=false;
	}//entrar
	
	public  synchronized void operar(int mov) {
		saldo+= mov;
		System.out.println("NUEVO SALDO ...... "+saldo);	
	}//operar
	
	public synchronized void salir() {
		libre=true;
		notifyAll();
	}//salir
}//class
