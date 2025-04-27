package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoContratado extends Empleado {
	protected int numeroDeContrato;
	protected String medioDePago;

	public EmpleadoContratado(String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			Double sueldoBasico, int numeroDeContrato, String medioDePago) {
		super(nombre, dni, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.numeroDeContrato = numeroDeContrato;
		this.medioDePago = medioDePago;
	}

	public Double sueldoBruto() {
		return (sueldoBasico);
	}

	public Double retenciones() {
		return (this.retencionPorGastosAdm());
	}

	public Double retencionPorGastosAdm() {
		return (50.0);
	}

	public Double aportesJubilatorios() {
		return (0.0);
	}

	public String generarDesgloce() {
		StringBuilder sb = new StringBuilder();

		sb.append("=== Desglose de Conceptos ===\n");
		sb.append("Nombre trabajador: ").append(nombre).append("\n");
		sb.append("Tipo : Contratado").append("\n");
		sb.append("Sueldo basico: $").append(sueldoBasico).append("\n");
		sb.append("Sueldo bruto: $").append(this.sueldoBruto()).append("\n");
		;
		sb.append("Retenciones: ").append("\n");
		sb.append("Gastos administrativos contractuales: $").append(this.retencionPorGastosAdm()).append("\n");
		sb.append("Sueldo Neto: $").append(this.sueldoNeto()).append("\n");

		return sb.toString();
	}
}