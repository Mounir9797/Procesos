
public class Hilo_V2 extends Thread {

	//un hilo puede tener atributos
	private int cont;
	private int id;
	
	//constructor
	public Hilo_V2(int id) {
		this.id=id;
		System.out.println("Hilo "+id+" creado");
		this.setName("h"+id);
	}//constructor
	
	public void run() {
		while(cont<= 5) {
			//System.out.println("Hilo nº "+id+" contador: "+cont);
			System.out.println("Hilo nº "+this.getId()+" "+this.getName()+" contador: "+cont);
			cont++;
		}//while
		
		System.out.println("FIN DEL HILO.............."+id);
	}//run
		
}//class
