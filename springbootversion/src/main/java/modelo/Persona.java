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
	private LocalDate fechaNacimiento;

	public Persona(String nombre, String apellido, String genero, String dni, LocalDate fechaNacimiento) throws Exception {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.dni = dni;
		this.cuit = this.generarCuit(dni, genero);
		this.fechaNacimiento = fechaNacimiento;
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

                cuit = switch (genero) {
                case "Femenino" -> "20-" + dni + "-8";
                case "Masculino" -> "22-" + dni + "-3";
                default -> "18-" + dni + "-0";
            };

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
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
