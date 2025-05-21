package ar.edu.unq.po2.tp6;

public interface IServicioClientes {
    void registrarCliente(Cliente cliente);
    boolean contieneCliente(Cliente cliente);
	int cantidadClientes();
}
