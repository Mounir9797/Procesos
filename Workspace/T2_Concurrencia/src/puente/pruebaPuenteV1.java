package puente;

public class pruebaPuenteV1 {

	public static void main(String[] args) {

		Puente p= new Puente();
		CarSpawner[] cp= new CarSpawner[3];
		
		/*for (CarSpawner carSpawner : cp) {
			carSpawner= new CarSpawner(p, i);
			carSpawner.start();
		}*/
		
		for (int i = 0; i < cp.length; i++) {
			cp[i]= new CarSpawner(p, i);
			cp[i].start();
		}

	}

}
