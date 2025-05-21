package ar.edu.unq.po2.tp6;

public interface SolicitudCredito {
    Cliente getCliente();
    double getMonto();
    int getPlazo();
    double getCuotaMensual();
    boolean esAceptable();
    boolean fueAprobada();
    void procesarAceptacion();
}

