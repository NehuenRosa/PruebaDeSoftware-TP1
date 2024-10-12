package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class PersonaTest {

    private Persona persona;

    @BeforeEach
    public void setUp() throws Exception {
        LocalDate fechaNacimiento = LocalDate.of(1990, 5, 15);
        persona = new Persona("Juan", "Perez", "Masculino", "12345678", fechaNacimiento);
    }

    @Test
    public void testGenerarCuitMasculino() throws Exception {
        String cuit = persona.generarCuit("12345678", "Masculino");
        assertEquals("22-12345678-3", cuit);
    }

    @Test
    public void testGenerarCuitFemenino() throws Exception {
        String cuit = persona.generarCuit("12345678", "Femenino");
        assertEquals("20-12345678-8", cuit);
    }

    @Test
    public void testGenerarCuitDefault() throws Exception {
        String cuit = persona.generarCuit("12345678", "Otro");
        assertEquals("18-12345678-0", cuit);
    }

    @Test
    public void testGenerarCuitDniInvalido() {
        Exception exception = assertThrows(Exception.class, () -> {
            persona.generarCuit("1234", "Masculino");
        });
        assertEquals("El documento ingresado no es valido", exception.getMessage());
    }

    @Test
    public void testCalcularEdad() {
        LocalDate fechaNacimiento = LocalDate.of(1990, 5, 15);
        int edad = persona.calcularEdad(fechaNacimiento);
        assertEquals(34, edad); // Ajusta este valor según el año actual.
    }

    @Test
    public void testEsMayorDeEdad() {
        LocalDate fechaNacimiento = LocalDate.of(1990, 5, 15);
        assertTrue(persona.esMayorDeEdad(fechaNacimiento));
    }

    @Test
    public void testEsMenorDeEdad() throws Exception {
        LocalDate fechaNacimiento = LocalDate.of(2010, 1, 1);
        Persona personaMenor = new Persona("Pedro", "Gomez", "Masculino", "87654321", fechaNacimiento);
        assertFalse(personaMenor.esMayorDeEdad(fechaNacimiento));
    }

    @Test
    public void testToString() {
        String expected = "Persona [nombre=Juan, apellido=Perez, genero=Masculino, edad=34, dni=12345678, cuit=22-12345678-3]";
        assertEquals(expected, persona.toString()); // Ajusta la edad según el año actual.
    }
}
