package tp2uml;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
	protected String nombre;
	protected Integer dni;
	protected String direccion;
	protected String estadoCivil;
	protected LocalDate fechaNacimiento;
	protected Double sueldoBasico;
	
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
		return(this.sueldoBruto()-this.retenciones());
	}
	
	public Double descuentoPorObraSocial() {
		return (this.sueldoBruto() * 10 / 100);
	}
	
	public boolean esPlantaPermanente() {
		return false;
	}
		
}

class PlantaPermanente extends Empleado {
	protected int cantidadDeHijos;
	protected int antiguedad;
	
	public PlantaPermanente (String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento, Double sueldoBasico, int cantidadDeHijos, int antiguedad){
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad = antiguedad;
	}
	
	public Double sueldoBruto() {
		return((sueldoBasico + this.salarioFamiliar()));
	}
	
	public Double retenciones() {
		return (this.descuentoPorObraSocial()+ this.descuentoPorHijos()+ this.aportesJubilatorios());
	}
	
	public Double aportesJubilatorios() {
		return (this.sueldoBruto() * 15 / 100);
	}

	public Double asignacionPorConyuge() {
		if (estadoCivil == "Casado") {
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
		return(this.asignacionPorHijo()+this.asignacionPorConyuge());
	}
	
	@Override
	public String generarDesgloce() {
		StringBuilder sb = new StringBuilder();
	    
		sb.append("=== Desglose de Conceptos ===\n");
        sb.append("Nombre trabajador: ").append(nombre).append("\n");
        sb.append("Tipo : Planta Permanente").append("\n");
        sb.append("Sueldo basico: $").append(sueldoBasico).append("\n");
        sb.append("Salario familiar: $").append(this.salarioFamiliar()).append("\n");
        sb.append("Sueldo bruto: $").append(this.sueldoBruto()).append("\n");;
        sb.append("Retenciones: ").append("\n");
        sb.append("Obra social: $").append(this.descuentoPorObraSocial()).append("\n");
        sb.append("Aportes jubilatorios: $").append(this.aportesJubilatorios()).append("\n");
        sb.append("Descuento por hijos: $").append(this.descuentoPorHijos()).append("\n");
        sb.append("Sueldo Neto: $").append(this.sueldoNeto()).append("\n");     
        
        return sb.toString();
	}
}

class PlantaTemporaria extends Empleado {
	
	protected LocalDate fechaFinalizacionDeContrato;
	protected int horasExtras;
	
	public PlantaTemporaria (String nombre, Integer dni, String direccion, String estadoCivil, LocalDate fechaNacimiento, Double sueldoBasico){
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		fechaFinalizacionDeContrato = LocalDate.now();
		horasExtras = 0;
	}
	
	public Double sueldoBruto() {
		return (sueldoBasico + horasExtras * 40.0);
	}

	public Double retenciones() {
		return(this.descuentoPorObraSocial()+this.aportesJubilatorios()+this.descuentoPorEdad()+this.descuentoPorHorasExtras());
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
		return (horasExtras*5.0);
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
