package concurencia;

public class pruebaTic {

	public static void main(String[] args) {
		Tic tic= null;
		Tic tac= null; 
		tic= new Tic("TIC");
		tac= new Tic("TAC");
		tic.start();
		tac.start();
		/*try {
			h.join();
		
		} catch (InterruptedException e) {}
		System.out.println("HILOS CREADOS...");*/
	}//main

}
