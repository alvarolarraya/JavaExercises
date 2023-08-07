import java.io.*;
public class Ejercicio4_1
{
    public static void main(String[] args) throws IOException{
        String textoNumero;
        int factorial, numero;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduce el numero en estudio: ");
        textoNumero = teclado.readLine();
        Integer intNumero = Integer.valueOf(textoNumero);
        numero = intNumero.intValue();
        factorial = 2;
        for (int i = 3; i < (numero+1); i++)
            factorial = factorial*i;
        System.out.print("El factorial de " + numero + " es: " + factorial + "\n");
    }
}
