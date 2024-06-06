package AnimalesConIA;

//Adrian Hidalgo Carmona
public class perro extends Animal {
 private String raza;
 private static int numPatas=4;
 public perro(String nombre, int edad, String raza) {
     super(nombre, edad, perro.numPatas, "Perro");
     this.raza = raza;
 }
 public String getRaza() {
     return raza;
 }
 public void setRaza(String raza) {
     this.raza = raza;
 }
 @Override
 public String toString() {
     return super.toString() + ", Raza: " + raza;
 }
}
