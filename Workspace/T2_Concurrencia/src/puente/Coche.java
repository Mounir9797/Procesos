package puente;

public class Coche extends Thread{
	

	private Puente p;
	private int id;
	private boolean parar;
	
	public Coche(Puente p, int matricula, boolean parar) {
		super();
		this.p = p;
		this.id = matricula;
		this.parar = parar;
	}//constructor
	
	public void run() {
		while (!parar) {
			
			double n= Math.random();
			int dir= (n>=0.8)? 1:0;
			
			//int dir= (int) Math.round(Math.random());
			id= (int) (Math.random()*9999);
			
		}
	}
}//class
