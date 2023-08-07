package casino.test;

import casino.negocio.Dado;
import casino.negocio.Jugador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto
 */
public class JugadorTest {
    
    public JugadorTest() {
    }

    @Test
    public void testJuega() {
        Jugador jugador = new Jugador(new Dado());
        assertTrue(jugador.resultado().puntuacion() == 0);
        jugador.juega();
        assertTrue(jugador.resultado().puntuacion()>0);
    }
    
    @Test
    public void testJuegaOjosDeTigre() {
        Jugador jugador = new Jugador(new DadoFalso(1));
        assertTrue(jugador.resultado().puntuacion() == 0);
        jugador.juega();
        assertTrue(jugador.resultado().puntuacion() == 2);
        assertTrue(jugador.resultado().esOjosDeTigre());
    }
    
    @Test
    public void testJuegaDosVecesDos() {
        Jugador jugador = new Jugador(new DadoFalso(2));
        assertTrue(jugador.resultado().puntuacion() == 0);
        jugador.juega();
        assertTrue(jugador.resultado().puntuacion() == 4);
        assertFalse(jugador.resultado().esOjosDeTigre());
    }
    
     @Test
    public void testJuegaPrimeraTiradaCincoSegundaTirada2() {
        Jugador jugador = new Jugador(new DadoTrucado(new int[]{5,2}));
        assertTrue(jugador.resultado().puntuacion() == 0);
        jugador.juega();
        assertTrue(jugador.resultado().puntuacion() == 7);
        assertFalse(jugador.resultado().esOjosDeTigre());
    }


}
