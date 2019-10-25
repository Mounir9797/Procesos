
public class PruebaHiloSleep {
	public static void main(String[] args) {
		
		HiloSleep h= null; //extiende thread
		h= new HiloSleep(0, 500);
		h.start();
		try {
			h.join();
		
		/*HiloSleepRun h= null;  //Implementa Runable
		h= new HiloSleepRun(0,500);
		h.run();*/
		
		for(int i=1; i<3;i++) {
			h=new HiloSleep(i);
			h.start();
			
				h.join();
			
			
			/*h= new HiloSleepRun(i);
			h.run();*/
		}//for
		
		} catch (InterruptedException e) {}
		System.out.println("HILOS CREADOS...");
	}//main
}
