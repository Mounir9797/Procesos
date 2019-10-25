package puente;

import java.util.ArrayList;

public class Puente {
	
	public static final int I=0;
	public static final int D=1;
	
	private volatile boolean ocupado;
	private long retardo;
	private ArrayList<Coche> colaD;
	private ArrayList<Coche> colaI;


	public Puente(long retardo) {
		this.ocupado = false;
		this.retardo = retardo;
		this.colaD = new ArrayList<Coche>();
		this.colaI = new ArrayList<Coche>();
	}
	
	public Puente() {
		this(2000L);
	}
}

	