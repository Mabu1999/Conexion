///Francisco Pozo Romero / 30/11/2023 / Saludo alternando mayusculas en el nombre
package Tema5;

public class bucleSaludoN5 
{

	public static void main(String[] args) 
	{
		double numero1=8;
		double numero2=0.02;
		double numero11=0;
		double numero22=0;
		int parteEntera=0;
		int parteDecimal=0;
		int total=0;
		double resultadoFinal=0;
		for(int i = 0;i<100;i++)
		{
			numero11+=numero1;
			numero22+=numero2;
		}
		System.out.println(numero11+"aqui");

		
		//Redondeo del primer numero
		int redondeo=(int)numero11;
		double comparador=(double)redondeo;
		comparador=comparador+0.5f;
		if(numero11 > comparador)
		{
			numero11=(double)redondeo+1;
		}
		else 
		{
			numero11=(double)redondeo;
		}
		//Redondeo del segundo numero
		redondeo=(int)numero22;
		comparador=(double)redondeo;
		comparador=comparador+0.5f;
		if(numero22 > comparador)
		{
			numero22=(double)redondeo+1;
		}
		else 
		{
			numero22=(double)redondeo;
		}
		System.out.println(numero22);
		System.out.println(numero11);
		for(int i=(int)numero11;i>0;i--) 
		{
			total+=numero22;
		}
		
		for(int i=0 ;total>= 0; i++) 
		{
			parteDecimal=total;
			System.out.println(total);
			total-=10000;
			parteEntera=i;
		}
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
		System.out.println(resultadoFinal);
	}

}