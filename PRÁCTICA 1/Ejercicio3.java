//import java.lang.Math;
public class Ejercicio3
{
    public static void main(String[] args)
    {
        int dado, suma;
        System.out.println("Este programa simula el lanzamiento de dos dados y saca por pantalla: el valor del primer, segundo lanzamiento y la suma de los dos.");
        dado = (int)(java.lang.Math.random()*6) + 1;
        System.out.println("El lanzamiento del primer dado es " + dado);
        suma = (int)(java.lang.Math.random()*6) + 1;
        System.out.println("El lanzamiento del segundo dado es " + suma);
        suma = suma + dado;
        System.out.println("El total de los dos lanzamientos es " + suma);
    }
}
