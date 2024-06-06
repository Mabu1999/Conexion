package Tema6;
import java.util.Scanner;
public class MiMath 
{
	//Declaración de constante global PI
   public static final double PI = 3.14159265358979323846;
  
   public long multi(long numero1, long numero2) //Multiplicacion de Enteros muy grandes
   {
   	//Declaración de variable
	    long total=0;
	    
	    //Suma el segundo numero el numero de veces que sea el primer número
		for(long i=numero1;i>0;i--)
		{
			total+=numero2;
		}
		
   return total;
   }
   
	public double multi(double numero1, double numero2) //Multiplicación con decimales
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		double numero11=0;
		double numero22=0;
		int parteEntera=0;
		int parteDecimal=0;
		int total=0;
		double resultadoFinal=0;
		//Eliminación de 2 cifras decimales
		for(int i = 0;i<100;i++)
		{
			numero11+=numero1;
			numero22+=numero2;
		}
		//Redondeo del primer número
		numero11=Calculadora.redondeo(numero11);
		
		//Redondeo del segundo número
		numero22=Calculadora.redondeo(numero22);
		
		//Suma el segundo numero el numero de veces que sea el primer número
		for(int i=(int)numero11;i>0;i--)
		{
			total+=numero22;
		}
		//Calculo de parte entera, separando parte entera y decimal
		for(int i=0 ;total>= 0; i++)
		{
			parteDecimal=total;
			total-=10000;
			parteEntera=i;
		}
		//Recomposición de número completo
		if(parteDecimal>=1000)
		{
			String resultado = (parteEntera+"."+parteDecimal);
			resultadoFinal = Double.parseDouble(resultado);
		}
		else if(parteDecimal<10)
		{
			String resultado = (parteEntera+".000"+parteDecimal);
			resultadoFinal = Double.parseDouble(resultado);
		}
		else if(parteDecimal<100)
		{
			String resultado = (parteEntera+".00"+parteDecimal);
			resultadoFinal = Double.parseDouble(resultado);
		}
		else if(parteDecimal<1000)
		{
			String resultado = (parteEntera+".0"+parteDecimal);
			resultadoFinal = Double.parseDouble(resultado);
		}
		
