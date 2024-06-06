package Pruebas;

public class Vehiculo {
	protected double velocidad;
	public void acelerar(double kmh) {
	velocidad += kmh;
	}

}

class coche extends Vehiculo{
	protected int gasolina;
	public void acelerar(double kmh) {
	super.acelerar(kmh);
	gasolina*=0.9;
	}
}