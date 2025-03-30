package tp2uml;

import java.time.LocalDate;

public class ReciboDeHaberes {
	
	private Empleado empleado;
	protected String nombreEmpleado;
	protected String direccionEmpleado;
	protected LocalDate fechaDeEmision;
	protected Double sueldoBruto;
	protected Double sueldoNeto;
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
		
		return(empleado.generarDesgloce());		
		}
	

}



