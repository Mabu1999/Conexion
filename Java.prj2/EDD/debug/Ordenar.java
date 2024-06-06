package debug;
//Programa que cuenta el número de palabras de un texto.                                  
import java.util.Scanner;
import java.lang.String;

//CORREGIDO

public class Ordenar {

		public static void main(String[] args) {
			
		String[] strAr1=new String[10];
		Scanner sc = new Scanner(System.in);
	     String frase;
	     System.out.print("Introduce una frase: ");
	     frase = sc.nextLine();
	     sc.close();
	     strAr1=CargarPalabras(frase);
	     //Mostrar array
		System.out.println("El Array de palabras SIN ordenar es : ");

	     ShowArray(strAr1);
	     //Ordenar - usamos compareTo()
	     OrdenaArray(strAr1);
	     //Volver a mostrar
		System.out.println("El Array de palabras ORDENADO es : ");

	     ShowArray(strAr1);
	  }
		//Método que recibe un String y devuelve un array de palabras
		public static String[] CargarPalabras(String s) {
		int i = 0, n=0;
		String palabra="";
		String[] str=new String[10];
                      
		if (!s.isEmpty()) { //si la cadena está vacía
		    
			//Pasar a minúsculas la frase
			s.toLowerCase();
		    while (n < s.length()) {   
		             if  (Character.isLetter(s.charAt(n))) { 
		            	 	palabra+=s.charAt(n);  
		            	 } else if ((s.charAt(n) ==' ') || ((s.charAt(n) ==',')) || (s.charAt(n) =='.') || (s.charAt(n) ==';') || (s.charAt(n) ==':') || (s.charAt(n) ==')' || (s.charAt(n) =='('))) {
		            		//Guardar la palabra
		            		str[i]=palabra;
		            		i++;
		            		palabra="";
		            		 
		            	 }  
		             n++;
		             }
		            
		}
		if (palabra.length()>0) //Guardar palabra 		            		
			str[i]=palabra;

		
		return str;
	}

		//Metodo que recorre el array de strings
		public static void ShowArray(String [] a ) {
			for (int x=0; x<a.length; x++){
				if(a[x]!=null) {
					System.out.println(a[x]);
				}

				
		}
}
		
		//Metodo que ordena el array de strings
				public static void OrdenaArray(String [] a ) {
				String aux; 
					for (int x = 1; x < a.length-1; x++) {
					    
					        for (int y = 0; y < a.length - 1; y++) {
					           if (a[y+1]!=null) {
					            if ((a[y].compareTo(a[y+1]))>0) {
					                
					                aux=a[y];
							a[y]=a[y+1];
							a[y+1]=aux;
					            	}
					            x=a.length-1;
					           	}
					        }
					    }
		}
}

