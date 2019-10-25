
public class HiloSleepRun implements Runnable {

	//un hilo puede tener atributos
	private int cont;
	private int id;
	private long milisec;
	
	Thread th;
	
	//constructor
	public HiloSleepRun(int id, long milisec) {
		this.cont=0;
		this.id=id;
		th= Thread.currentThread();
		th.setName("h"+id);
		this.milisec= milisec;
		System.out.println("Hilo "+id+" creado");
	}//constructor
	
	public HiloSleepRun(int id) {
		this.id=id;
		th.setName("h"+id);
		this.milisec= 0;
		System.out.println("Hilo "+id+" creado");
	}//constructor
	
	public void run() {
		while(cont<= 5) {
			//System.out.println("Hilo nº "+id+" contador: "+cont);
			System.out.println("Hilo nº "+th.getId()+" "+th.getName()+" contador: "+cont);
			cont++;
			try {
				th.sleep(milisec);
			} catch (InterruptedException e) {}
		}//while
		
		System.out.println("FIN DEL HILO.............."+id);
	}//run
		
}//class
