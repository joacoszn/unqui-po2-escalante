package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
	protected String nombre;
	protected Integer dni;
	protected String direccion;
	protected String estadoCivil;
	protected LocalDate fechaNacimiento;
	protected Double sueldoBasico;
	
	public Empleado(String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			Double sueldoBasico) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
	}

	public abstract Double sueldoBruto();

	public abstract Double retenciones();

	public abstract Double aportesJubilatorios();

	public abstract String generarDesgloce();

	public int edad() {
		LocalDate fechaActual = LocalDate.now();
		return Period.between(fechaNacimiento, fechaActual).getYears();
	}

	public Double valorHorasExtras() {
		return 0.0;
	}

	public Double descuentoPorHijos() {
		return 0.0;
	}

	public Double descuentoPorEdad() {
		return 0.0;
	}

	public Double descuentoPorHorasExtras() {
		return 0.0;
	}

	public Double salarioFamiliar() {
		return 0.0;
	}

	public Double sueldoNeto() {
		return (this.sueldoBruto() - this.retenciones());
	}

	public Double descuentoPorObraSocial() {
		return (this.sueldoBruto() * 10 / 100);
	}

	public boolean esPlantaPermanente() {
		return false;
	}

}


