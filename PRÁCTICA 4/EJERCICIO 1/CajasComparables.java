import java.util.Scanner;
public abstract class CajasComparables implements Comparable
{
    public static void main(String[] args)
    {
        double longitud,altura,anchura,volumen;
        int comparacion;
        Scanner scan = new Scanner(System.in);
        System.out.println("Este programa compara el volumen de una caja con otra");
        
        //PRIMERA CAJA
        System.out.println("\tVamos con la primera caja:");
        System.out.print("\t\t¿Cual es la longitud de la caja?: ");
        longitud = scan.nextDouble();
        System.out.print("\t\t¿Y la anchura?: ");
        anchura = scan.nextDouble();
        System.out.print("\t\t¿Que altura tiene?: ");
        altura = scan.nextDouble();
        CajaComparable caja1 = new CajaComparable(longitud,anchura,altura);
        volumen = caja1.calcularVolumen();
        System.out.println("\t El volumen de la caja 1 es: "+volumen);
        
        //SEGUNDA CAJA
        System.out.println("\tVamos con la segunda caja:");
        System.out.print("\t\t¿Cual es la longitud de la caja?: ");
        longitud = scan.nextDouble();
        System.out.print("\t\t¿Y la anchura?: ");
        anchura = scan.nextDouble();
        System.out.print("\t\t¿Que altura tiene?: ");
        altura = scan.nextDouble();
        CajaComparable caja2 = new CajaComparable(longitud,anchura,altura);
        volumen = caja2.calcularVolumen();
        System.out.println("\t El volumen de la caja 2 es: "+volumen);
        
        //COMPARAMOS
        comparacion = caja1.esMasGrandeQue(caja2);
        if(comparacion == MASGRANDEQUE)
            System.out.println("La caja 1 es mas grande");
        else if(comparacion == IGUALQUE)
            System.out.println("Las dos cajas son iguales");
        else if(comparacion == MASPEQUENIOQUE)
            System.out.println("La caja 2 es mas grande");
    }
}
