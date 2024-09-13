package modelo;

public class Localidad {

	private String nombre;
	private String provincia;
	private String alias;
	private boolean esCentralOperativa;

	public Localidad(String nombre, String provincia) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		this.alias = this.obtenerAlias(nombre, provincia);
		this.esCentralOperativa = this.esCetral(nombre);
	}	

	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + ", provincia=" + provincia + ", alias=" + alias + ", esCentralOperativa="
				+ esCentralOperativa + "]";
	}

	public boolean esCetral(String nombre) {

		boolean esCentral = false;

		switch (nombre) {
		case "Avellaneda":
			esCentral = true;
			break;
		case "Tigre":
			esCentral = true;
			break;
		case "Benavidez":
			esCentral = true;
			break;
		case "La plata":
			esCentral = true;
			break;
		default:
			esCentral = false;
		}

		return esCentral;
	}

	public String obtenerAlias(String nombre, String provincia) {

		String alias = nombre.substring(0, 2).toUpperCase() + provincia.substring(0, 2).toUpperCase();
			
		if(this.esCetral(nombre)) {
			
			alias += "CO"; // CO = CENTRAL OPERATIVA
		}

		return alias;
	}

}