	return resultadoFinal;
	}
	
	public double division(double dividendo, double divisor)
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		int parteEntera=0;
		int parteDecimal=0;
		int total=0;
		double parteRestante=0;
		double resultadoFinal=0;
		//Eliminación de cifras decimales
		dividendo=Calculadora.multi(dividendo,100);
		//Resta al dividendo el divisor mientras el dividendo sea menor o igual que el divisor
		for(int i = 1;dividendo>=divisor;i++)
		{
			dividendo-=divisor;
			//Redondeo
			dividendo=Calculadora.redondeo(dividendo);
			total=i;
		}
		//Calculo de parte entera, separando parte entera y decimal
		for(int i = 0;total>=0;i++)
		{
			parteRestante=total;
			total-=100;
			parteEntera=i;	
		}
		//Si la parte restante es mayor que 0 se calcula la parte decimal, si es 0 se asigna 0 a parteDecimal
		if (parteRestante>0)
		{
			//Calculo de parte decimal Aumento de valor para posibilitar el cálculo
			parteRestante=Calculadora.multi(parteRestante,100);
			//Resta 100 a la parte restante mientras la parte restante sea mayor o igual a 0
			for(int i = 0;parteRestante>=0;i++)
			{
				parteRestante-=100;
				parteDecimal=i;
			}
		}
		else
		{
			parteDecimal=0;
		}
		//Recomposición de número completo
		if(parteDecimal>=10)
		{
		String resultado = (parteEntera+"."+parteDecimal);
		resultadoFinal = Double.parseDouble(resultado);
		}
		else if(parteDecimal<10)
		{
			String resultado = (parteEntera+".0"+parteDecimal);
			resultadoFinal = Double.parseDouble(resultado);
			
		}
		
	return resultadoFinal;
	}
	
	public double redondeo(double numero)
	   {
	   	//Declaración de variables
	   	int parteEntera=0;
			int parteDecimal=0;
			double acumulador=0;
	   	double resultadoFinal=0;
	   	int numeroSinDecimales=(int)numero;
	   	//Asignación de parte entera
	   	parteEntera=numeroSinDecimales;
	   	numero-=(double)numeroSinDecimales;
	   	//Eliminación de decimales
	   	for(int i = 0;i<100;i++)
			{
				acumulador+=numero;	
				
			}
	   	numero=acumulador;
	   	//Redondeo a 2 cifras decimales
	   	int redondeo=(int)numero;
	   	double comparador=(double)redondeo;
	   	comparador=comparador+0.5;
	   	if(numero > comparador)
			{
				parteDecimal=redondeo+1;
			}
			else
			{
				parteDecimal=redondeo;
			}
	   	//Recomposición de número Completo
	   	if(parteDecimal<=0)
	   	{
	   			String resultado = (parteEntera+"."+parteDecimal);
	   			resultadoFinal = Double.parseDouble(resultado);
	   	}
	   	else if(parteDecimal<10)
	   	{
	   		String resultado = (parteEntera+".0"+parteDecimal);
				resultadoFinal = Double.parseDouble(resultado);
	   	}
	   	else if(parteDecimal<100)
	   	{
	   		String resultado = (parteEntera+"."+parteDecimal);
			resultadoFinal = Double.parseDouble(resultado);
	   	}
	   	else if(parteDecimal==100)
	   	{
	   		parteEntera+=1;
	   		parteDecimal=0;
	   		String resultado = (parteEntera+"."+parteDecimal);
			resultadoFinal = Double.parseDouble(resultado);
	   	}
	   	
	   	return resultadoFinal;
	   }
	
	public double raizCuadrada(double radicando)
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		double estimacion=0;
		double resultado=0;
		//En caso de que radicando sea 0 se asigna 0 al resultado y si no se hace el calculo
		if(radicando==0)
		{
			estimacion=0;
		}
		else
		{
			//Cálculo de raíz cuadrada por estimación de newton raphson
			estimacion = Calculadora.division(radicando, 2);
			for (int i = 0; i < 100; i++)
		    {
		        resultado  = Calculadora.division(radicando, estimacion);
		        resultado += estimacion;
		        estimacion = Calculadora.division(resultado, 2);
		    }
		}
		
	   
	return estimacion;
	}
	
	public double potencias(double base, double exponente)
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		double resultado=0;
		//Crea los comparadores
		int baseSinDecimales=(int)base;
		double comprobadorBase=base-(double)baseSinDecimales;
		//Si tiene parte decimal se calcula con double y si no con long
		if(comprobadorBase>0)
		{
			resultado=base;
			for (int i = 2; i <= exponente; i++)//Calculo de potencia
			{
		        resultado  = Calculadora.multi(resultado, base);
			}
		}
		else
		{
			long resultadoLong=(long)base;
			for (int i = 2; i <= exponente; i++)//Calculo de potencia
			{	
						
				resultadoLong  = Calculadora.multi(resultadoLong, (long)base);
				resultado=(double)resultadoLong;
			}
		}
	   
	return resultado;
	}
	
	public double areaCuadradoRectangulo(double lado1, double lado2)
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		double resultado=0;
		
		//Calculo de area del cuadrado
		resultado=Calculadora.multi(lado1,lado2);
		
		return resultado;
	}
	public double areaTriangulo(double base, double altura)
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		double resultado=0;
		double resultadoFinal=0;
		
		//Calculo de area del triangulo
		resultado=Calculadora.multi(base,altura);
		resultadoFinal=Calculadora.division(resultado,2);
		
		return resultadoFinal;
	}
	public double areaCirculo(double radio)
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		double resultado=0;
		double resultadoFinal=0;
		
		//Calculo de area del circulo
		resultado=Calculadora.multi(radio,radio);
		resultadoFinal=Calculadora.multi(PI,resultado);
		
		return resultadoFinal;
	}
	
	public double teoremaPitagoras(double numero1, double numero2, int tipo)
	{
		//Declaración de variables y objetos
		MiMath Calculadora =new MiMath();
		double resultado=0;
		double resultado1=0;
		double resultado2=0;
		double resultadoFinal=0;
		
		//Elección de cálculo establecido en el main
		if (tipo==1)
		{
			//Cálculo de la hipotenusa
			resultado1=Calculadora.multi(numero1,numero1);
			resultado2=Calculadora.multi(numero2,numero2);
			resultado=resultado1+resultado2;
			resultadoFinal=Calculadora.raizCuadrada(resultado);
		}
		if (tipo==2)
		{
			//Cálculo de un cateto
			resultado1=Calculadora.multi(numero1,numero1);
			resultado2=Calculadora.multi(numero2,numero2);
			resultado=resultado1-resultado2;
			resultadoFinal=Calculadora.raizCuadrada(resultado);
		}
		
		return resultadoFinal;
	}
	
	//Ejemplo de Jorge Sanchez
	public double suma(double x, double y)
	{
	 return x+y;
	}
	public double suma(double x, double y, double z)
	{
	return x+y+z;
	}
	public double suma(double[] array)
	{
	double total =0;
		for(int i=0; i<array.length;i++)
		{
			total+=array[i];
		}
			 return total;
	}


