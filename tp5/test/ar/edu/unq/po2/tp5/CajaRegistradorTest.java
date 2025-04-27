package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaRegistradorTest {
	CajaRegistradora cajaRegistradora;
	Producto productoDeCooperativa;
	Producto productoDeEmpresa;
	
	@BeforeEach
	void setUp() {
		cajaRegistradora = new CajaRegistradora();
		productoDeCooperativa = new ProductoDeEmpresaCooperativa("Manaos", 1500.00);
		productoDeEmpresa = new ProductoDeEmpresaTradicional("Coca Cola", 4000.00);
	}

	@Test
	void testProductoCooperativa() {
		cajaRegistradora.registrarProducto(productoDeCooperativa);
		assertEquals(cajaRegistradora.montoAPagar(), 1350.00);
	}
	
	@Test
	void testProductoDeEmpresa() {
		cajaRegistradora.registrarProducto(productoDeEmpresa);
		assertEquals(cajaRegistradora.montoAPagar(), 4000.00);
	}
	
	@Test 
	void testProductosVarios() {
		Double montoEsperado = (productoDeEmpresa.getPrecio()*2) + (productoDeCooperativa.getPrecio()*2);
		cajaRegistradora.registrarProductoEnCantidad(productoDeEmpresa, 2);
		cajaRegistradora.registrarProductoEnCantidad(productoDeCooperativa, 2);
		assertEquals(cajaRegistradora.montoAPagar(), montoEsperado);
	}
}
