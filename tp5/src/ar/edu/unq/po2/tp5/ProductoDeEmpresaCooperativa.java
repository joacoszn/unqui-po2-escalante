package ar.edu.unq.po2.tp5;

public class ProductoDeEmpresaCooperativa extends Producto{

	public ProductoDeEmpresaCooperativa(String nombre, double precio) {
		super(nombre, precio);
	}
	
	public double getPrecio() {
		double descuento = this.precio / 10;
		return this.precio-descuento;
	}
}
