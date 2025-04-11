package ar.edu.unq.po2.tp4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrabajadorTest {
	
	private Trabajador trabajador;
	private Ingreso ingresoComun;
	private Ingreso ingresoPorHorasExtras;
	
	@BeforeEach
	public void setUp() {
		trabajador = new Trabajador("Joaquin");
		ingresoComun = new Ingreso("Abril", "Sueldo mensual", 500000.0);
		ingresoPorHorasExtras = new IngresoPorHorasExtras("Abril", 40000.0, 10);
	}
	
	@Test
	public void testSueldoImponible() {
		assertEquals(0, trabajador.getSueldoImponible());
		trabajador.agregarIngreso(ingresoComun);
		trabajador.agregarIngreso(ingresoPorHorasExtras);
		assertEquals(500000.0, trabajador.getSueldoImponible());
	}
	
	@Test
	public void testMontoTotalPercibido() {
		assertEquals(0, trabajador.getTotalPercibido());
		trabajador.agregarIngreso(ingresoComun);
		trabajador.agregarIngreso(ingresoComun);
		trabajador.agregarIngreso(ingresoPorHorasExtras);
		assertEquals(1040000.0, trabajador.getTotalPercibido());
	}
	
	@Test
	public void testImpuestoAPagar() {
		assertEquals(0, trabajador.getImpuestoAPagar());
		trabajador.agregarIngreso(ingresoComun);
		trabajador.agregarIngreso(ingresoComun);
		trabajador.agregarIngreso(ingresoPorHorasExtras);
		assertEquals(20000.0, trabajador.getImpuestoAPagar());
	}
}

