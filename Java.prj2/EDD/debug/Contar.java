package debug;
//Programa que cuenta el número de palabras de un texto.                                  
import java.util.Scanner;
import java.lang.String;


public class Contar {

//CORREGIDO
	  
		public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	     String frase;
	     System.out.print("Introduce una frase: ");
	     frase = sc.nextLine();
	     sc.close();
	     System.out.println("Número de palabras: " + contarPalabras(frase));                                             
	  }
		//Método que recibe un String y devuelve el número de palabras que contiene
		public static int contarPalabras(String s) {
		int contador = 0, n=0;
		@SuppressWarnings("unused")
		String palabra="";
                       
		if (s.isEmpty()) { //si la cadena está vacía
		    contador = 0;
		} else {
		        while (n < s.length()) {   
		             if  (Character.isLetter(s.charAt(n))) { 
		            	 	palabra+=s.charAt(n);  
		            	 } else if (s.charAt(n) ==' ' || s.charAt(n) ==','|| s.charAt(n) =='.' || s.charAt(n) ==';' || s.charAt(n) ==':' || s.charAt(n) ==')' || s.charAt(n) =='(') {
		            	
		            		 contador ++;
		            		 palabra="";
		            		 
		            	 }  
		             n++;
		             } 
				}
			
			contador++;
		return contador;
		}
	}