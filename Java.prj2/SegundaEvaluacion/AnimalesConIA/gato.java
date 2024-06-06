package AnimalesConIA;

//Francisco Pozo Romero
public class gato extends Animal { 
 private String color;
 private static final int numPatas=4;
 private static final String tipo ="Gato";
 public gato(String nombre, int edad, String color) {
     super(nombre, edad, gato.numPatas, gato.tipo);
     this.color = color;
 }
 public String getColor() {
     return color;
 }
 public void setColor(String color) {
     this.color = color;
 }
 @Override
 public String toString() {
     return super.toString() + ", Color: " + color;
 }
}
