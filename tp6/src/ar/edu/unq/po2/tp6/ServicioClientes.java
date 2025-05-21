package ar.edu.unq.po2.tp6;

import java.util.ArrayList;
import java.util.List;

public class ServicioClientes implements IServicioClientes {
    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public boolean contieneCliente(Cliente cliente) {
        return clientes.contains(cliente);
    }
    
    public int cantidadClientes() {
    	return clientes.size();
    }
}
