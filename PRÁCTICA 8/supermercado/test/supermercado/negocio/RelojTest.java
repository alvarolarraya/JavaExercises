package supermercado.negocio;

import org.junit.Test;
import static org.junit.Assert.*;

public class RelojTest {
    @Test
    public void testClase() {
        //Dado un nuevo reloj puesto a cero
        Reloj reloj = new Reloj();
        reloj.aCero();
        //Cuando aumento un segundo el reloj
        reloj.tic();
        //Entonces debe devolver 1 segundo
        assertTrue(reloj.tiempoAhora() == 1);
    }
}
