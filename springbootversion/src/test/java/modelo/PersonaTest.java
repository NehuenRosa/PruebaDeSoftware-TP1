package modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {
    @Test
    void testCalcularEdad() throws Exception {
        Persona persona = new Persona("patricio","arango","masculino","29119499",LocalDate.of(1981,10,14));
        assertEquals(persona.calcularEdad(persona.getFechaNacimiento()), 42);

    }

    @Test
    void testEsMayorDeEdad() {

    }

    @Test
    void testGenerarCuit() {

    }
}
