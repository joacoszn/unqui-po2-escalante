package ar.edu.unq.po2.tp3;
import java.util.List;
import java.util.ArrayList;

public class Counter {
	private List <Integer> lista;

	public Counter() {
		lista = new ArrayList<>();
	}

	public void addNumber(int i) {
		lista.add(i);
	}

	public int totalNumPares() {
		int paresHastaElMomento = 0;
		for (Integer i : lista) {
			if (this.esPar(i)) {
				paresHastaElMomento ++;
			}
		}
		return(paresHastaElMomento);
	}

	public int totalNumImpares() {
		int imparesHastaElMomento = 0;
		for (Integer i : lista) {
			if (!this.esPar(i)) {
				imparesHastaElMomento ++;
			}
		}
		return(imparesHastaElMomento);
	}

	public int totalMultiplosDe(Integer n) {
		int multiplosDeN = 0;
		for (Integer i : lista) {
			if (i%n == 0) {
				multiplosDeN++;
			}
		}
		return(multiplosDeN);		
	}

	public int numeroConMayorCantidadDeDigitosPares() {
		int numeroActual = 0;
		for (Integer i : lista) {
			if(totalDigitosPares(numeroActual) < totalDigitosPares(i)) {
				numeroActual = i;
			}
		}
		return(numeroActual);
	}

	public int totalDigitosPares(int i) {

		int n = i;
		int digitosActuales = 0;
		while (n>0) {
			int digito = n % 10;
			if (this.esPar(digito)) {
				digitosActuales++;
			}
			n /= 10;
		}
		return (digitosActuales);
	}

	public boolean esPar(int i) {
		return(i%2 == 0);
	}

	public int multiplos(int x, int y) {
		List <Integer> multiplosComunes = multiplosHastaMil(x);
		multiplosComunes.retainAll(multiplosHastaMil(y));
		if (multiplosComunes.isEmpty()) {
			return(-1);
		}
		int mayorMultiploComun = multiplosComunes.get(multiplosComunes.size()-1);
		return(mayorMultiploComun);
	}
	
	public List<Integer> multiplosHastaMil(int x) {
	    List<Integer> multiplos = new ArrayList<>();
	    for (int i = 1; x * i <= 1000; i++) {
	        multiplos.add(x * i);
	    }
	    return multiplos;
	}

}
