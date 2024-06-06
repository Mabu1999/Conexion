package Tema5;


public class Test_arrays {

	public static void main(String[] args) {
		
		
		int numeros[]=new int[10];
		
		for(int i=0;i<numeros.length;i++) {
			
			numeros[i]=(int)(Math.random()*100);

		}
		System.out.println("Normal");
		for(int i=0;i<numeros.length;i++) {
			
			
			System.out.print(numeros[i]+" ");
		}
		System.out.println("\n"+"Reverse");
		for(int i=numeros.length-1;i>=0;i--) {
		
			
			System.out.print(numeros[i]+" ");
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*Scanner scan = new Scanner(System.in);
		
		double array1[]=new double[5];
		
		System.out.println("Introduce un numero double");
		
		double numero = scan.nextDouble();
		
		array1 [0] = numero;
		
		if(array1[0] > 0){

		int AAA =(int)array1[0];
		
		System.out.print("Array[0]= "+ AAA + "  ");
		System.out.printf("%1.5f",array1[0]);
		
		}
		scan.close();*/
		

	}

}
