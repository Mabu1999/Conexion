package FigurasConIA;

public class PruebasDibujar {

	
	public static void main(String[] args) {
		double lado=5;
		double altura=10;
		   for (int f = 1; f <= lado; f++) { // Itera sobre las filas
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
		  
		   //Triangulo
		   
			    
			    for (int f = 0; f < altura; f++) { // Itera sobre las filas
			        for (double cVacia = altura - f; cVacia > 1; cVacia--) { // Imprime espacios para centrar el triángulo
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
