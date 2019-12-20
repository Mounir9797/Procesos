package puente;

import java.util.ArrayList;

public class Puente {
	
	//mientras haya coches a la derecha, no pasa ninguno de la izquierda
	
	public static final int I=0;
	public static final int D=1;
	
	private volatile boolean ocupado;
	private long retardo;
	private ArrayList<Integer> colaD;
	private ArrayList<Integer> colaI;


	public Puente(long retardo) {
		this.ocupado = false;
		this.retardo = retardo;
		this.colaD = new ArrayList<>();
		this.colaI = new ArrayList<>();
	}//
	
	public Puente() {this(2000L);}
	
	public synchronized void entrar(int coche, int dir) throws InterruptedException {
		
		/*Mientras
		 *  no seas el primero de la derecha
		 * OR
		 * 	eres el primero de la izquiera y hay coches a la derecha 
		 * 	vengas por la izquierda AND haya coches por la izquierda
		 * 
		 * WAIT
		 */
		
		while(ocupado
				||!colaD.isEmpty() && coche!= colaD.get(0) 
				|| dir==I && !colaI.isEmpty() && coche!= colaI.get(0)) {
			
			if(dir==D && !colaD.contains(coche)) colaD.add(coche);
			else if (dir==I && !colaI.contains(coche)) colaI.add(coche);
			
			System.out.println(coche+"..DCH.."+colaD);
			System.out.println(coche+"..IZQ.."+colaI);
			wait();
		}//while
		
		ocupado=true;
		
	}//entrar
	
	public synchronized void pasar(int dir, int coche) throws InterruptedException {
	
		//dormirá antes de pasar
		
		Thread.currentThread();
		Thread.sleep(retardo);
		
		if(dir==D && !colaD.isEmpty()) colaD.remove(new Integer(coche));
		else if (!colaI.isEmpty()) colaI.remove(new Integer(coche));
		
		/*System.out.println("ENTRA...."+coche+"..."+dir);
		System.out.println("DCH...."+colaD);
		System.out.println("IZQ...."+colaI);*/
	}
	
	public synchronized void salir(int dir) {
		
		
		System.out.println("SALE.........");
		ocupado=false;
		notifyAll();
		
		
	}
	
	public long getRetardo() {
		return retardo;
	}
}//class

	