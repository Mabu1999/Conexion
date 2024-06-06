package FigurasConIA;

public class Triangulo extends Figura implements Dibujable{
	private double base;
	private double altura;
	private static final String tipo = "Triangulo";
	public Triangulo(double base, double altura) {
		super(Triangulo.tipo);
		this.base=base;
		this.altura=altura;
	}
	public double calcularArea() {
		area = (base * altura)/2;
		return area;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base=base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura=altura;
	}
	public String toString() {
		return super.toString()+" con una base de: "+ base +"cm y con una altura de: "+ altura+"cm";
	}
	public void dibujar() {
		System.out.println("Dibujo representativo de la figura:"+ id +" de tipo: "+ tipo +"\n");
		for (int f = 0; f < altura; f++) { // Itera sobre las filas
	        for (double cVacia = (altura - f)+5; cVacia > 1; cVacia--) { // Imprime espacios para centrar el triángulo
	            System.out.print(" ");
	        }
	        for (int c = 0; c <= f; c++) { // Itera sobre las columnas
	            if((c == 0 || c == f)||(f==altura-1)) {
	            	System.out.print("* ");
	            }
	            else {
	            	System.out.print("  ");
	            }
	        }
	        System.out.println(); // Salto de línea al final de cada fila
	    }
	}
}

