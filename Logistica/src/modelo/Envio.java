package modelo;

public class Envio {
	
	private Paquete paquete;
	private Localidad origen;
	private Localidad destino;
	private Persona transportista;
	private Vehiculo transporte;
	
	public Envio(Paquete paquete, Localidad origen, Localidad destino, Persona transportista, Vehiculo transporte) {
		super();
		this.paquete = paquete;
		this.origen = origen;
		this.destino = destino;
		this.transportista = transportista;
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return "Envio [paquete=" + paquete + ", origen=" + origen + ", destino=" + destino + ", transportista="
				+ transportista + ", transporte=" + transporte + "]";
	}	
}
