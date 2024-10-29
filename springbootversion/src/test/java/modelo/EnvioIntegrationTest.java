package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EnvioIntegrationTest {
    private Paquete paquete;
    private Localidad origen;
    private Localidad destino;
    private Localidad destinoNoInternacional;
    private Persona transportista;
    private Vehiculo transporte;
    private Vehiculo transporteNulo;
    private Vehiculo nuevoTransporte;
    private Envio envio;

    @BeforeEach
    void setUp() throws Exception {
        paquete = new Paquete(1,10.0f,125);
        origen = new Localidad("Lanús","Buenos Aires");
        destino = new Localidad("Río Cuarto","Cordoba");
        destinoNoInternacional = new Localidad("Lanús","Buenos Aires");
        transportista = new Persona("Pepe","Argento","Masculino","12181246", LocalDate.of(1981,10,14));
        transporte = new Vehiculo("Ford","Transit",1994,1,50000);
        nuevoTransporte = new Vehiculo("Ford","Transit",1994,1,50000);
        envio = new Envio(paquete, origen, destino, transportista,transporte);
    }

    @Test
    void testEsEnvioInternacionalReturnTrue() {
        assertTrue(envio.esEnvioInternacional());
    }

    @Test
    void testEsEnvioInternacionalReturnFalse() {
        envio.setDestino(destinoNoInternacional);
        assertFalse(envio.esEnvioInternacional());
    }

    @Test
    void testCalcularCostoEnvio() {
        double costoEsperado = 10 + (50 * 0.5) + (10 * 2);
        assertEquals(costoEsperado, envio.calcularCostoEnvio(), 0.01);
    }

    @Test
    void testAgregarVehiculoAlEnvio_VehiculoNulo() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            envio.agregarVehiculoAlEnvio(transporteNulo);
        });

        assertEquals("El vehículo no puede ser nulo.", exception.getMessage());
    }

    @Test
    void testAgregarVehiculoAlEnvio_VehiculoExistente(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            envio.agregarVehiculoAlEnvio(nuevoTransporte);
        });
        assertEquals("Ya existe un vehículo asignado para este envío.", exception.getMessage());
    }
}
