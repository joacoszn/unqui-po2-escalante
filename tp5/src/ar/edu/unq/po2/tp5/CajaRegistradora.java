package ar.edu.unq.po2.tp5;

public class CajaRegistradora {
	double montoAPagar;
	
	public CajaRegistradora() {
		montoAPagar = 0.0;
	}
	
	public void registrarProducto(Producto producto) {
		montoAPagar += producto.getPrecio();
		producto.decrementarStock();
	}

	public double montoAPagar() {
		return montoAPagar;
	}
	
	public void registrarProductoEnCantidad(Producto producto, int cantidad) {
        montoAPagar += producto.getPrecio() * cantidad;
        producto.añadirStock(-cantidad);
    }
}
