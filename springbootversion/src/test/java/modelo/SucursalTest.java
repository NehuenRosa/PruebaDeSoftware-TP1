package modelo;

import modelo.Persona;
import modelo.Paquete;
import modelo.Sucursal;
import modelo.Vehiculo;
import modelo.Envio; // Asegúrate de que esta clase esté definida
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

class SucursalTest {

    private Sucursal sucursal;
    private Localidad localidad;
    private Persona personaMock;
    private Vehiculo vehiculoMock;
    private Paquete paqueteMock;

    @BeforeEach
    void setUp() {
        localidad = new Localidad("Ciudad", "Provincia"); 
        sucursal = new Sucursal(1, "Sucursal Central", localidad);
        
      
        personaMock = Mockito.mock(Persona.class);
        vehiculoMock = Mockito.mock(Vehiculo.class);
        paqueteMock = Mockito.mock(Paquete.class);
    }

    @Test
    void testAgregarPersona() {
        sucursal.agregarPersona(personaMock);
        
     
        assertEquals(1, sucursal.getPersonas().size());
        assertEquals(personaMock, sucursal.getPersonas().get(0));
    }

    @Test
    void testAgregarPaquete() {
        sucursal.agregarPaquete(paqueteMock);
        
        // Verifica que el paquete se ha añadido correctamente
        assertEquals(1, sucursal.getPaquetes().size());
        assertEquals(paqueteMock, sucursal.getPaquetes().get(0));
    }

    @Test
    void testAgregarVehiculo() {
        sucursal.agregarVehiculo(vehiculoMock);
        
        // Verifica que el vehículo se ha añadido correctamente
        assertEquals(1, sucursal.getVehiculos().size());
        assertEquals(vehiculoMock, sucursal.getVehiculos().get(0));
    }

    @Test
    void testGenerarEnvio() {
        // Crear un objeto Localidad para origen y destino
        Localidad origen = new Localidad("Luis Guillon", "Buenos Aires");
        Localidad destino = new Localidad("La Pampa", "La Pampa");

        // Agregar mocks a la sucursal
        sucursal.agregarPersona(personaMock);
        sucursal.agregarVehiculo(vehiculoMock);
        sucursal.agregarPaquete(paqueteMock);

        // Generar el envío
        sucursal.generarEnvio(personaMock, vehiculoMock, paqueteMock, origen, destino);
        
        // Verifica que el envío se ha creado y agregado correctamente
        assertEquals(1, sucursal.getEnvios().size());
        Envio envio = sucursal.getEnvios().get(0);
        
        // Verifica que el envío contiene los mocks esperados
        assertEquals(personaMock, envio.getTransportista());
        assertEquals(vehiculoMock, envio.getTransporte());
        assertEquals(paqueteMock, envio.getPaquete());
        assertEquals(origen, envio.getOrigen());
        assertEquals(destino, envio.getDestino());
    }
}
