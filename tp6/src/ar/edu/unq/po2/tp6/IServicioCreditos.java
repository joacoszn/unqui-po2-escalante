package ar.edu.unq.po2.tp6;

public interface IServicioCreditos {
	void registrarSolicitud(SolicitudCredito solicitud);
    void evaluarSolicitud(SolicitudCredito solicitud);
    double calcularMontoTotalADesembolsar();
	int cantidadSolicitudes();
    int cantidadDeSolicitudesAprobadas();
}
