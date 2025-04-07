package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Multioperador {
	
	public int sumarTodos(ArrayList <Integer> numeros) {
		int sumaActual = 0;
		for (Integer i : numeros) {
			sumaActual = sumaActual + i;
		}
		return sumaActual;
	}
	
	public int restarTodos(ArrayList <Integer> numeros) {
		int restaActual = 0;
		for (Integer i : numeros) {
			restaActual = restaActual - i;
		}
		return restaActual;
	}
	
	public int multiplicarTodos(ArrayList <Integer> numeros) {
		int multiplicacionActual = 1;
		for (Integer i : numeros) {
			multiplicacionActual = multiplicacionActual * i;
		}
		return multiplicacionActual;
	}
	
	
	
	
}
