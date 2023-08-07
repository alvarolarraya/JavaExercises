import java.io.*;
public class Ejercicio4_2
{
    public static void main(String[] args){
        int factorial, numero;
        numero = Integer.parseInt(args[0]);
        factorial = 2;
        for (int i = 3; i < (numero+1); i++)
            factorial = factorial*i;
        System.out.print("El factorial de " + numero + " es: " + factorial + "\n");
    }
}
