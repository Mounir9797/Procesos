package banco;

public class Movimiento extends Thread{
	
	private Cuenta c;
	private int id;
	private boolean parar, ingreso;
	private long retardo;
	
	public Movimiento(int id, Cuenta c, long retardo, boolean ingreso) {
		this.id= id;
		this.setName("m"+id);
		this.c=c;
		this.retardo=retardo;
		this.ingreso=ingreso;
		this.parar= false;
	}//constructor
	
	public Movimiento(int id, Cuenta c, boolean ingreso) {
		this.id= id;
		this.setName("m"+id);
		this.c=c;
		this.retardo= 2000L;
		this.ingreso=ingreso;
		this.parar= false;
	}//constructor

	public void run() {
		while (!parar) {
			
			int cantidad= (int) (Math.random()*1000);
			if(!ingreso) cantidad*=-1;	//reintegro negativo
			
			try {
				System.out.println(this.getName()+"... INTENTA... "+cantidad);	
				c.entrar(cantidad);
				c.operar(cantidad);
				c.salir();
				
				sleep(retardo);
			} catch (InterruptedException e) {
				parar=true;
			}
		}//while
	System.out.println("FIN DEL HILO ..."+this.getName());	
	}//run
	
}//class
