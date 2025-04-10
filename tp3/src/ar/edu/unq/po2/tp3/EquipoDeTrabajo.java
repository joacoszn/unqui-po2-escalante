package ar.edu.unq.po2.tp3;
import java.util.List;
import java.util.ArrayList;

public class EquipoDeTrabajo {
	private String nombre;
	private List <Persona> integrantes;
	
	public EquipoDeTrabajo(String nombre) {
		if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser null");
        }
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
		integrantes = new ArrayList<>();
	}

	public String nombre(){
		return (nombre);
	}
	
	public void agregarIntegrante(Persona persona) {
		integrantes.add(persona);
	}
	
	public int promedioEdad() {
		int acumuladorEdad = 0;
		for (Persona p : integrantes) {
			acumuladorEdad = acumuladorEdad + p.edad();
		}
		return acumuladorEdad / integrantes.size();
	}
	
	public int cantidadDeIntegrantes() {
		return integrantes.size();
	}
}
