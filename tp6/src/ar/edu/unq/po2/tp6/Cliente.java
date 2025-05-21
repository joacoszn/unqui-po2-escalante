package ar.edu.unq.po2.tp6;

public class Cliente {
    private final String nombre;
    private final String apellido;
    private final String direccion;
    private final int edad;
    private final double sueldoNetoMensual;

    public Cliente(String nombre, String apellido, String direccion, int edad, double sueldoNetoMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.sueldoNetoMensual = sueldoNetoMensual;
    }

    // --- Getters ---
    public double getSueldoNetoMensual() {
        return sueldoNetoMensual;
    }

    public double getSueldoNetoAnual() {
        return sueldoNetoMensual * 12;
    }

    public int getEdadEnMeses(int meses) {
        return edad + (meses / 12);
    }

	public void solicitarCreditoPersonalPor(Banco unBanco, double montoASolicitar, int plazoAPagar) {
		SolicitudCredito creditoPersonal = new CreditoPersonal (this, montoASolicitar, plazoAPagar);
		unBanco.agregarSolicitudCredito(creditoPersonal);	
	}
	
	public void solicitarCreditoHipotecarioPor(Banco unBanco, double montoASolicitar, int plazoAPagar, Propiedad propiedadGarantia) {
		SolicitudCredito creditoHipotecario = new CreditoHipotecario (this, montoASolicitar, plazoAPagar, propiedadGarantia);
		unBanco.agregarSolicitudCredito(creditoHipotecario);	
	}
}