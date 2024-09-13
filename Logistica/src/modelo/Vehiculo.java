package modelo;

import java.util.Random;

public class Vehiculo {
	
	private String patente;
	private String marca;
	private String modelo;
	private int anio;
	private boolean electrico;
	
	public Vehiculo(String patente, String modelo, int anio, boolean electrico) {
		super();
		this.patente = patente;
		this.modelo = modelo;
		this.anio = anio;
		this.electrico = electrico;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean isElectrico() {
		return electrico;
	}

	public void setElectrico(boolean electrico) {
		this.electrico = electrico;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public boolean esElectrico (int anio) {
		
		boolean esElectrico = false;
		
		if(anio > 2020) {
			esElectrico = true;
		}
		
		return esElectrico;
	}
	
	public float cotizar (int anio) {
		float precio;
		
		if(anio > 2020) {
			precio = anio * 170;
		}else if (anio < 2020 && anio > 2005) {
			precio = anio * 120;
		}else {
			precio = anio * 90;
		}
		
		return precio;
	}
	
	
	public String generatePatente() {
		
		String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Random RANDOM = new Random();
	    
        StringBuilder patente = new StringBuilder();

        // Generar 3 letras aleatorias
        for (int i = 0; i < 3; i++) {
            int letterIndex = RANDOM.nextInt(LETTERS.length());
            patente.append(LETTERS.charAt(letterIndex));
        }

        // Agregar un guion
        patente.append('-');

        // Generar 3 números aleatorios
        for (int i = 0; i < 3; i++) {
            int number = RANDOM.nextInt(10);
            patente.append(number);
        }

        return patente.toString();
    }
	
	
	
}
