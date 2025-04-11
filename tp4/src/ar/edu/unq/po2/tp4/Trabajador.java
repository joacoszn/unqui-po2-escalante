package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	String nombre;
	List <Ingreso> ingresos;

	public Trabajador(String nombre) {
		this.nombre = nombre;
		ingresos = new ArrayList<>();
	}
	
	public void agregarIngreso(Ingreso ingreso) {
		ingresos.add(ingreso);
	}
	
	public double getSueldoImponible() {
		Double acumulador = 0.0;
		for (Ingreso ingreso : ingresos) {
			if (!ingreso.esIngresoPorHoraExtra()){
				acumulador += ingreso.monto();
			}
		}
		return acumulador;
	}

	public Double getTotalPercibido() {
		Double acumulador = 0.0;
			for (Ingreso ingreso : ingresos) {
				acumulador += ingreso.monto();
			}
		return acumulador;
	}

	public Double getImpuestoAPagar() {
		
		return((this.getSueldoImponible()*2)/100);
	}
}
