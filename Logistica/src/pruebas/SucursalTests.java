package pruebas;

import modelo.Localidad;
import modelo.Sucursal;

public class SucursalTests {

	public static void main(String[] args) {
		
		String nombre = "Avellaneda";
		String provincia = "Buenos Aires";
		
		Localidad localidad = new Localidad(nombre, provincia);
		
		Sucursal sucursal = new Sucursal(1234, "CIT", localidad);
		
		// CONTINUAR...

	}

}
