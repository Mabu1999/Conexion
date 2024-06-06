package AnimalesConIA;

//Francisco Pozo Romero, Adrian Hidalgo Carmona, Christian Hidalgo Carmona
public class Animal {
 protected String nombre;
 protected int edad;
 private static int contadorAnimales = 0;
 protected int idAnimal;
 protected int numPatas;
 protected String tipo;
 public Animal() {
     this.nombre = "Sin nombre";
     this.edad = 0;
     this.tipo = "Desconocido";
     this.idAnimal = ++contadorAnimales;
 }
 public Animal(String nombre, int edad, int numPatas, String tipo) {
     this.nombre = nombre;
     this.edad = edad;
     this.numPatas = numPatas;
     this.tipo = tipo;
     this.idAnimal = ++contadorAnimales;
 }
 public String getNombre() {
     return nombre;
 }
 public void setNombre(String nombre) {
     this.nombre = nombre;
 }
				 public void setPatas(int patas) {
				     this.numPatas = patas;
				 }
 public int getEdad() {
     return edad;
 }
 public void setEdad(int edad) {
     this.edad = edad;
 }
 @Override
 public String toString() {
     return "Animal[id=" + idAnimal + ", Nombre: " + nombre + ", Edad: " + edad + ", Patas: " + numPatas + ", Tipo: " + tipo + "]";
 }
}
