package tp2uml;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
	protected String nombre;
	protected Integer dni;
	protected String direccion;
	protected String estadoCivil;
	protected LocalDate fechaNacimiento;
	protected int sueldoBasico;
	
	public int edad() {
		LocalDate fechaActual = LocalDate.now();
		return Period.between(fechaActual, fechaNacimiento).getYears();
	}
	
	public abstract int sueldoBruto();
	
	public abstract int retenciones();
	
	public abstract int aportesJubilatorios();
	
	public int valorHorasExtras() {
		return 0;
	}
	
	public int descuentoPorHijos() {
		return 0;
	}
	
	public int descuentoPorEdad() {
		return 0;
	}
	
	public int descuentoPorHorasExtras() {
		return 0;
	}
	
	public int salarioFamiliar() {
		return 0;
	}

	public int sueldoNeto() {
		return(this.sueldoBruto()-this.retenciones());
	}
	
	public int descuentoPorObraSocial() {
		return (this.sueldoBruto() * 10 / 100);
	}
	
	public boolean esPlantaPermanente() {
		return false;
	}
		
}

class PlantaPermanente extends Empleado {
	protected int cantidadDeHijos;
	protected int antiguedad;
	
	public PlantaPermanente (String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento, int sueldoBasico, int cantidadDeHijos, int antiguedad){
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad = antiguedad;
	}
	
	public int sueldoBruto() {
		return((sueldoBasico + this.salarioFamiliar()));
	}
	
	public int retenciones() {
		return (this.descuentoPorObraSocial()+ this.descuentoPorHijos()+ this.aportesJubilatorios());
	}
	
	public int aportesJubilatorios() {
		return (this.sueldoBruto() * 15 / 100);
	}

	public int asignacionPorConyuge() {
		if (estadoCivil == "Casado") {
			return (100);
		}
		return (0);
	}
	
	public int asignacionPorHijo() {
		return(cantidadDeHijos * 150);
	}
	
	@Override
		public int descuentoPorHijos() {
		return (this.cantidadDeHijos * 20);
	}
	
	@Override
	public boolean esPlantaPermanente() {
		return true;
	}
	
	@Override
	public int salarioFamiliar() {
		return(this.asignacionPorHijo()+this.asignacionPorConyuge());
	}
}

class PlantaTemporaria extends Empleado {
	
	protected LocalDate fechaFinalizacionDeContrato;
	protected int horasExtras;
	
	public PlantaTemporaria (String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento, int sueldoBasico){
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		fechaFinalizacionDeContrato = LocalDate.now();
		horasExtras = 0;
	}
	
	public int sueldoBruto() {
		return (sueldoBasico + horasExtras * 40);
	}
	
	public int retenciones() {
		return(this.descuentoPorObraSocial()+this.aportesJubilatorios()+this.descuentoPorEdad()+this.descuentoPorHorasExtras());
	}
	
	public int aportesJubilatorios() {
		return (this.sueldoBruto() * 10 / 100);
	}
	
	@Override
		public int valorHorasExtras() {
		return horasExtras * 40;
	}
	
	@Override
	public int descuentoPorEdad() {
		if (this.edad() > 50) {
			return (25);
		}
		return (0);
	}
	
	@Override
	public int descuentoPorHorasExtras() {
		return (horasExtras*5);
	}
}
