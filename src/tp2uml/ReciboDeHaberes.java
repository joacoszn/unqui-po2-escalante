package tp2uml;

import java.time.LocalDate;

public class ReciboDeHaberes {
	
	private Empleado empleado;
	protected String nombreEmpleado;
	protected String direccionEmpleado;
	protected LocalDate fechaDeEmision;
	protected int sueldoBruto;
	protected int sueldoNeto;
	protected String desgloceDeConceptos;
	
	public ReciboDeHaberes(Empleado empleado) {
		this.empleado = empleado;
		nombreEmpleado = empleado.nombre;
		direccionEmpleado = empleado.direccion;
		fechaDeEmision = LocalDate.now();
		sueldoBruto = empleado.sueldoBruto();
		sueldoNeto = empleado.sueldoNeto();
		desgloceDeConceptos = this.generarDesgloceDeConceptos();
	}
	
	public String generarDesgloceDeConceptos() {
		
		if (empleado.esPlantaPermanente()){
			return (desglosarConceptosPP());
			}
		return (desglosarConceptosPT());
				
			
		}
	
	public String desglosarConceptosPP() {
	
		StringBuilder sb = new StringBuilder();
	    
		sb.append("=== Desglose de Conceptos ===\n");
        sb.append("Trabajador: ").append(nombreEmpleado).append("\n");
        sb.append("Tipo : Planta Permanente").append("\n");
        sb.append("Sueldo basico: ").append(empleado.sueldoBasico).append("\n");
        sb.append("Salario familiar: ").append(empleado.salarioFamiliar()).append("\n");
        sb.append("Sueldo bruto: ").append(sueldoBruto).append("\n");;
        sb.append("Retenciones: ").append("\n");
        sb.append("Obra social: ").append(empleado.descuentoPorObraSocial()).append("\n");
        sb.append("Aportes jubilatorios: ").append(empleado.aportesJubilatorios()).append("\n");;
        sb.append("Descuento por hijos: ").append(empleado.descuentoPorHijos()).append("\n");
        sb.append("Sueldo Neto: ").append(empleado.sueldoNeto()).append("\n");     
        
        return sb.toString();	
	}	
		
		public String desglosarConceptosPT() {
			
			StringBuilder sb = new StringBuilder();
			
	        sb.append("=== Desglose de Conceptos ===\n");
	        sb.append("Trabajador: ").append(nombreEmpleado).append("\n");
	        sb.append("Tipo : Planta Temporaria").append("\n");
	        sb.append("Sueldo basico: ").append(empleado.sueldoBasico).append("\n");
	        sb.append("Horas extras: ").append(empleado.valorHorasExtras()).append("\n");
	        sb.append("Sueldo bruto: ").append(sueldoBruto).append("\n");
	        sb.append("Retenciones: ").append("\n");
	        sb.append("Obra social: ").append(empleado.descuentoPorObraSocial()).append("\n");
	        sb.append("Aportes jubilatorios: ").append(empleado.aportesJubilatorios()).append("\n");
	        sb.append("Descuento por edad: ").append(empleado.descuentoPorEdad()).append("\n");
	        sb.append("Descuento por horas extras: ").append(empleado.descuentoPorHorasExtras()).append("\n");
	        sb.append("Sueldo Neto: ").append(empleado.sueldoNeto()).append("\n");
	        
	        return sb.toString();
		}
}



