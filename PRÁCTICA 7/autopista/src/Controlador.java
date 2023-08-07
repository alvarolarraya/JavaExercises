import java.util.Scanner;

public class Controlador {
    public int estaciones;
    public Trafico miTrafico;
    public Peaje miPeaje;
    public Controlador(Reloj reloj)
    {
        miPeaje = new Peaje(estaciones);
        Scanner scan = new Scanner(System.in);
        System.out.println("¿Cuál es el tiempo medio de llegada de los coches?");
        int tiempoMedioLlegadaCoches = scan.nextInt();
        miTrafico = new Trafico(tiempoMedioLlegadaCoches);
        int segundosProximaLlegada = miTrafico.getProximaLlegada();
    }
    public void llegaCoche(Reloj reloj)
    {
        if (reloj.tiempoAhora() == miTrafico.getProximaLlegada())
        {
            int aQueCabina = miPeaje.eligeCabina();
            miPeaje.guardarCola(aQueCabina, reloj);
            miTrafico.proximaLlegada(reloj);
        }
    }
    public void marchaCoche(Reloj reloj)
    {
        miPeaje.rondaCabinas(reloj);
    }
    public void estadoPeaje()
    {
        miPeaje.estado();
    }
}