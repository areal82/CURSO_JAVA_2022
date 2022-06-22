package solid.openclose.ok;

public class TestSolid {

	public static void main(String[] args) {

		CocheSolid[] arrayCoches = { new Renault(), new Audi(), new Mercedes() };

		imprimirPrecioMedioCoche(arrayCoches);
	}

	public static void imprimirPrecioMedioCoche(CocheSolid[] arrayCoches) {
		for (CocheSolid coche : arrayCoches) {
			System.out.println(coche.precioMedioCoche());
		}
	}

}
