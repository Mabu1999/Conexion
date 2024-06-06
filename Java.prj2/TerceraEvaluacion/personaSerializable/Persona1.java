package personaSerializable;

import java.io.Serializable; //asi se podra guardar en serie los objetos persona


//IMPORTANTE EXPLICACIONES http://picarcodigo.blogspot.com.es/2013/02/leer-y-escribir-objetos-en-un-fichero.html


public class Persona1  implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private String nombre;
		private int edad;
		private String dni;
		
		public Persona1 (String n, int ed, String d)
			{ nombre=n; 
			edad=ed;
			dni=d;
			}
		public void setNombre(String nom)
			{	nombre = nom;	}
		public void setEdad(int e)
			{ edad=e;}
		public  String   getDNI () { return dni;}
		public String getNombre(){ return nombre;}
		public int getEdad(){ return edad;}
}
