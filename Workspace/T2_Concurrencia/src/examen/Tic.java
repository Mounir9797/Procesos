package examen;

public class Tic extends Thread{
	
	String pal;
	public Tic (Turno t, String s) {
		this.pal=  s;
		this.setName(pal);
	}

}
