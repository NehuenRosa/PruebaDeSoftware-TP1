package modelo;

public class Envio {
	
	private Paquete paquete;
	private Localidad origen;
	private Localidad destino;
	private Persona transportista;
	private Vehiculo transporte;
	
	public Envio(Paquete paquete, Localidad origen, Localidad destino, Persona transportista) {
		super();
		this.paquete = paquete;
		this.origen = origen;
		this.destino = destino;
		this.transportista = transportista;
	}

	@Override
	public String toString() {
		return "Envio [paquete=" + paquete + ", origen=" + origen + ", destino=" + destino + ", transportista="
				+ transportista + ", transporte=" + transporte + "]";
	}	
	
	public void agregarVehiculoAlEnvio(Vehiculo nuevoVehiculo) throws Exception {
	    if (nuevoVehiculo == null) {
	        throw new IllegalArgumentException("El vehículo no puede ser nulo.");
	    }
	    if (this.transporte != null) {
	        throw new IllegalArgumentException("Ya existe un vehículo asignado para este envío.");
	    }
	    this.transporte = nuevoVehiculo; // Asigna el nuevo vehículo si no hay ninguno
	}

	
	public boolean esEnvioInternacional() {
	    return !origen.getProvincia().equalsIgnoreCase(destino.getProvincia());
	}

	public double calcularCostoEnvio() {
	    double distanciaFija = 50; 
	    double peso = paquete.getPeso();
	    double tarifaBase = 10; 
	    double costo = tarifaBase + (distanciaFija * 0.5) + (peso * 2);
	    return costo;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Localidad getOrigen() {
		return origen;
	}

	public void setOrigen(Localidad origen) {
		this.origen = origen;
	}

	public Localidad getDestino() {
		return destino;
	}

	public void setDestino(Localidad destino) {
		this.destino = destino;
	}

	public Persona getTransportista() {
		return transportista;
	}

	public void setTransportista(Persona transportista) {
		this.transportista = transportista;
	}

	public Vehiculo getTransporte() {
		return transporte;
	}

	public void setTransporte(Vehiculo transporte) {
		this.transporte = transporte;
	}
	
	

}
