
public class HiloSleep extends Thread {

	//un hilo puede tener atributos
	private int cont;
	private int id;
	private long milisec;
	
	//constructor
	public HiloSleep(int id, long milisec) {
		this.id=id;
		this.setName("h"+id);
		this.milisec= milisec;
		System.out.println("Hilo "+id+" creado");
	}//constructor
	
	public HiloSleep(int id) {
		this.id=id;
		this.setName("h"+id);
		this.milisec= 0;
		System.out.println("Hilo "+id+" creado");
	}//constructor
	
	public void run() {
		while(cont<= 5) {
			//System.out.println("Hilo nº "+id+" contador: "+cont);
			System.out.println("Hilo nº "+this.getId()+" "+this.getName()+" contador: "+cont);
			cont++;
			try {
				sleep(milisec); //método estático, DE CLASE
			} catch (InterruptedException e) {}
		}//while
		
		System.out.println("FIN DEL HILO.............."+id);
	}//run
		
}//class
