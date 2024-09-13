package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String genero;
	private int edad;
	private String dni;
	private String cuit;	

	public Persona(String nombre, String apellido, String genero, String dni, LocalDate fechaNacimiento) throws Exception {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.dni = dni;
		this.cuit = this.generarCuit(dni, genero);
		this.edad = this.calcularEdad(fechaNacimiento);
	}	

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", edad=" + edad
				+ ", dni=" + dni + ", cuit=" + cuit + "]";
	}

	public String generarCuit(String dni, String genero) throws Exception {
		
		if(dni.length() < 8 || dni.length() > 9) {
			throw new Exception("El documento ingresado no es valido");
		}
		
		String cuit = null;

		switch (genero) {
		case "Femenino":
			cuit = "20-" + dni + "-8";
			break;
		case "Masculino":
			cuit = "22-" + dni + "-3";
			break;
		default:
			cuit = "18-" + dni + "-0";
			break;
		}

		return cuit;
	}
	
	public int calcularEdad(LocalDate fechaNacimiento) {		

        LocalDate fechaActual = LocalDate.now();
    
        int edad = Period.between(fechaNacimiento, fechaActual).getYears();
        
        return edad;		
	}

	public boolean esMayorDeEdad(LocalDate fechaNacimiento) {
		
		int edad = this.calcularEdad(fechaNacimiento);
		
		boolean esMayor = false;

		if (edad >= 18) {
			esMayor = true;
		}

		return esMayor;
	}

}
