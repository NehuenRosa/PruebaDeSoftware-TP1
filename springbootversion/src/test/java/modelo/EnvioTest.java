package modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EnvioTest {

   
    @Mock
    private Paquete paqueteMock;
    
    @Mock
    private Localidad origenMock;
    
    @Mock
    private Localidad destinoMock;
    
    @Mock
    private Persona transportistaMock;
    
    //@Mock
    private Vehiculo transporteMock;

    
    @InjectMocks
    private Envio envio;
    
    @BeforeEach
    void setUp() throws Exception {
        
        MockitoAnnotations.openMocks(this);// Inicializo los mocks
        
        // Configurar el mock de paquete para devolver un peso específico
        when(paqueteMock.getPeso()).thenReturn(10.0f);
        
        // Configurar los mocks de origen y destino para simular diferentes provincias
        when(origenMock.getProvincia()).thenReturn("Buenos Aires");
        when(destinoMock.getProvincia()).thenReturn("Córdoba");
        
        // Crear una instancia de Envio con los mocks
        envio = new Envio(paqueteMock, origenMock, destinoMock, transportistaMock,transporteMock);
    }

    @Test
    void testEsEnvioInternacionalReturnTrue() {
        
        assertTrue(envio.esEnvioInternacional());
    }

    @Test
    void testEsEnvioInternacionalReturnFalse() {
        when(destinoMock.getProvincia()).thenReturn("Buenos Aires");
        
        assertFalse(envio.esEnvioInternacional());
    }

    @Test
    void testCalcularCostoEnvio() {
        
        double costoEsperado = 10 + (50 * 0.5) + (10 * 2); 
        
        assertEquals(costoEsperado, envio.calcularCostoEnvio(), 0.01);
    }

    @Test
    void testAgregarVehiculoAlEnvioReturnOk() throws Exception {
    	
        // Creo un vehiculoMock para agregar luego
        Vehiculo nuevoVehiculoMock = mock(Vehiculo.class);
        
        envio.agregarVehiculoAlEnvio(nuevoVehiculoMock);
        
    }

    @Test
    void testAgregarVehiculoAlEnvio_VehiculoExistente(){
    	
    	
    	Vehiculo primerVehiculoMock = mock(Vehiculo.class);
    	try {
			envio.agregarVehiculoAlEnvio(primerVehiculoMock);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
        Vehiculo nuevoVehiculoMock = mock(Vehiculo.class); 

       
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            envio.agregarVehiculoAlEnvio(nuevoVehiculoMock);
        });
        
        
        assertEquals("Ya existe un vehículo asignado para este envío.", exception.getMessage());
    }


    @Test
    void testAgregarVehiculoAlEnvio_VehiculoNulo() {
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            envio.agregarVehiculoAlEnvio(null);
        });
        
        assertEquals("El vehículo no puede ser nulo.", exception.getMessage());
    }
}
