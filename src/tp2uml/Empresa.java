package tp2uml;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.time.*;

public class Empresa {
	private String nombre;
	private int cuit;
	private List <Empleado> empleados;
	private Map<Integer, ArrayList<ReciboDeHaberes>> recibosDeHaberes;
	
	public Empresa() {
		nombre = null;
		cuit = 0;
		empleados = new ArrayList<>();
		recibosDeHaberes = new HashMap<>();
	}
	
	public int totalSueldosNetos() {
	    int sueldosNetos = 0;
	    for (Empleado empleado : empleados) {
	        sueldosNetos += empleado.sueldoNeto();
	    }
	    return sueldosNetos;
	}
	
	public int totalSueldosBrutos() {
		int sueldosBrutos = 0;
	    for (Empleado empleado : empleados) {
	        sueldosBrutos += empleado.sueldoBruto();
	    }
	    return sueldosBrutos;
		
	}
	
	public int totalRetenciones() {
		int totalRetenciones = 0;
	    for (Empleado empleado : empleados) {
	        totalRetenciones += empleado.retenciones();
	    }
	    return totalRetenciones;
		
	}
	
	public void liquidarSueldos() {
		for (Empleado empleado : empleados) {
			this.procesarLiquidacionDeSueldoDe(empleado);
		}
	}
	
	public void procesarLiquidacionDeSueldoDe(Empleado empleado) {
		ArrayList <ReciboDeHaberes> recibos = this.recibosDeHaberesDe(empleado);
		recibos.add(new ReciboDeHaberes(empleado));
		recibosDeHaberes.put((empleado.dni),recibos);
	}
	
	public ArrayList <ReciboDeHaberes> recibosDeHaberesDe (Empleado empleado){
		return(recibosDeHaberes.get(empleado.dni));
	}
	

	public static void main(String[] args) {
		PlantaPermanente joaquin = new PlantaPermanente ("Joaquin", 44170192,"Einstein 4537","Soltero",LocalDate.parse("2002-04-21"),800000,2,10);
		PlantaTemporaria colo = new PlantaTemporaria ("Colo", 45695393, "Husares 3855", "Soltero", LocalDate.parse("2002-03-24"), 400000);
		Empresa miEmpresa = new Empresa();
		miEmpresa.empleados.add(joaquin);
		miEmpresa.empleados.add(colo);
		ReciboDeHaberes recibo = new ReciboDeHaberes(joaquin);
		ReciboDeHaberes recibo2 = new ReciboDeHaberes(colo);
		System.out.println(recibo.generarDesgloceDeConceptos());
		System.out.println(recibo2.generarDesgloceDeConceptos());
	}

}

	

	


