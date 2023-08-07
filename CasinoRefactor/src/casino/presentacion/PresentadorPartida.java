package casino.presentacion;

import casino.negocio.IVistaPartida;
import casino.negocio.Jugador;
import casino.negocio.Turno;

/**
 *
 * @author roberto
 */
public class PresentadorPartida {
    
    private Turno turno;
    private IVistaPartida vista;

    public PresentadorPartida(IVistaPartida vista, Turno turno) {
        this.vista = vista;
        this.turno = turno;
    }
    
    public void jugarTurnos(){
        
        String nombre1 = this.vista.obtenerNombreJugador();
        turno.Jugador1.darNombre(nombre1);
        
        String nombre2 = this.vista.obtenerNombreJugador();
        turno.Jugador2.darNombre(nombre2);

        this.vista.comienzaPartida();
        for(int i=0; i<5; i++){
            this.vista.comienzaTurno(i+1);
            turno.jugar();
            this.vista.mostrarResultado(turno.Jugador1.nombre(), turno.Jugador1.resultado());
            this.vista.mostrarResultado(turno.Jugador2.nombre(), turno.Jugador2.resultado());
            Jugador ganador = turno.ganador();
            if(ganador == null) this.vista.empate();
            else{
                this.vista.ganaJugador(ganador.nombre());
                if(this.turno.GanadoConOjosDeTigre()){
                    this.vista.ganadorPartida(ganador.nombre());
                    return;
                }
            }
        } 
        
        if(turno.Jugador1.victorias()> turno.Jugador2.victorias()){
            this.vista.ganadorPartida(turno.Jugador1.nombre());
        }
        else{
            this.vista.ganadorPartida(turno.Jugador2.nombre());
        }
    }

}
