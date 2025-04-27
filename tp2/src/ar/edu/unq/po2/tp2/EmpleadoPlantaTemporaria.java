package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoPlantaTemporaria extends Empleado {

	protected LocalDate fechaFinalizacionDeContrato;
	protected int horasExtras;

	public EmpleadoPlantaTemporaria(String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			Double sueldoBasico) {
		super(nombre, dni, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		fechaFinalizacionDeContrato = LocalDate.now();
		horasExtras = 0;
	}

	public Double sueldoBruto() {
		return (sueldoBasico + horasExtras * 40.0);
	}

	public Double retenciones() {
		return (this.descuentoPorObraSocial() + this.aportesJubilatorios() + this.descuentoPorEdad()
				+ this.descuentoPorHorasExtras());
	}

	public Double aportesJubilatorios() {
		return (this.sueldoBruto() * 10. / 100);
	}

	@Override
	public Double valorHorasExtras() {
		return horasExtras * 40.0;
	}

	@Override
	public Double descuentoPorEdad() {
		if (this.edad() > 50) {
			return (25.00);
		}
		return (0.0);
	}

	@Override
	public Double descuentoPorHorasExtras() {
		return (horasExtras * 5.0);
	}

	@Override
	public String generarDesgloce() {
		StringBuilder sb = new StringBuilder();

		sb.append("=== Desglose de Conceptos ===\n");
		sb.append("Trabajador: ").append(nombre).append("\n");
		sb.append("Tipo : Planta Temporaria").append("\n");
		sb.append("Sueldo basico: $").append(sueldoBasico).append("\n");
		sb.append("Horas extras: $").append(this.valorHorasExtras()).append("\n");
		sb.append("Sueldo bruto: $").append(this.sueldoBruto()).append("\n");
		sb.append("Retenciones: ").append("\n");
		sb.append("Obra social: $").append(this.descuentoPorObraSocial()).append("\n");
		sb.append("Aportes jubilatorios: $").append(this.aportesJubilatorios()).append("\n");
		sb.append("Descuento por edad: $").append(this.descuentoPorEdad()).append("\n");
		sb.append("Descuento por horas extras: $").append(this.descuentoPorHorasExtras()).append("\n");
		sb.append("Sueldo Neto: $").append(this.sueldoNeto()).append("\n");

		return sb.toString();
	}
}
