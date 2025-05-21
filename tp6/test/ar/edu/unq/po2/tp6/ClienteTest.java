package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	private Cliente unCliente;
	private Banco unBanco;
	
	@BeforeEach
	public void setUp() {
		ServicioClientes sc = new ServicioClientes();
		ServicioCreditos scr = new ServicioCreditos();
		unCliente = new Cliente("Joaquin", "Escalante", "Einstein 4537", 23, 100000.00);
		unBanco = new Banco(sc, scr);
	}

	@Test
	void testUnClientePuedeSaberSuSueldoNetoAnual() {
		assertEquals(1200000.00, unCliente.getSueldoNetoAnual());
	}
	
	@Test
	void unClientePuedeSolicitarUnCreditoAlBanco() {
		unBanco.agregarCliente(unCliente);
		unCliente.solicitarCreditoPersonalPor(unBanco, 50.000, 6);
		assertEquals(1, unBanco.cantidadSolicitudes());
	}
}
