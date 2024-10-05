package modelo;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehiculoTest {
	private Vehiculo vehiculo;
	private Vehiculo vehiculo2;
	
	@BeforeEach
	void setUp() throws Exception {
		vehiculo = new Vehiculo("Fiat", "Modelo1", 2010, 4, 20000);
		vehiculo2 = new Vehiculo("Fiat", "Modelo1", 2010, 2021, 20000);
	}

	@Test
    void testEsElectricoReturnFalse() {
        assertEquals(vehiculo.esElectrico(vehiculo.getVersionModelo()), false);

    }
	
	@Test
    void testEsElectricoReturnTrue() {
        assertEquals(vehiculo.esElectrico(vehiculo2.getVersionModelo()), true);

    }
	
	@Test
	void testEsGasoleroReturnTrue() {
		assertEquals(vehiculo.esGasolero(vehiculo.getVersionModelo()),true);
		
	}
	
	@Test
	void testEsGasoleroReturnFalse() {
		assertEquals(vehiculo2.esGasolero(vehiculo2.getVersionModelo()),false);
		
	}
	
	@Test
	void testCotizarVehiculo1() {
		assertEquals(vehiculo.cotizar(vehiculo.getLanzamientoModelo(),vehiculo.getVersionModelo() , 
				vehiculo.getKilometraje()), -6724,8);
	}
	
	@Test
	void testCotizarVehiculo2() {
	    assertEquals(vehiculo2.cotizar(vehiculo2.getLanzamientoModelo(), vehiculo2.getVersionModelo(), 
	                  vehiculo2.getKilometraje()), 678651.75); 
	}
	
	


}
