package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

	private int codigo;
	private String nombre;
	private Localidad localidad;
	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private List<Persona> personas = new ArrayList<Persona>();
	private List<Paquete> paquetes = new ArrayList<Paquete>();
	private List<Envio> envios = new ArrayList<Envio>();
	
	public Sucursal(int codigo, String nombre, Localidad localidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "Sucursal [codigo=" + codigo + ", nombre=" + nombre + ", localidad=" + localidad + ", vehiculos="
				+ vehiculos + ", personas=" + personas + ", paquetes=" + paquetes + ", envios=" + envios + "]";
	}	
	
	// AGREGAR PERSONA
	// AGREGAR PAQUETE
	// AGREGAR VEHICULOS
	// GENERAR ENVIO(PERSONA, VEHICULO, PAQUETE, ORIGEN LOCALIDAD, DESTINO LOCALIDAD)	
}
