package modelo;

public class Paquete {

	private int numero;
	private int numeroSeguimiento;
	private boolean fragil;
	private float peso;
	private float precioBase;
	private float precioEnvio;

	public Paquete(int numero, float peso, float precioBase) {
		super();
		this.numero = numero;
		this.numeroSeguimiento = this.generarNumeroSeguimiento(numero);
		this.peso = peso;
		this.fragil = this.esFragil(peso);
		this.precioBase = precioBase;
		this.precioEnvio = this.cotizarEnvio(peso, this.esFragil(peso), precioBase);
	}	

	@Override
	public String toString() {
		return "Paquete [numero=" + numero + ", numeroSeguimiento=" + numeroSeguimiento + ", fragil=" + fragil
				+ ", peso=" + peso + ", precioBase=" + precioBase + ", precioEnvio=" + precioEnvio + "]";
	}

	public float cotizarEnvio(float peso, boolean esFragil, float precioBase) {

		float precioFinal = 0;
		
		if (peso > 15 && esFragil) {
			precioFinal += precioBase * 15;
		}

		else {

			if (peso > 15 && !esFragil) {
				precioFinal += precioBase * 7.5;
			}

			else {
				
				if (peso < 15 && esFragil) {
					precioFinal += precioBase * 5;
				} 
				
				else {
					precioFinal += precioBase * 2.5;
				}
			}
		}

		return precioFinal;

	}

	public boolean esFragil(float peso) {
		
		// Validad que el peso sea positivo

		boolean esFragil = false;

		if (peso < 2.00) {
			esFragil = true;
		}

		return esFragil;
	}

	public int generarNumeroSeguimiento(int numero) {		
		
		int numeroPaquete = numero * 1000;

		for (int i = 0; i < numero; i++) {

			numeroPaquete += (i + 1 * numero);
		}

		return numeroPaquete / numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroSeguimiento() {
		return numeroSeguimiento;
	}

	public void setNumeroSeguimiento(int numeroSeguimiento) {
		this.numeroSeguimiento = numeroSeguimiento;
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

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public float getPrecioEnvio() {
		return precioEnvio;
	}

	public void setPrecioEnvio(float precioEnvio) {
		this.precioEnvio = precioEnvio;
	}
	

}
