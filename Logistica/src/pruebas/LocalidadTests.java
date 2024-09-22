package pruebas;

import modelo.Localidad;

public class LocalidadTests {

	public static void main(String[] args) {
		
		String nombre = "Avellaneda";
		String provincia = "Buenos Aires";
		
		Localidad localidad = new Localidad(nombre, provincia);
		
		System.out.println(localidad);
	}
}
