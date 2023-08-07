package casino.negocio;

import java.util.Scanner;

/**
 *
 * @author roberto
 */
public class Partida {
    
    private Turno turno;
    private Scanner scan;
    
    public Partida(Turno turno) {
        this.scan = new Scanner(System.in);
        this.turno = turno;
    }

    private String obtenerNombreJugador(){
        System.out.print("Nombre Jugador: ");
        return scan.next();
    }
    
    private void mostrarResultado(String nombreJugador, ResultadoJuego resultado){
        System.out.println("  Juega " + nombreJugador);
        System.out.println("    Primer dado es " + String.valueOf(resultado.valorDado1));
        System.out.println("    Segundo dado es " + String.valueOf(resultado.valorDado2));
        if(resultado.esOjosDeTigre()) { 
                System.out.println("    Enhorabuena, Ojos de Tigre!");
                return;
        }
        System.out.println("  Total: " + String.valueOf(resultado.puntuacion()));
    }
    
    public void jugarTurnos(){
        
        String nombre1 = this.obtenerNombreJugador();
        turno.Jugador1.darNombre(nombre1);
        
        String nombre2 = this.obtenerNombreJugador();
        turno.Jugador2.darNombre(nombre2);
        
        System.out.println("Comienza la partida");
        for(int i=0; i<5; i++){
            System.out.println(" Turno " + String.valueOf(i+1));
            turno.jugar();
            this.mostrarResultado(turno.Jugador1.nombre(), turno.Jugador1.resultado());
            this.mostrarResultado(turno.Jugador2.nombre(), turno.Jugador2.resultado());
            Jugador ganador = turno.ganador();
            if(ganador == null) System.out.println(" Empate!");
            else{
                 System.out.println(" Ha ganado el turno " + ganador.nombre());
                 if(turno.GanadoConOjosDeTigre()){
                    System.out.println("Ganador de la partida: " + ganador.nombre()); 
                    return;
                 }
            }
        } 
        if(turno.Jugador1.victorias()> turno.Jugador2.victorias()){
             System.out.println("Ganador de la partida: " + turno.Jugador1.nombre());
        }
        else{
             System.out.println("Ganador de la partida: " + turno.Jugador2.nombre());
        } 
        
        
    }
    
}
