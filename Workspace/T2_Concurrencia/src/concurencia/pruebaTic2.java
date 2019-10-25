package concurencia;

public class pruebaTic2 {

	public static void main(String[] args) {
		Tic2 tic= null;
		Tic2 tac= null; 
		tic= new Tic2("TIC");
		tac= new Tic2("TAC");
		tic.start();
		tac.start();
		
		/*try {
			h.join();
		
		} catch (InterruptedException e) {}
		System.out.println("HILOS CREADOS...");*/
	}//main

}
