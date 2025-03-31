package tp2uml;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.*;
import java.util.Objects;

public class Empresa {
	private String nombre;
	private int cuit;
	private ArrayList <Empleado> empleados;
	private HashMap<Integer, ArrayList<ReciboDeHaberes>> recibosDeHaberes;

	public Empresa(String nombre, int cuit) {
	    this.nombre = Objects.requireNonNull(nombre, "Nombre no puede ser nulo");
	    if (cuit <= 0) throw new IllegalArgumentException("CUIT no válido");
	    this.cuit = cuit;
	    this.empleados = new ArrayList<>();
	    this.recibosDeHaberes = new HashMap<>();
	    System.out.println("La empresa "+nombre+" ha sido creada con éxito.");
	}
	
	public void registrarEmpleado(Empleado empleado) {
		if (empleado == null) {
	        throw new IllegalArgumentException("Empleado no puede ser nulo.");
	    }
		empleados.add(empleado);
		recibosDeHaberes.put(empleado.dni, new ArrayList<ReciboDeHaberes>());
	    System.out.println("Se ha registrado a "+empleado.nombre+" en la empresa "+this.nombre+" con éxito.");
		}
	
	public Double totalSueldosNetos() {
	    Double sueldosNetos = 0.0;
	    for (Empleado empleado : empleados) {
	        sueldosNetos += empleado.sueldoNeto();
	    }
	    System.out.println("El monto total de los sueldos netos es de $"+sueldosNetos+".");
	    return sueldosNetos;
	}
	
	public Double totalSueldosBrutos() {
		Double sueldosBrutos = 0.0;
	    for (Empleado empleado : empleados) {
	        sueldosBrutos += empleado.sueldoBruto();
	    }
	    System.out.println("El monto total de los sueldos brutos es de $"+sueldosBrutos+".");
	    return sueldosBrutos;
		
	}
	
	public Double totalRetenciones() {
		Double totalRetenciones = 0.0;
	    for (Empleado empleado : empleados) {
	        totalRetenciones += empleado.retenciones();
	    }
	    System.out.println("El monto total de todas las retenciones es de $"+totalRetenciones+".");
	    return totalRetenciones;
		
	}
	
	public void liquidarSueldos() {
		for (Empleado empleado : empleados) {
			this.procesarLiquidacionDeSueldoDe(empleado);
		}
		System.out.println("Todos los sueldos han sido liquidados con éxito.");
	}
	
	public void procesarLiquidacionDeSueldoDe(Empleado empleado) {
		ArrayList <ReciboDeHaberes> recibos = this.recibosDeHaberesDe(empleado);
		recibos.add(new ReciboDeHaberes(empleado));
		recibosDeHaberes.put((empleado.dni),recibos);
		System.out.println("El sueldo del trabajador "+empleado.nombre+" ha sido liquidado con éxito.");
		System.out.println((this.ultimoReciboDe(empleado)).generarDesgloceDeConceptos());
	}
	
	public ArrayList <ReciboDeHaberes> recibosDeHaberesDe (Empleado empleado){
		return(recibosDeHaberes.get(empleado.dni));
	}
	
	public ReciboDeHaberes ultimoReciboDe(Empleado empleado) {
		return(recibosDeHaberesDe(empleado).get(0));
	}
	

	public static void main(String[] args) {
	}
	
}

	

	


