package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectanguloTest {
	private Rectangulo rectanguloHorizontal;
	private Rectangulo rectanguloVertical;

	@BeforeEach
	public void setUp() throws Exception {
		Punto punto = new Punto(2,8);
		rectanguloHorizontal = new Rectangulo(punto,10,5);
		rectanguloVertical = new Rectangulo(punto,5,10);

	}

	@Test
	public void testArea() {
		assertEquals(rectanguloHorizontal.area(), 50);
	}
	
	@Test
	public void testPerimetro() {
		assertEquals(rectanguloHorizontal.perimetro(), 30);
	}
	
	@Test 
	public void testSaberSiEsHorizontal() {
		assertTrue(rectanguloHorizontal.esHorizontal());
		assertFalse(rectanguloVertical.esHorizontal());
	}
	
	@Test 
	public void testSaberSiEsVertical() {
		assertTrue(rectanguloVertical.esVertical());
		assertFalse(rectanguloHorizontal.esVertical());
	}
}
