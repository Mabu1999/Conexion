package FigurasConIA;

public class Circulo extends Figura  {
	private static final double PI=3.1416;
	private double radio;
	private static final String tipo = "Circulo";
	public Circulo(double radio) {
		super(Circulo.tipo);
		this.radio=radio;
	}
	public double calcularArea() {
		area = PI * (Math.pow(radio, 2));
		return area;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio=radio;
	}
	public String toString() {
		return super.toString()+" con una radio de: "+ radio +"cm";
	}
}
