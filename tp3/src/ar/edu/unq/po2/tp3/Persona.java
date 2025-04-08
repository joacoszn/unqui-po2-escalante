package ar.edu.unq.po2.tp3;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {
	private String nombre;
	private LocalDate fechaNac;
	
	public Persona (String nombre, LocalDate fechaNac) {
		if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser null");
        }
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
		this.fechaNac = fechaNac;
	}
	
	public int edad() {
		LocalDate fechaActual = LocalDate.now();
		return Period.between(fechaNac, fechaActual).getYears();
	}
	
	public boolean menorQue(Persona persona) {
		return(this.edad()<persona.edad());
	}
}
