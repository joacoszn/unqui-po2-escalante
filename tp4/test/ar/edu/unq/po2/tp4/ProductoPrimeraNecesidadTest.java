package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoPrimeraNecesidadTest {

    private ProductoPrimeraNecesidad leche;
    
    @BeforeEach
    public void setUp() {
        leche = new ProductoPrimeraNecesidad("Leche", 100d, 15);
    }
    
    @Test
    public void testCalcularPrecio() {
        assertEquals(85.0, leche.getPrecio());
    }
}
