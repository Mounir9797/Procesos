package banco;

public class PruebaCuentaV1 {

	public static void main(String[] args) throws InterruptedException {
		
		Cuenta c= new Cuenta(500);
		
		Movimiento[] movs= new Movimiento [3];
		
		for (int i = 0; i < 2; i++) {
			movs[i]= new Movimiento(i, c, false);
			movs[i].start();
			
		}
		
		movs[2]= new Movimiento(2, c, true);
		movs[2].start();
		
		Thread.sleep(60000);
		
		try {
			
			for (Movimiento m : movs) {
				
				m.interrupt();
				m.join();
				
			}//for
			
		} catch (InterruptedException e){}

	}//main

}//class
