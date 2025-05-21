package ar.edu.unq.po2.tp6;

import java.util.ArrayList;
import java.util.List;

public class ServicioCreditos implements IServicioCreditos {
    private final List<SolicitudCredito> solicitudes = new ArrayList<>();
    private double capitalDisponible = 1_000_000;

    @Override
    public void registrarSolicitud(SolicitudCredito solicitud) {
        solicitudes.add(solicitud);
    }

    @Override
    public double calcularMontoTotalADesembolsar() {
        return solicitudes.stream()
                .filter(SolicitudCredito::esAceptable)
                .mapToDouble(SolicitudCredito::getMonto)
                .sum();
    }
    

	@Override
	public int cantidadSolicitudes() {
		return solicitudes.size();
	}

    @Override
    public void evaluarSolicitud(SolicitudCredito solicitud) {
        if (this.esSolicitudDelBanco(solicitud) && solicitud.esAceptable() && capitalDisponible >= solicitud.getMonto()) {
            solicitud.procesarAceptacion(); // Marca la solicitud como aprobada
            capitalDisponible -= solicitud.getMonto(); // Desembolsa el monto
        }
    }

	private boolean esSolicitudDelBanco(SolicitudCredito solicitud) {
		return (solicitudes.contains(solicitud));
	}

	@Override
	public int cantidadDeSolicitudesAprobadas() {
		int solicitudesAprobadas = 0;
		for (SolicitudCredito solicitud : solicitudes) {
			if (solicitud.fueAprobada()){
				solicitudesAprobadas++;
			}	
		}
		return solicitudesAprobadas;
	}
}