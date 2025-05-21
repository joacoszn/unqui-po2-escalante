package ar.edu.unq.po2.tp6;

public class Banco {
    private final IServicioClientes servicioClientes;
    private final IServicioCreditos servicioCreditos;

    public Banco(IServicioClientes sc, IServicioCreditos sr) {
        this.servicioClientes = sc;
        this.servicioCreditos = sr;
    }

    public void agregarCliente(Cliente cliente) {
        servicioClientes.registrarCliente(cliente);
    }

    public void agregarSolicitudCredito(SolicitudCredito solicitud) {
        if (!servicioClientes.contieneCliente(solicitud.getCliente())) {
            throw new IllegalArgumentException("Cliente no registrado");
        }
        servicioCreditos.registrarSolicitud(solicitud);
    }

    public double getMontoTotalADesembolsar() {
        return servicioCreditos.calcularMontoTotalADesembolsar();
    }
    
    public int cantidadClientes() {
    	return(servicioClientes.cantidadClientes());
    }

	public int cantidadSolicitudes() {
		return (servicioCreditos.cantidadSolicitudes());
	}
	
    public void evaluar(SolicitudCredito solicitud) {
        if (!servicioClientes.contieneCliente(solicitud.getCliente())) {
            throw new IllegalArgumentException("Cliente no registrado");
        }
        servicioCreditos.evaluarSolicitud(solicitud);
    }

	public int cantidadDeSolicitudesAprobadas() {
		return servicioCreditos.cantidadDeSolicitudesAprobadas();
	}
}