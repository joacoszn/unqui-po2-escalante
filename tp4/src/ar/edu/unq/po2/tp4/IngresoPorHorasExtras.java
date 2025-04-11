package ar.edu.unq.po2.tp4;

public class IngresoPorHorasExtras extends Ingreso {
	final int horasExtras;

	public IngresoPorHorasExtras(String mes, Double monto, int horasExtras) {
		super(mes,"Horas extras.",monto);
		this.horasExtras = horasExtras;
	}
	
	@Override
	public boolean esIngresoPorHoraExtra() {
		return true;
	}

}
