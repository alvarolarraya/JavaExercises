import java.util.Scanner;
public class Ejercicio4_3{
    public static void main(String args[]){
        int factorial, numero;
        Scanner scan = new Scanner(System.in);
        System.out.print("Indique el número del que quiere calcular el factorial: ");
        numero = scan.nextInt();
        factorial = 2;
        for (int i = 3; i < (numero+1); i++)
            factorial = factorial*i;
        System.out.print("El factorial de " + numero + " es: " + factorial + "\n");
    }
}
