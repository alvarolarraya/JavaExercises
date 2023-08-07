package casino.test;

import casino.negocio.IVistaPartida;
import casino.negocio.ResultadoJuego;

/**
 *
 * @author roberto
 */
public class VistaPartidaFalsa implements IVistaPartida {

    private final String nombreJugador1;
    private final String nombreJugador2;
    private int numeroInvocacionesObtenerNombre;
    
    public String NombreGanador;
    public int NumeroInvocacionesComienzaPartida;
    public int NumeroInvocacionesComienzaTurno;
    public int NumeroInvocacionesMostrarResultado;

    public VistaPartidaFalsa(String nombreJugador1, String nombreJugador2) {
       this.nombreJugador1 = nombreJugador1;
       this.nombreJugador2 = nombreJugador2;
       this.numeroInvocacionesObtenerNombre = 0;
       this.NumeroInvocacionesComienzaPartida = 0;
       this.NumeroInvocacionesComienzaTurno = 0;
       this.NumeroInvocacionesMostrarResultado = 0;
       this.NombreGanador = "";
    }
    

    @Override
    public String obtenerNombreJugador() {
        numeroInvocacionesObtenerNombre++;
        if(numeroInvocacionesObtenerNombre == 1){
            return this.nombreJugador1;
        }
        return this.nombreJugador2;
    }

    @Override
    public void comienzaPartida() {
       NumeroInvocacionesComienzaPartida++;
    }

    @Override
    public void comienzaTurno(int numeroTurno) {
       NumeroInvocacionesComienzaTurno++;
    }

    @Override
    public void empate() {
        
    }

    @Override
    public void ganaJugador(String nombreJugador) {
        
    }

    @Override
    public void mostrarResultado(String nombreJugador, ResultadoJuego resultado) {
        NumeroInvocacionesMostrarResultado++;
    }

    @Override
    public void ganadorPartida(String nombreGanador) {
        this.NombreGanador = nombreGanador;
    }
    
}
