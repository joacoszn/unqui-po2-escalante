package ar.edu.unq.po2.tp3;

public class Rectangulo {
	private Punto ubicacion;
	private int base;
	private int altura;
	
	public Rectangulo(Punto punto, int base, int altura) {
		ubicacion = punto;
	    if (base <= 0) throw new IllegalArgumentException("La base debé ser mayor a 0.");
		this.base = base;
	    if (altura <= 0) throw new IllegalArgumentException("La altura debé ser mayor a 0.");
		this.altura = altura;
		}
	
	public int area() {
		return base*altura;
	}
	
	public int perimetro() {
		return(2*(base+altura));
	}
	
	public boolean esHorizontal() {
		return(base>altura);
	}
	
	public boolean esVertical() {
		return !this.esHorizontal();
	}
}

class Cuadrado extends Rectangulo{
	
	public Cuadrado(Punto punto, int tamaño) {
		super(punto, tamaño, tamaño);
	}
}