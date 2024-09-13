package pruebas;

import java.time.LocalDate;

import modelo.Persona;

public class PersonaTests {

	public static void main(String[] args) {

		try {

			LocalDate fechaNacimiento = LocalDate.of(1990, 9, 25);

			Persona persona = new Persona("Nicolas", "Perez", "Masculino", "12345678", fechaNacimiento);
			System.out.println(persona);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
