package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipoDeTrabajoTest {
	private EquipoDeTrabajo equipo;


	@BeforeEach
	public void setUp() throws Exception {
		equipo = new EquipoDeTrabajo("Equipo 10");
	}

	@Test
	public void testNombreNull() {
		assertThrows(IllegalArgumentException.class, () -> {
	        equipo = new EquipoDeTrabajo (null);
	    });
		assertThrows(IllegalArgumentException.class, () -> {
	        equipo = new EquipoDeTrabajo ("");
	    });
	}
	
	@Test
	public void testAgregarIntegrante() {
		equipo.agregarIntegrante(new Persona("Joaquin", LocalDate.parse("2002-04-21")));
		assertEquals(equipo.cantidadDeIntegrantes(), 1); 
	}
	
	@Test
	public void testPromedioEdad() {
		equipo.agregarIntegrante(new Persona("Joaquin", LocalDate.parse("2002-04-21")));
		equipo.agregarIntegrante(new Persona("Osvaldo", LocalDate.parse("2002-04-21")));
		assertEquals(equipo.promedioEdad(), 22);
	}
}