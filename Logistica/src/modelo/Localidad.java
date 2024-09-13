package modelo;

public class Localidad {

	private String nombre;
	private String provincia;
	
	public Localidad(String nombre, String provincia) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public boolean esConurbano (String nombre) {
		
		boolean esConurbano = false;
		
		if(nombre.equals("Lanus")) {
			esConurbano = true;
		}
		
		return esConurbano;
	}

	
}
