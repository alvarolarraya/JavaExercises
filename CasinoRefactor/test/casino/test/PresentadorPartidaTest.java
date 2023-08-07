package casino.test;

import casino.negocio.Dado;
import casino.negocio.Jugador;
import casino.presentacion.PresentadorPartida;
import casino.negocio.Turno;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto
 */
public class PresentadorPartidaTest {
    
    public PresentadorPartidaTest() {
    }

    @Test
    public void testAceptacion() {
        
        VistaPartidaFalsa vistaFalsa = new VistaPartidaFalsa("Kepa", "Sevelinda");
        
        PresentadorPartida presentadorPartida = new PresentadorPartida(
                vistaFalsa,
                new Turno(
                        new Jugador(new DadoTrucado(new int[]{3,5,1,1,6,6})), 
                        new Jugador(new DadoTrucado(new int[]{1,2,1,1,1,1})))
        );
        
        presentadorPartida.jugarTurnos();
        
        assertEquals(vistaFalsa.NumeroInvocacionesComienzaPartida, 1);
        assertEquals(vistaFalsa.NumeroInvocacionesComienzaTurno, 3);
        assertEquals(vistaFalsa.NumeroInvocacionesMostrarResultado, 6);
        assertEquals(vistaFalsa.NombreGanador, "Sevelinda");
    }
    
}