public static void main(String[] args)
	{
		System.out.print
		(
			"\n _-************| CALCULADORA |************-_ \n"
			+ "\n    Estándar:"
			+ "\n	  1.- Multiplicar"
			+ "\n	  2.- Dividir"
			+ "\n	  3.- Redondeo"
			+ "\n	  4.- Raiz"
			+ "\n	  5.- Potencia"
			+ "\n\n    Geometría:"
			+ "\n	  6.- Área del cuadrado/rectangulo"
			+ "\n	  7.- Area del triangulo"
			+ "\n	  8.- Area del circulo"
			+ "\n\n    Trigonometría:"
			+ "\n	  9.- Teorema de Pitágoras"
			+ "\n\n    Jorge Sanchez:"
			+ "\n	  10.- Ejemplo de sumas"
			+ "\n\n --***************************************--"
		);
		System.out.println("\n\n Indica la operación a realizar (Introduce numero).");
	
	//Declaración de variables y objetos
	Scanner scan = new Scanner(System.in);
	int menu = scan.nextInt();
	MiMath Calculadora =new MiMath();
	double resultado;
	
	switch(menu) //Para entrar en los diferentes cálculos
	{
	case 1:
		System.out.println(" MULTIPLICACIÓN \n");
		System.out.println("  Introduce el primer número:");
		double numero1 = scan.nextDouble();
		System.out.println("  Introduce el segundo número:");
		double numero2 = scan.nextDouble();
		
		resultado= Calculadora.multi(numero1, numero2);//Llama al método de la multiplicación
		
		System.out.println("\n  El resultado de multiplicar "+numero1+" por "+numero2+" es: "+resultado);
		break;
		
	case 2:
		System.out.println(" DIVISION \n");
		System.out.println("  Introduce el dividendo:");
		double dividendo = scan.nextDouble();
		System.out.println("  Introduce el divisor:");
		double divisor = scan.nextDouble();
		
		if(divisor==0) //En caso de intentar dividir entre 0 da ERROR
		{
			System.out.println("ERROR: No se puede dividir entre 0");
		}
		else
		{
			resultado= Calculadora.division(dividendo, divisor);//Llama al metodo de la division
			
			System.out.println("\n  El resultado de dividir "+dividendo+" entre "+divisor+" es: "+resultado);
		}
		break;
		
	case 3:
		System.out.println(" REDONDEO \n");
		System.out.println("  Introduce el numero a redondear:");
		double numero = scan.nextDouble();
		
		resultado= Calculadora.redondeo(numero);//Llama al método del redondeo
		
		System.out.println("\n  El resultado de redondear "+numero+" es: "+resultado);
		break;
		
	case 4:
		System.out.println(" RAIZ CUADRADA \n");
		System.out.println("  Introduce el radicando:");
		double radicando = scan.nextDouble();
		
		resultado= Calculadora.raizCuadrada(radicando);//Llama al método de la raíz cuadrada
		
		System.out.println("\n  El resultado de la raíz cuadrada de  "+radicando+" es de: "+resultado);
		break;
		
	case 5:
		System.out.println(" POTENCIAS \n");
		System.out.println("  Introduce la base:");
		double basePotencia = scan.nextDouble();
		System.out.println("  Introduce el exponente:");
		double exponente = scan.nextDouble();
		//Comprobador de exponente
		int exponenteSinDecimales=(int)exponente;
		double comprobadorExponente=exponente-(double)exponenteSinDecimales;
		if (comprobadorExponente>0)
		{
			System.out.println("El exponente debe ser un numero entero.");
		}
		else
		{
			resultado= Calculadora.potencias(basePotencia, exponente);//Llama al método de las potencias
			
			System.out.println("\n  El resultado de "+basePotencia+" elevada a "+exponente+" es: "+resultado);
		}
		break;
		
	case 6:
		System.out.println(" AREA DEL CUADRADO/RECTANGULO \n");
		System.out.println("  Introduce el primer lado:");
		double lado1 = scan.nextDouble();
		System.out.println("  Introduce el segundo lado:");
		double lado2 = scan.nextDouble();
		
		resultado= Calculadora.areaCuadradoRectangulo(lado1, lado2);//Llama al método del área del cuadrado
		
		System.out.println("\n  El area del cuadrado/rectangulo cuyos lados son "+lado1+"cm y "+lado2+"cm es: "+resultado+"cm²");
		break;
		
	case 7:
		System.out.println(" AREA DEL TRIANGULO \n");
		System.out.println("  Introduce la base:");
		double baseTriangulo = scan.nextDouble();
		System.out.println("  Introduce la altura:");
		double altura = scan.nextDouble();
		
		resultado= Calculadora.areaTriangulo(baseTriangulo, altura);//Llama al método del área del triángulo
		
		System.out.println("\n  El area del triangulo cuya base es "+baseTriangulo+"cm y cuya altura es "+altura+"cm es: "+resultado+"cm²");
		break;
		
	case 8:
		System.out.println(" AREA DEL CIRCULO \n");
		System.out.println("  Introduce el radio:");
		double radio = scan.nextDouble();
		
		resultado= Calculadora.areaCirculo(radio);//Llama al método del área del círculo
		
		System.out.println("\n  El area del circulo cuyo radio es "+radio+"cm es: "+resultado+"cm²");
		break;
		
	case 9:
		System.out.println(" TEOREMA DE PITÁGORAS \n");
		System.out.println(" Para calcular la hipotenusa introduce '1'");
		System.out.println(" Para calcular un cateto introduce '2'");
		int tipo = scan.nextInt();//Elección de calculo de hipotenusa o de cateto
			if(tipo==1)
			{
				System.out.println("  Introduce el primer cateto:");
				double cateto1 = scan.nextDouble();
				System.out.println("  Introduce el segundo cateto:");
				double cateto2 = scan.nextDouble();
				
				//Llama al método del teorema de Pitagoras
				resultado= Calculadora.teoremaPitagoras(cateto1,cateto2,tipo);
				
				System.out.println("\n  La hipotenusa de un triángulo cuyos catetos son "+cateto1
									+"cm y "+cateto2+"cm \n  es de: "+resultado+"cm");
			}
			else if(tipo==2)
			{
				System.out.println("  Introduce la hipotenusa:");
				double hipotenusa = scan.nextDouble();
				System.out.println("  Introduce el cateto:");
				double cateto = scan.nextDouble();
				
				//Llama al método del teorema de Pitágoras
				resultado= Calculadora.teoremaPitagoras(hipotenusa,cateto,tipo);
				
				System.out.println("\n  El cateto de un triángulo cuya hipotenusa es "+hipotenusa
									+"cm \n  y cuyo cateto es "+cateto+"cm es de: "+resultado+"cm");
			}
		break;
		
	case 10:
		//Ejemplo de Jorge Sanchez
		System.out.println("  SUMA DE ENTEROS  ");
		//1)
		System.out.print("\n	LA SUMA 1 ES = ");
		double res= Calculadora.suma(3.1, 6.0);
		System.out.print(res);
		//2)
		System.out.print("\n	LA SUMA 2 ES = ");
		res= Calculadora.suma(2, 6.54, 10);
		System.out.print(res);
		//3
		double array[]={2,2,1.54,1,1.22};
		System.out.print("\n	LA SUMA 3 ES = ");
		res= Calculadora.suma(array);
		System.out.print(res);
	break;
		
	}
	scan.close();
	}
	
}

