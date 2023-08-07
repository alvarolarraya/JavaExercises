package casino.presentacion;

import casino.negocio.IVistaPartida;
import casino.negocio.ResultadoJuego;
import java.util.Scanner;

/**
 *
 * @author roberto
 */
public class VistaPartidaConsola implements IVistaPartida {

    private Scanner scan;
    
    public VistaPartidaConsola() {
        this.scan = new Scanner(System.in);
    }
    
    public String obtenerNombreJugador(){
        System.out.print("Nombre Jugador: ");
        return scan.next();
    }
    
    public void comienzaPartida(){
        System.out.println("Comienza la partida");
    }
    
    public void comienzaTurno(int numeroTurno){
        System.out.println(" Turno " + String.valueOf(numeroTurno));
    }
       
    public void empate(){
        System.out.println(" Empate!");
    }
    
    public void ganaJugador(String nombreJugador){
        System.out.println(" Ha ganado el turno " + nombreJugador);
    }
    
    public void mostrarResultado(String nombreJugador, ResultadoJuego resultado){
        System.out.println("  Juega " + nombreJugador);
        System.out.println("    Primer dado es " + String.valueOf(resultado.valorDado1));
        System.out.println("    Segundo dado es " + String.valueOf(resultado.valorDado2));
        if(resultado.esOjosDeTigre()) { 
                System.out.println("    Enhorabuena, Ojos de Tigre!");
                return;
        }
        System.out.println("  Total: " + String.valueOf(resultado.puntuacion()));
    }
    
    public void ganadorPartida(String nombreGanador){
        System.out.println("Ganador de la partida: " + nombreGanador);
    }
    
}
