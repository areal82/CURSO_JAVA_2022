package solid.openclose.ko;

public class Test {

	public static void main(String[] args) {
		Coche[] arrayCoches = { new Coche("Renault"), new Coche("Audi") };
		imprimirPrecioMedioCoche(arrayCoches);

		Coche[] arrayCoches2 = { new Coche("Renault"), new Coche("Audi"), new Coche("Mercedes") };
		imprimirPrecioMedioCoche2(arrayCoches2);
	}

	public static void imprimirPrecioMedioCoche(Coche[] arrayCoches) {
		for (Coche coche : arrayCoches) {
			if (coche.marca.equals("Renault"))
				System.out.println(18000);
			if (coche.marca.equals("Audi"))
				System.out.println(25000);
		}
	}
	
	public static void imprimirPrecioMedioCoche2(Coche[] arrayCoches){  
	    for (Coche coche : arrayCoches) {
	        if(coche.marca.equals("Renault")) System.out.println(18000);
	        if(coche.marca.equals("Audi")) System.out.println(25000);
	        if(coche.marca.equals("Mercedes")) System.out.println(27000);
	    }
	}

}
