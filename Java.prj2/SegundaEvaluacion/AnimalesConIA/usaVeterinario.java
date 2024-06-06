package AnimalesConIA;

//Francisco Pozo Romero
public class usaVeterinario {
 public static void main(String[] args) {
     Animal[] animales = new Animal[4];
     // Crear algunos animales de diferentes tipos
     animales[0] = new perro("Bobby", 3, "Labrador");
     animales[1] = new gato("Mittens", 2, "Blanco");
     animales[2] = new pajaro("Slithers", 1);
     animales[3] = new pajaro("Volador II", 4);
     animales[1].setPatas(44);
     ((pajaro) animales[3]).volar(); //Método propio
     animales[2].setEdad(5); //Método heredado del padre
     animales[0].setNombre("Bobby I"); //Método heredado del padre
     // Recorrer el array de animales en orden directo
     System.out.println("Recorriendo el array de animales en orden directo:");
     for (Animal animal : animales) {
         if (animal != null) {
             System.out.println(animal.toString());
         }
     }
     // Recorrer el array de animales en orden inverso
     System.out.println("\nRecorriendo el array de animales en orden inverso:");
     for (int i = animales.length - 1; i >= 0; i--) {
         if (animales[i] != null) {
             System.out.println(animales[i].toString());
         }
     }
 }
}
