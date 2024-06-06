package FigurasConIA;

public class Cuadrado extends Figura implements Dibujable{
	
	private double lado;
	private static final String tipo = "Cuadrado";
	public Cuadrado(double lado) {
		super(Cuadrado.tipo);
		this.lado=lado;
	}
	public double calcularArea() {
		area = lado * lado;
		return area;
	}
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado=lado;
	}
	public String toString() {
		return super.toString()+" con unos lados de: "+ lado +"cm";
	}
	public void dibujar() {
		System.out.println("Dibujo representativo de la figura:"+ id +" de tipo: "+ tipo +"\n");
		  for (int f = 1; f <= lado; f++) { // Itera sobre las filas
			  	for (double cVacia = 5; cVacia > 1; cVacia--) { // Imprime espacios para centrar el triángulo
		            System.out.print(" ");
		        }
		        for (int c = 1; c <= lado; c++) { // Itera sobre las columnas
		            if((f==1 || f==lado) || (c==1 || c==lado)) {
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
