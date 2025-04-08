package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaTest {
	private Persona persona;


	@BeforeEach
	public void setUp() throws Exception {
		persona = new Persona("Joaquin", LocalDate.parse("2002-04-21"));
	}

	@Test
	public void testNombreNull() {
		assertThrows(IllegalArgumentException.class, () -> {
	        persona = new Persona (null, LocalDate.parse("2002-04-21"));
	    });
		assertThrows(IllegalArgumentException.class, () -> {
	        persona = new Persona ("", LocalDate.parse("2002-04-21"));
	    });
	}
	
	@Test
	public void testEdad() {
		assertEquals(persona.edad(), 22);
	}
}
