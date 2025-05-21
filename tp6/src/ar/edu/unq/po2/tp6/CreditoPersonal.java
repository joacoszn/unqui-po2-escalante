package ar.edu.unq.po2.tp6;

public class CreditoPersonal implements SolicitudCredito {
    private final Cliente cliente;
    private final double monto;
    private final int plazo;
    private boolean aprobada = false;

    public CreditoPersonal(Cliente cliente, double monto, int plazo) {
        this.cliente = cliente;
        this.monto = monto;
        this.plazo = plazo;
    }

    @Override
    public boolean esAceptable() {
        return cliente.getSueldoNetoAnual() >= 15000 
               && getCuotaMensual() <= cliente.getSueldoNetoMensual() * 0.7;
    }

    @Override
    public double getCuotaMensual() {
        return monto / plazo;
    }

    @Override
    public Cliente getCliente() { return cliente; }

    @Override
    public double getMonto() { return monto; }

    @Override
    public int getPlazo() { return plazo; }
    
    @Override
    public boolean fueAprobada() {
        return aprobada;
    }

    @Override
    public void procesarAceptacion() {
        aprobada = true;
    }
}
	
