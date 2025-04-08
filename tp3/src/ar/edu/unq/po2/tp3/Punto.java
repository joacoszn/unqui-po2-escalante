package ar.edu.unq.po2.tp3;

public class Punto {
	int x;
	int y;
	
	public Punto() {
		x = 0;
		y = 0;
	}
	
	public Punto(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void mover(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Punto sumarse(Punto punto) {
		int xDelNuevoPunto= this.x+punto.getX();
		int yDelNuevoPunto= this.y+punto.getY();
		return(new Punto(xDelNuevoPunto, yDelNuevoPunto));
	}
}
