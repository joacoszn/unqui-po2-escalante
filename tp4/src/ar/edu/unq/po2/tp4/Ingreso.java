package ar.edu.unq.po2.tp4;

public class Ingreso {
	final String mes;
	final String concepto;
	final Double monto;
	
	public Ingreso(String mes, String concepto, Double monto) {
		this.mes = mes;
		this.concepto = concepto;
		this.monto = monto;
	}

	public boolean esIngresoPorHoraExtra() {
		return false;
	}

	public Double monto() {
		return monto;
	}
}
