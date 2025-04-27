package ar.edu.unq.po2.tp5;

public abstract class Producto {
	private int stock;
	private String nombre;
	protected double precio;
	
	public Producto(String nombre, double precio) {
		this.stock = 0;
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
	
	public int getStock() {
		return stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void añadirStock(int cantidad) {
		int nuevoStock = this.getStock() + cantidad;
		this.stock = nuevoStock;
	}
	
	public void decrementarStock() {
		this.stock--;
	}
}
