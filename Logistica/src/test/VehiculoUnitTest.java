package test;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Vehiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehiculoUnitTest {

    Vehiculo vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo("Tesla", "Model S", 2020, 2021, 50000);
    }

    @Test
    void testEsElectricoTrue() {
        // When
        boolean result = vehiculo.esElectrico(2021);

        // Then
        assertTrue(result, "El vehículo debería ser eléctrico si es posterior a 2020");
    }

    @Test
    void testEsElectricoFalse() {
        // When
        boolean result = vehiculo.esElectrico(2019);

        // Then
        assertFalse(result, "El vehículo no debería ser eléctrico si es anterior a 2020");
    }

    @Test
    void testEsGasoleroTrue() {
        // When
        boolean result = vehiculo.esGasolero(2005);

        // Then
        assertTrue(result, "El vehículo debería ser gasolero si es anterior a 2008 y no es eléctrico");
    }

    @Test
    void testEsGasoleroFalse() {
        // When
        boolean result = vehiculo.esGasolero(2022);

        // Then
        assertFalse(result, "El vehículo no debería ser gasolero si es eléctrico o posterior a 2008");
    }

    @Test
    void testCotizarVehiculoReciente() {
        // Given
        float expectedCotizacion = vehiculo.cotizar(2020, 2021, 50000);

        // When
        float result = vehiculo.cotizar(2020, 2021, 50000);

        // Then
        assertEquals(expectedCotizacion, result, 0.01, "El precio debería ser correcto para vehículos recientes");
    }

    @Test
    void testCotizarVehiculoAntiguo() {
        // Given
        Vehiculo vehiculoAntiguo = new Vehiculo("Ford", "Fiesta", 2000, 2005, 100000);
        float expectedCotizacion = vehiculoAntiguo.cotizar(2000, 2005, 100000);

        // When
        float result = vehiculoAntiguo.cotizar(2000, 2005, 100000);

        // Then
        assertEquals(expectedCotizacion, result, 0.01, "El precio debería ser correcto para vehículos antiguos");
    }

    @Test
    void testGeneratePatente() {
        // When
        String patente = vehiculo.generatePatente(3, 3);

        // Then
        assertNotNull(patente, "La patente generada no debería ser nula");
        assertTrue(patente.matches("[A-Z]{3}-\\d{3}"), "La patente generada debería seguir el formato 'LLL-NNN'");
    }

    @Test
    void testToString() {
        // When
        String result = vehiculo.toString();

        // Then
        assertTrue(result.contains("Tesla"), "El toString debería incluir la marca 'Tesla'");
        assertTrue(result.contains("Model S"), "El toString debería incluir el modelo 'Model S'");
    }
}
