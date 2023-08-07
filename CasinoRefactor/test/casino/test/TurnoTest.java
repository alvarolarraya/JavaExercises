package casino.test;

import casino.negocio.Jugador;
import casino.negocio.Turno;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto
 */
public class TurnoTest {
    
    public TurnoTest() {
    }

    @Test
    public void testDosYCincoGanaAUnoYCuatro() {
        Turno turno = new Turno(
                new Jugador(new DadoTrucado(new int[]{2,5})), 
                new Jugador(new DadoTrucado(new int[]{1,4}))
        );
        turno.Jugador1.darNombre("A");
        turno.Jugador2.darNombre("B");
        turno.jugar();
        assertEquals(turno.ganador().nombre(),"A");
    }
    
    @Test
    public void testUnoYUnoGanaAUnoYCuatro() {
        Turno turno = new Turno(
                new Jugador(new DadoTrucado(new int[]{1,1})), 
                new Jugador(new DadoTrucado(new int[]{1,4}))
        );
        turno.Jugador1.darNombre("A");
        turno.Jugador2.darNombre("B");
        turno.jugar();
        assertEquals(turno.ganador().nombre(),"A");
        assertTrue(turno.GanadoConOjosDeTigre());
    }
    
    @Test
    public void testUnoYCuatroEmpataContraDosYTres() {
        Turno turno = new Turno(
                new Jugador(new DadoTrucado(new int[]{1,4})), 
                new Jugador(new DadoTrucado(new int[]{2,3}))
        );
        turno.Jugador1.darNombre("A");
        turno.Jugador2.darNombre("B");
        turno.jugar();
        assertTrue(turno.ganador() == null);
    }
    
    @Test
    public void testDosOjosDeTigreEsEmpate() {
        Turno turno = new Turno(
                new Jugador(new DadoTrucado(new int[]{1,1})), 
                new Jugador(new DadoTrucado(new int[]{1,1}))
        );
        turno.Jugador1.darNombre("A");
        turno.Jugador2.darNombre("B");
        turno.jugar();
        assertTrue(turno.ganador() == null);
        assertFalse(turno.GanadoConOjosDeTigre());
    }

    
}
