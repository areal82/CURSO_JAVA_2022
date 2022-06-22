package solid.liskov.ko;

import solid.openclose.ok.Audi;
import solid.openclose.ok.CocheSolid;
import solid.openclose.ok.Ford;
import solid.openclose.ok.Mercedes;
import solid.openclose.ok.Renault;

public class Test {

	public static void main(String[] args) {
		CocheSolid[] arrayCoches = {  
		        new Renault(),
		        new Audi(),
		        new Mercedes(),
		        new Ford()
		};
		
		imprimirNumAsientos(arrayCoches);  

	}

	public static void imprimirNumAsientos(CocheSolid[] arrayCoches) {
		for (CocheSolid coche : arrayCoches) {
			if (coche instanceof Renault)
				// System.out.println(numAsientosRenault(coche));
			if (coche instanceof Audi)
				// System.out.println(numAsientosAudi(coche));
			if (coche instanceof Mercedes)
				// System.out.println(numAsientosMercedes(coche));
			if (coche instanceof Ford) {
				//System.out.println(numAsientosFord(coche));
			}
		}
	}

	private static char[] numAsientosFord(Ford coche) {
		// TODO Auto-generated method stub
		return null;
	}

	private static char[] numAsientosMercedes(Mercedes coche) {
		// TODO Auto-generated method stub
		return null;
	}

	private static char[] numAsientosAudi(Audi coche) {
		// TODO Auto-generated method stub
		return null;
	}

	private static char[] numAsientosRenault(Renault coche) {
		// TODO Auto-generated method stub
		return null;
	}

}
