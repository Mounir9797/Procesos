package ejercicios;

public class PruebaProdConsV1 {

	public static void main(String[] args) {

		Monitor m= new Monitor();
		
		//int[] nums= {1,1,-3};
		Productor p1= new Productor(0, m, 1);
		Productor p2= new Productor(1, m, 1);
		Consumidor c= new Consumidor(2, m, 3);
		
		
		
		/*for (int i = 0; i < nums.length; i++) {
			if (nums[i]>0)(new Productor(i, m, nums[i])).start();
			else (new Consumidor(i, m, nums[i])).start();
		}*/
		p1.start();
		p2.start();
		c.start();
		try {
			Thread.sleep(100000L);
			p1.interrupt();
			p2.interrupt();
			c.interrupt();
			
			p1.join();
			p2.join();
			c.join();
		} catch (InterruptedException e) {}
		
		System.out.println("FIN DE PROGRAMA...");

	}

}
