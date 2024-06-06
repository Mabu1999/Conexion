package FigurasConIA;

public abstract class Figura {

	protected double area;
	protected int id;
	protected String tipo;
	private static int contadorId;
	public Figura(String tipo) {
		this.tipo=tipo;
		id=contadorId;
		contadorId++;
	}
	abstract double calcularArea();
	
	public String getArea() {
		return "El area de la figura:"+id+" de tipo:"+tipo+" es: "+area+"cm²";
	}
	public String toString() {
		return "Figura "+ id +": Es un "+ tipo;
	}
	
}
