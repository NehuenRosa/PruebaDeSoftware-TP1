package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalidadTest {
    private Localidad localidad1;
    private Localidad localidad2;

    @BeforeEach
    void setUp() throws Exception {
        localidad1 = new Localidad("Lanus", "Buenos Aires");
        localidad2 = new Localidad("Avellaneda", "Buenos Aires"); 
    }

    @Test
    void testEsCentralFalse() {
        assertEquals(localidad1.esCentral(localidad1.getNombre()), false);
    }

    @Test  
    void testEsCentralTrue() {
        assertEquals(localidad2.esCentral(localidad2.getNombre()), true); 
    }

    @Test
    void testObtenerAliasForNonCentral() {
        assertEquals("LABU", localidad1.obtenerAlias(localidad1.getNombre(), localidad1.getProvincia()));
    }

    @Test
    void testObtenerAliasForCentral() {
        assertEquals("AVBUCO", localidad2.obtenerAlias(localidad2.getNombre(), localidad2.getProvincia())); 
        }
}
