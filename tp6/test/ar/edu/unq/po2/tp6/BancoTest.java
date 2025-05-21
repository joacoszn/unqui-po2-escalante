package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {
	private Banco unBanco;
	private Cliente unCliente;
	private SolicitudCredito unaSolicitudDeCreditoPersonal;
	
	@BeforeEach
	public void setUp() {
		ServicioClientes sc = new ServicioClientes();
		ServicioCreditos scr = new ServicioCreditos();
		unBanco = new Banco(sc, scr);
		unCliente = new Cliente("Joaquin", "Escalante", "Einstein 4537", 23, 30000.00);
		unaSolicitudDeCreditoPersonal = new CreditoPersonal(unCliente, 100000.00, 3);

	}
	
	@Test
	void testUnBancoPuedeAgregarUnCliente() {
		unBanco.agregarCliente(unCliente);
		assertEquals(1, unBanco.cantidadClientes());
	}
	
	@Test
	void testUnBancoPuedeAgregarUnaSolicitudDeCreditoDeUnCliente() {
		unBanco.agregarCliente(unCliente);
		unBanco.agregarSolicitudCredito(unaSolicitudDeCreditoPersonal);
		assertEquals(1, unBanco.cantidadSolicitudes());
	}

	@Test
	void testUnBancoNoPuedeTomarSolicitudesDeNoClientes() {
		assertThrows(
			IllegalArgumentException.class,
		    () -> unBanco.agregarSolicitudCredito(unaSolicitudDeCreditoPersonal),
		    "Debe fallar si el cliente no está registrado"
		    );
		assertEquals(0, unBanco.cantidadSolicitudes());
	}
	
	@Test
	void testUnBancoPuedeSaberCuantosClientesTiene() {
		assertEquals(0, unBanco.cantidadClientes());
		unBanco.agregarCliente(unCliente);
		assertEquals(1, unBanco.cantidadClientes());
	}
	
	@Test
	void testUnBancoPuedeSaberCuantasSolicitudesTiene() {
		assertEquals(0, unBanco.cantidadSolicitudes());
		unBanco.agregarCliente(unCliente);
		unBanco.agregarSolicitudCredito(unaSolicitudDeCreditoPersonal);
		assertEquals(1, unBanco.cantidadClientes());
	}
	
	@Test
	void testUnBancoPuedeSaberCuantasSolicitudesAprobadasTiene() {
		assertEquals(0, unBanco.cantidadDeSolicitudesAprobadas());
		unBanco.agregarCliente(unCliente);
		SolicitudCredito unaSolicitudAprobable = new CreditoPersonal(unCliente, 10000, 6);
		unBanco.agregarSolicitudCredito(unaSolicitudAprobable);
		unBanco.evaluar(unaSolicitudAprobable);
		assertEquals(1, unBanco.cantidadDeSolicitudesAprobadas());
	}

	@Test 
	void unBancoPuedeEvaluarUnaSolicitudDeCredito() {
		unBanco.agregarCliente(unCliente);
	
		SolicitudCredito unaSolicitudRechazable = new CreditoPersonal(unCliente, 150000.00, 3);
		unBanco.agregarSolicitudCredito(unaSolicitudRechazable);
		unBanco.evaluar(unaSolicitudRechazable);
		assertEquals(0, unBanco.cantidadDeSolicitudesAprobadas());
	
		SolicitudCredito unaSolicitudAprobable = new CreditoPersonal(unCliente, 10000.00, 6);
		unBanco.agregarSolicitudCredito(unaSolicitudAprobable);
		unBanco.evaluar(unaSolicitudAprobable);
		assertEquals(1, unBanco.cantidadDeSolicitudesAprobadas());
	}
	
	@Test
	void unBancoPuedeSaberElMontoTotalADesembolsar() {
		SolicitudCredito unaSolicitudAprobable = new CreditoPersonal(unCliente, 10000, 6);
		assertEquals(0.0, unBanco.getMontoTotalADesembolsar());
		unBanco.agregarCliente(unCliente);
		unBanco.agregarSolicitudCredito(unaSolicitudAprobable);
		assertEquals(10000.00, unBanco.getMontoTotalADesembolsar());
	}
}
