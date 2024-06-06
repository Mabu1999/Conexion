package FigurasConIA;

public class usaFiguras {

	public static void main(String[] args) {
		Figura[] figuras = new Figura[3];
		figuras[0] = new Cuadrado(8);
		figuras[1] = new Triangulo(7,7);
		figuras[2] = new Circulo(14);
		System.out.print("USO FIGURAS");
		System.out.println("\n\nImpresion de array en orden directa:");
		for(Figura figura: figuras) {
			System.out.println(figura.toString());
		}
		
		System.out.println("\n\nImpresion de array en orden inversa:");
		for(int i = figuras.length-1;i >= 0;i--) {
			System.out.println(figuras[i].toString());
		}
		
		System.out.println("\n\nImpresion de Areas:");
		
		for(Figura figura : figuras) {
			figura.calcularArea();
			System.out.println(figura.getArea());
		}
		
		System.out.println("\n\nImpresion de Areas:");

			((Cuadrado)figuras[0]).dibujar();
			((Triangulo)figuras[1]).dibujar();
	}

}
