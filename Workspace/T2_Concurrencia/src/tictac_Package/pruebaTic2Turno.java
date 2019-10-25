package tictac_Package;

public class pruebaTic2Turno {

	public static void main(String[] args) {
		Turno t= new Turno();
		
		TicTac tic= new TicTac("TIC", t);
		TicTac tac= new TicTac("TAC", t);
		
		tic.start();
		tac.start();
		
		System.out.println("Fin del hilo principal");
		
		
	}//main

}
