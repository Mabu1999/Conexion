package AnimalesConIA;

//Christian Hidalgo Carmona con ayuda de Francisco Pozo Romero
public class pajaro extends Animal implements canFly{
 private static int alas=2;
 private boolean vuelo=false;
 private static int numPatas=2;
 public pajaro(String nombre, int edad) {
     super(nombre, edad, pajaro.numPatas, "Pajaro");
    
 }
 public void volar() {
 	this.vuelo=true;
 }
 public void aterrizar() {
 	this.vuelo=false;
 }
 public String estaVolando() {
 	
 	if(vuelo) {
 		return ", Está volando";
 	}
 	return ", No está volando";
 }
 @Override
 public String toString() {
     return super.toString() + ", Numero de alas: " + alas + estaVolando();
 }
}
