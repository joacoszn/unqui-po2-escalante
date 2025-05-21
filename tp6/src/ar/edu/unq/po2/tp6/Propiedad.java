package ar.edu.unq.po2.tp6;

public class Propiedad {
    private final String descripcion;
    private final String direccion;
    private final double valorFiscal;

    public Propiedad(String descripcion, String direccion, double valorFiscal) {
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.valorFiscal = valorFiscal;
    }

    public double getValorFiscal() {
        return valorFiscal;
    }
}
