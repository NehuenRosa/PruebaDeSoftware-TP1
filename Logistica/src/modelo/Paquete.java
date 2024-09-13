package modelo;

public class Paquete {
	private int numero;
	private String origen;
	private String destino;
	private boolean fragil;
	private float peso;
	
	public Paquete(int numero, String origen, String destino, boolean fragil, float peso) {
		super();
		this.numero = numero;
		this.origen = origen;
		this.destino = destino;
		this.fragil = fragil;
		this.peso = peso;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public boolean isFragil() {
		return fragil;
	}

	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public boolean esFragil (float peso) {
		
		boolean esFragil = false;
		
		if (peso < 2.00) {
			esFragil = true;
		}
		
		return esFragil;
	}
	
	public int generarNumero (int digitos) {
		
		int numeroPaquete = 0;
		
		for(int i = 0; i<digitos; i++) {
			
			numeroPaquete += (i+1 * digitos);
			
		}
		
		return numeroPaquete/digitos;
	}
	
	
}
