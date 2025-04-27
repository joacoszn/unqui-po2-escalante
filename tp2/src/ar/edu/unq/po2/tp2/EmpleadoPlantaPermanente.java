package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoPlantaPermanente extends Empleado {
	protected int cantidadDeHijos;
	protected int antiguedad;

	public EmpleadoPlantaPermanente(String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			Double sueldoBasico, int cantidadDeHijos, int antiguedad) {
		super(nombre, dni, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad = antiguedad;
	}

	public Double sueldoBruto() {
		return ((sueldoBasico + this.salarioFamiliar()));
	}

	public Double retenciones() {
		return (this.descuentoPorObraSocial() + this.descuentoPorHijos() + this.aportesJubilatorios());
	}

	public Double aportesJubilatorios() {
		return (this.sueldoBruto() * 15 / 100);
	}

	public Double asignacionPorConyuge() {
		if (this.estadoCivil.equals("Casado")) {
			return (100.00);
		}
		return (0.0);
	}

	public Double asignacionPorHijo() {
		return (double) (cantidadDeHijos * 150);
	}

	@Override
	public Double descuentoPorHijos() {
		return (double) (this.cantidadDeHijos * 20);
	}

	@Override
	public boolean esPlantaPermanente() {
		return true;
	}

	@Override
	public Double salarioFamiliar() {
		return (this.asignacionPorHijo() + this.asignacionPorConyuge());
	}

	@Override
	public String generarDesgloce() {
		StringBuilder sb = new StringBuilder();

		sb.append("=== Desglose de Conceptos ===\n");
		sb.append("Nombre trabajador: ").append(nombre).append("\n");
		sb.append("Tipo : Planta Permanente").append("\n");
		sb.append("Sueldo basico: $").append(sueldoBasico).append("\n");
		sb.append("Salario familiar: $").append(this.salarioFamiliar()).append("\n");
		sb.append("Sueldo bruto: $").append(this.sueldoBruto()).append("\n");
		;
		sb.append("Retenciones: ").append("\n");
		sb.append("Obra social: $").append(this.descuentoPorObraSocial()).append("\n");
		sb.append("Aportes jubilatorios: $").append(this.aportesJubilatorios()).append("\n");
		sb.append("Descuento por hijos: $").append(this.descuentoPorHijos()).append("\n");
		sb.append("Sueldo Neto: $").append(this.sueldoNeto()).append("\n");

		return sb.toString();
	}
}
