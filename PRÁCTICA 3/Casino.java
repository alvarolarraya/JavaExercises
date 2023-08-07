import java.util.Scanner;
public class Casino
{
    public static void main (String[] args)
    {
        String nombre1,nombre2,quierenOtra;
        Scanner scan = new Scanner(System.in);
        System.out.println("Este programa simula una partida de un juego de dos jugadores en el que hay 5 turnos. El que gana mas turnos, gana la partida. Cada jugador lanza dos dados por turno y suma los valores, el jugador con una suma mas alta gana el turno (si hay empate se repite el turno). Hay una excepcion: que un jugador saque dos unos, lo que llamamos ojos de tigre, en cuyo caso, siempre que no haya un empate, el jugador que hace ojos de tigre gana directamente.");
        System.out.println("Al usar un dado trucado solo pueden salir unos");
        System.out.println("\n\n");
        System.out.print("Jugador 1, ¿Como te llamas?: ");
        nombre1 = scan.nextLine();
        System.out.print("Jugador 2, ¿Como te llamas?: ");
        nombre2 = scan.nextLine();
        do
        {
            Partida p = new Partida();
            int numeroTurno,turnosGanados1 = 0,turnosGanados2 = 0;
            for (numeroTurno = 0; numeroTurno < 5; numeroTurno++)
            {
                System.out.println("TURNO "+(numeroTurno+1)+":");
                p.juegaTurno(numeroTurno,nombre1,nombre2);
                p.ojosDeTigre(numeroTurno);
                while (p.partida[numeroTurno].empate)
                {
                    System.out.println(" Ha habido un empate, se repite el turno");
                    p.juegaTurno(numeroTurno,nombre1,nombre2);
                    p.ojosDeTigre(numeroTurno);
                }
                if (p.hayGanadorPrematuro)
                {
                    if (p.ganaJugador1)
                        System.out.println(nombre1+" gana la partida por ojos de tigre");
                    else
                        System.out.println(nombre2+" gana la partida por ojos de tigre");
                    break;
                }
                else
                {
                    p.ganaTurno(numeroTurno);
                    if(p.turnoJugador1)
                    {
                        System.out.println(" "+nombre1+" gana el " +(numeroTurno+1)+ " turno");
                        System.out.println();
                        turnosGanados1++;
                    }
                    else
                    {
                        System.out.println(" "+nombre2+" gana el " +(numeroTurno+1)+ " turno");
                        System.out.println();
                        turnosGanados2++;
                    }
                }
            }
            if(!p.hayGanadorPrematuro)
            {
                if (turnosGanados1 > turnosGanados2)
                    System.out.println(nombre1+" has ganado la partida, enhorabuena");
                else
                    System.out.println(nombre2+" has ganado la partida, enhorabuena");
            }
            System.out.println("¿Quereis jugar otra partida?(s/n): ");
            quierenOtra = scan.nextLine();
        }while(quierenOtra.equals("s") || quierenOtra.equals("S"));
    }
}
