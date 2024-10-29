package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SucursalIntegrationTest {
    private Sucursal sucursal;
    private Localidad localidad;
    private Persona persona;
    private Vehiculo vehiculo;
    private Paquete paquete;
    private Localidad origen;
    private Localidad destino;

    @BeforeEach
    void setUp()  throws Exception {
        paquete = new Paquete(1,10.0f,125);
        localidad = new Localidad("Lanús","Buenos Aires");
        persona = new Persona("Pepe","Argento","Masculino","12181246", LocalDate.of(1981,10,14));
        vehiculo = new Vehiculo("Ford","Transit",1994,1,50000);
        sucursal = new Sucursal(1,"Sucursal1",localidad);
        origen = new Localidad("Luis Guillon", "Buenos Aires");
        destino = new Localidad("La Pampa", "La Pampa");
    }

    @Test
    void testAgregarPersona() {
        sucursal.agregarPersona(persona);
        assertEquals(1, sucursal.getPersonas().size());
        assertEquals(persona, sucursal.getPersonas().get(0));
    }

    @Test
    void testAgregarPaquete() {
        sucursal.agregarPaquete(paquete);
        assertEquals(1, sucursal.getPaquetes().size());
        assertEquals(paquete, sucursal.getPaquetes().get(0));
    }

    @Test
    void testAgregarVehiculo() {
        sucursal.agregarVehiculo(vehiculo);
        assertEquals(1, sucursal.getVehiculos().size());
        assertEquals(vehiculo, sucursal.getVehiculos().get(0));
    }

    @Test
    void testGenerarEnvio() {
        sucursal.agregarPersona(persona);
        sucursal.agregarVehiculo(vehiculo);
        sucursal.agregarPaquete(paquete);

        sucursal.generarEnvio(persona, vehiculo, paquete, origen, destino);

        // Verifica que el envío se ha creado y agregado correctamente
        assertEquals(1, sucursal.getEnvios().size());
        Envio envio = sucursal.getEnvios().get(0);

        // Verifica que el envío contiene los mocks esperados
        assertEquals(persona, envio.getTransportista());
        assertEquals(vehiculo, envio.getTransporte());
        assertEquals(paquete, envio.getPaquete());
        assertEquals(origen, envio.getOrigen());
        assertEquals(destino, envio.getDestino());
    }
}
