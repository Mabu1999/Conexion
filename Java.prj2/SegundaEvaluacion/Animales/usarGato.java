package Animales;
import java.util.Scanner;
public class usarGato {


private static gato[] aMascotas;
private static gato[] aMascotasAuto;

public static void main(String[] args) {
	
	      Scanner scan = new Scanner(System.in);
	     // Inicializamos el array de mascotas con la posicion [0] para el animal por defecto
	      aMascotas = new gato[11];
          aMascotas[0] = new gato(); // Animal por defecto

	      // Creación de 10 gatos diferentes tecleando + default
	      for (int i = 1; i <= 10; i++) {
	           System.out.println("Introduce el nombre del gato");
	           String nombre = scan.nextLine();
	           System.out.println("Introduce la edad del gato");
	           int edad = scan.nextInt();
	           System.out.println("Introduce el peso del gato");
	           float peso = scan.nextFloat();
	           scan.nextLine();
	           aMascotas[i] = new gato(nombre, edad, peso);
	      }
	        
	      //Bucle de muestra de gatos creados previamente en sentido contrario
	      for (int i = aMascotas.length - 1; i >= 0; i--) {
	          System.out.println("\n" + aMascotas[i].toString()); 
	      }
	      System.out.println("\n---PRUEBA DE METODOS\n");
	      aMascotas[0].setNombre("Cucardo");
	      aMascotas[0].setEdad(5);
	      aMascotas[0].setPeso(4.6f);
	      System.out.println(aMascotas[0].toString() + "\n");
	      aMascotas[0].comer();
	      aMascotas[1].dormir();
	      aMascotas[2].maullar();

	      System.out.println("\n\n---SEGUNDA PARTE\n"); //Parte de creación automatizada
	      
	      aMascotasAuto = new gato[11];
	      //Creación de array con los nombres posibles
	      String[] nombres = {"Mittens", "Whiskers", "Felix", "Garfield", "Cucardo", "Simba", "Nala", "Luna", "Bella", "Oliver"};
	      //Bucle de creación de gatos aleatorio
	      for (int i = 0; i <= 10; i++) {
	          String nombre = nombres[(int)(Math.random()*10)];
	          int edad = ((int)(Math.random()*14)+1);
	          float peso = ((float)(Math.random()*8.5f)+1.5f);
	          aMascotasAuto[i] = new gato(nombre, edad, peso);  
	      }
	      //Bucle de muestra de gatos creados previamente
	      for (int i = 0; i <= aMascotasAuto.length -1; i++) {
	          System.out.println("\n" + aMascotasAuto[i].toString());
	      }
	      scan.close();
	}
	    
}
