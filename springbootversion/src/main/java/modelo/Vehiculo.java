package modelo;

import java.util.Random;

public class Vehiculo {

	private String patente;
	private String marca;
	private String modelo;
	private int lanzamientoModelo;
	private int versionModelo;
	private float kilometraje;
	private float cotizacion;	

	public Vehiculo(String marca, String modelo, int lanzamientoModelo, int versionModelo, float kilometraje) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.lanzamientoModelo = lanzamientoModelo;
		this.versionModelo = versionModelo;
		this.kilometraje = kilometraje;
		this.patente = this.generatePatente(3, 3);
	}	

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", lanzamientoModelo="
				+ lanzamientoModelo + ", versionModelo=" + versionModelo + ", kilometraje=" + kilometraje
				+ ", cotizacion=" + cotizacion + "]";
	}

	public boolean esElectrico(int version) {

		boolean esElectrico = false;

		if (version > 2020) {
			esElectrico = true;
		}

		return esElectrico;
	}

	public boolean esGasolero(int version) {

		boolean esGasolero = false;
		boolean esElectrico = this.esElectrico(version);

		if (!esElectrico && version < 2008) {
			esGasolero = true;
		}

		return esGasolero;
	}

	public float cotizar(int lanzamientoModelo, int versionModelo, float kilometraje) {

	    System.out.println("Lanzamiento: " + lanzamientoModelo + ", Versión: " + versionModelo + ", Kilometraje: " + kilometraje);

		float precio;
		float apreciacion = (versionModelo - lanzamientoModelo) + 325;
		float despreciacion = kilometraje / 100000;
		
		if (versionModelo > 2020) {
			precio = versionModelo * (apreciacion - despreciacion);
		}

		else {			
			
			if (versionModelo < 2020 && versionModelo > 2005) {
				precio = versionModelo * (apreciacion - despreciacion);
			} 
			
			else {
				precio = versionModelo * (apreciacion - despreciacion);
			}
		}

		return precio;
	}

	public String generatePatente(int cantidadLetras, int cantidadNumeros) {

		String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random RANDOM = new Random();

		StringBuilder patente = new StringBuilder();

		for (int i = 0; i < cantidadLetras; i++) {
			int letterIndex = RANDOM.nextInt(LETTERS.length());
			patente.append(LETTERS.charAt(letterIndex));
		}

		patente.append('-');

		for (int i = 0; i < cantidadNumeros; i++) {
			int number = RANDOM.nextInt(10);
			patente.append(number);
		}

		return patente.toString();
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getLanzamientoModelo() {
		return lanzamientoModelo;
	}

	public void setLanzamientoModelo(int lanzamientoModelo) {
		this.lanzamientoModelo = lanzamientoModelo;
	}

	public int getVersionModelo() {
		return versionModelo;
	}

	public void setVersionModelo(int versionModelo) {
		this.versionModelo = versionModelo;
	}

	public float getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(float kilometraje) {
		this.kilometraje = kilometraje;
	}

	public float getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(float cotizacion) {
		this.cotizacion = cotizacion;
	}

}
