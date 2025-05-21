package ar.edu.unq.po2.tp6;

public class CreditoHipotecario implements SolicitudCredito {
    private final Cliente cliente;
    private final double monto;
    private final int plazo;
    private final Propiedad garantia;
    private boolean aprobada = false;

    public CreditoHipotecario(Cliente cliente, double monto, int plazo, Propiedad garantia) {
        this.cliente = cliente;
        this.monto = monto;
        this.plazo = plazo;
        this.garantia = garantia;
    }

    @Override
    public boolean esAceptable() {
        return getCuotaMensual() <= cliente.getSueldoNetoMensual() * 0.5
               && monto <= garantia.getValorFiscal() * 0.7
               && cliente.getEdadEnMeses(plazo) <= 65;
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