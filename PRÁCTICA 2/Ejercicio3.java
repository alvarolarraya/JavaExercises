import java.util.Scanner;
public class Ejercicio3{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Indique el numero de lados de la figura que desea visualizar (3 o 4): ");
        int lados = scan.nextInt();
        System.out.print("Introduzca el numero de lineas de la figura: ");
        int lineas = scan.nextInt();
        
        while (lados != 3 && lados != 4){
                System.out.print("El número de lados solo puede tomar valores 3 o 4, pruebe otra vez. ");
                System.out.print("Indique el numero de lados de la figura que desea visualizar (3 o 4): ");
                lados = scan.nextInt();
        }
        System.out.print("La figura es:\n");
        if (lados == 3){
            for (int i = 0; i < lineas; i++){
                for (int k = lineas-i; k > 0; k--)
                {
                    System.out.print(" ");
                }
                for (int j = 0; j < i+1; j++)
                {
                    System.out.print("* ");
                }
                System.out.print("\n");
            }
        }
        else if (lados == 4)
        {
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++)
                {
                    System.out.print("* ");
                }
                System.out.print("\n");
            }
        }
    }
}
