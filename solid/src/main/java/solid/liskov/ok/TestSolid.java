package solid.liskov.ok;

public class TestSolid {

	public static void main(String[] args) {
		CocheSolid[] arrayCoches = {  
		        new Renault(),
		        new Ferrari(),
		};
		imprimirNumAsientos(arrayCoches);
	}
	
	public static void imprimirNumAsientos(CocheSolid[] arrayCoches){  
        for (CocheSolid coche : arrayCoches) {
            System.out.println(coche.numAsientos());
        }
    }
}
