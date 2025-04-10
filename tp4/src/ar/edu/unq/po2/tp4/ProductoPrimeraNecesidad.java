package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto {
    private double porcentajeDescuento;
    
    public ProductoPrimeraNecesidad(String nombre, Double precio, double porcentajeDescuento) {
        super(nombre, precio);
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public Double getPrecio() {
        return precio * (1 - (porcentajeDescuento / 100));
    }
}
