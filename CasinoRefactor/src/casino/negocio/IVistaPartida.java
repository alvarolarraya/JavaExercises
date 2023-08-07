package casino.negocio;

/**
 *
 * @author roberto
 */
public interface IVistaPartida{
    
    String obtenerNombreJugador();
    void comienzaPartida();
    void comienzaTurno(int numeroTurno);
    void empate();
    void ganaJugador(String nombreJugador);
    void mostrarResultado(String nombreJugador, ResultadoJuego resultado);
    void ganadorPartida(String nombreGanador);
}
