import java.io.*;
public class Ejercicio1
{
    public static void main(String[] args) throws IOException
    {
        int numero, cubo;
        String textoNumero;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduce el numero en estudio: ");
        textoNumero = teclado.readLine();
        Integer intNumero = Integer.valueOf(textoNumero);
        numero = intNumero.intValue();
        cubo = numero*numero*numero;
        System.out.println("El cubo de " + numero + " es "+ cubo);
    }
}
