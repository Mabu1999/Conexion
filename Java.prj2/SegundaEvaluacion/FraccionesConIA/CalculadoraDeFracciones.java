package FraccionesConIA;

import java.util.Scanner;

public class CalculadoraDeFracciones {

    private int numerador;
    private int denominador;

    public CalculadoraDeFracciones(int numerador, int denominador) {
        if (denominador == 0) {
            System.out.println("Advertencia: El denominador no puede ser cero. Estableciendo el denominador a 1.");
            this.denominador = 1;
        } else {
            this.numerador = numerador;
            this.denominador = denominador;
            simplificarFraccion();
        }
    }

    public void sumar(CalculadoraDeFracciones otraFraccion) {
        numerador = numerador * otraFraccion.denominador + otraFraccion.numerador * denominador;
        denominador = denominador * otraFraccion.denominador;
        simplificarFraccion();
    }

    public void restar(CalculadoraDeFracciones otraFraccion) {
        numerador = numerador * otraFraccion.denominador - otraFraccion.numerador * denominador;
        denominador = denominador * otraFraccion.denominador;
        simplificarFraccion();
    }

    public void multiplicar(CalculadoraDeFracciones otraFraccion) {
        numerador = numerador * otraFraccion.numerador;
        denominador = denominador * otraFraccion.denominador;
        simplificarFraccion();
    }

    public void dividir(CalculadoraDeFracciones otraFraccion) {
        if (otraFraccion.numerador == 0) {
            System.out.println("Advertencia: No se puede dividir por cero. La fracción resultante será 0/1.");
        } else {
            numerador = numerador * otraFraccion.denominador;
            denominador = denominador * otraFraccion.numerador;
            simplificarFraccion();
        }
    }

    private int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    private void simplificarFraccion() {
        int mcd = mcd(Math.abs(numerador), Math.abs(denominador));
        numerador = numerador / mcd;
        denominador = denominador / mcd;
    }

    public void imprimirFraccion() {
        System.out.println(numerador + "/" + denominador);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la primera fracción:");
        System.out.print("Numerador: ");
        int numerador1 = scanner.nextInt();
        System.out.print("Denominador: ");
        int denominador1 = scanner.nextInt();

        System.out.println("Ingrese la segunda fracción:");
        System.out.print("Numerador: ");
        int numerador2 = scanner.nextInt();
        System.out.print("Denominador: ");
        int denominador2 = scanner.nextInt();

        CalculadoraDeFracciones fraccion1 = new CalculadoraDeFracciones(numerador1, denominador1);
        CalculadoraDeFracciones fraccion2 = new CalculadoraDeFracciones(numerador2, denominador2);

        fraccion1.sumar(fraccion2);

        System.out.print("La suma de las fracciones es: ");
        fraccion1.imprimirFraccion();
        scanner.close();
    }
}
