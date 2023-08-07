package casino.test;

import casino.negocio.ResultadoJuego;
import casino.negocio.eResultado;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto
 */
public class ResultadoJuegoTest {
    
    public ResultadoJuegoTest() {
    }

    @Test
    public void testComparar_suma_menos_pierde() {
        assertEquals(new ResultadoJuego(1,2).Comparar(new ResultadoJuego(1,3)), eResultado.PERDER);
    }
    
    @Test
    public void testComparar_suma_igual_empata() {
        assertEquals(new ResultadoJuego(3,2).Comparar(new ResultadoJuego(4,1)), eResultado.EMPATAR);
    }
    
    @Test
    public void testComparar_suma_mas_gana() {
        assertEquals(new ResultadoJuego(3,4).Comparar(new ResultadoJuego(1,3)), eResultado.GANAR);
    }
    
}
