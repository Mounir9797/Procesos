package puente;

public class CarSpawner extends Thread{
	

	private Puente p;
	private int id;
	private boolean parar;
	
	public CarSpawner(Puente p, int matricula) {
		super();
		this.p = p;
		this.id = matricula;
		this.parar = false;
	}//constructor
	
	public void run() {
		while (!parar) {
			
			/* generar una direccion... 0 o 1
			 * las dos direciones tienen diferente distribucion estadistica
			 * ahora el 1 es un 20% el 0 un 80%
			 * Daremos prioridad al carril minoritario, D
			 */
			double n= Math.random();
			int dir= (n>=0.6)? 1:0;
			
			//int dir= (int) Math.round(Math.random());
			id= (int) (n*9999); //generar una matricula de 4 cifras
			
			try {
				p.entrar(id, dir);
				sleep(p.getRetardo());
				p.pasar(dir, id);
				p.salir(dir);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}//class
