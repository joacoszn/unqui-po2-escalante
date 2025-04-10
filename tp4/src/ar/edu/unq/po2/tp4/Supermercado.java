package ar.edu.unq.po2.tp4;

import java.util.List;
import java.util.ArrayList;

public class Supermercado {
	String nombre;
	String direccion;
	List <Producto> productos;
	
	public Supermercado(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		productos = new ArrayList<>();
	}
	
	public String nombre() {
		return nombre;
	}
	
	public String direccion() {
		return direccion;
	}
	
	public int getCantidadDeProductos() {
		return (productos.size());
	}
	
	public Double getPrecioTotal() {
		Double acumulador = 0.0;
		for (Producto p: productos) {
			acumulador += p.getPrecio();
		}
		return acumulador;
	}
	
	public void agregarProducto(Producto p) {
		productos.add(p);
	}
}
