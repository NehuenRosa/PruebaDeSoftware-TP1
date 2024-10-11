package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private int codigo;
    private String nombre;
    private Localidad localidad;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();
    private List<Paquete> paquetes = new ArrayList<>();
    private List<Envio> envios = new ArrayList<>();
    
    public Sucursal(int codigo, String nombre, Localidad localidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Sucursal [codigo=" + codigo + ", nombre=" + nombre + ", localidad=" + localidad + 
               ", vehiculos=" + vehiculos + ", personas=" + personas + ", paquetes=" + paquetes + 
               ", envios=" + envios + "]";
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

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	
    public void agregarPersona(Persona persona) {
        personas.add(persona);
        System.out.println("Persona agregada: " + persona);
    }

    
    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
        System.out.println("Paquete agregado: " + paquete);
    }

    
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado: " + vehiculo);
    }

    
    public void generarEnvio(Persona persona, Vehiculo transporte, Paquete paquete, Localidad origen, Localidad destino) {
       
        Envio envio = new Envio(  paquete, origen, destino,persona,transporte);
        envios.add(envio);
        System.out.println("Envío generado: " + envio);
    }
}
