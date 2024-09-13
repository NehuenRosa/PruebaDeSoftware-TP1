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
	
	public Sucursal(int codigo, String nombre, Localidad localidad, List<Vehiculo> vehiculos, List<Persona> personas,
			List<Paquete> paquetes) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.localidad = localidad;
		this.vehiculos = vehiculos;
		this.personas = personas;
		this.paquetes = paquetes;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
	
	

}
