package modelo;

public class Persona {
	private String nombre;
	private String apellido;
	private String genero;
	private int edad;
	private String dni;
	
	public Persona(String nombre, String apellido, String genero, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.dni = dni;
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
	
	public String generarCuit (String dni, String genero) {
		String cuit = null;
		if(genero.equals("Femenino")){
	
			cuit = "20-"+ dni +"-8";
			
		}else {
			
			cuit = "22-"+ dni +"-3";
		}
			
		return cuit;
	}
	
	public boolean esMayorDeEdad (int edad) {
		boolean esMayor = false;
		
		if (edad >= 18) {
			esMayor = true;
		}
		
		return esMayor;
	}
	
}
