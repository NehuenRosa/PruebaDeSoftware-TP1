package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaqueteTest {
    private Paquete paquete1;
    private Paquete paquete2;

    @BeforeEach
    void setUp() throws Exception {
        paquete1 = new Paquete(5, 0.7f, 1.7f);  // Parámetros: numero, peso, precioBase
        paquete2 = new Paquete(7, 4.7f, 6.7f);
    }

    @Test
    void testCotizarEnvioTrue() {
        // Comprobamos que el resultado de cotizarEnvio para el paquete1 es el esperado (8.5f)
        assertEquals(8.5f, paquete1.cotizarEnvio(paquete1.getPeso(), paquete1.isFragil(), paquete1.getPrecioBase()), 0.01);}

    @Test
    void testCotizarEnvioFalse() {
    	  assertEquals(20.0f, paquete2.cotizarEnvio(paquete1.getPeso(), paquete2.isFragil(), paquete1.getPrecioBase()), 20.01);
    	  }

    @Test
    void testEsFragilTrue() {
   
        assertTrue(paquete1.esFragil(paquete1.getPeso()));
    }

    @Test
    void testEsFragilFalse() {
      
        assertFalse(paquete2.esFragil(paquete2.getPeso()));
    }
/*
    @Test
    void testGenerarNumeroSeguimientoTrue() {
        
        assertEquals(0, paquete1.generarNumeroSeguimiento(paquete2.getNumero())); // Comparamos el número generado con el esperado
    }

    @Test
    void testGenerarNumeroSeguimientoFalse() {
     
        assertEquals(paquete2.generarNumeroSeguimiento(paquete2.getNumero()));    }
*/
}
