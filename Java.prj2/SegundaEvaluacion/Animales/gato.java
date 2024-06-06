package Animales;

public class gato 
{
private String nombre;
private int edad;
private float peso;
	//Constructores
	public gato(){
		this.nombre = "Cucardito";
		this.edad = 5;
		this.peso = 6.45F;
	}
	public gato(String nombre, int edad, float peso ) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}
	//Getter's y Setter's de source + metodos propios
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;   
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", edad: " + edad + " años" + ", peso: " + peso+ " Kg";
	}
	public void maullar() {
		System.out.println(nombre + " está maullando: ¡Miau, miau miauuu!\n");
	}
	public void comer() {
		System.out.println(nombre + " está comiendo: ñam ñam ñam...\n");
	}
	public void dormir() {
		System.out.println(nombre + " está durmiendo: Zzz Zzzz Zzzzz\n");
	}
}
