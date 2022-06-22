package solid.singleresponsability.ko;

class Coche {
	
	String marca;

	Coche(String marca) {
		this.marca = marca;
	}

	String getMarcaCoche() {
		return marca;
	}

	void guardarCocheDB(Coche coche){
		// Salvar coche en base de datos
	}
}