package supermercado.negocio;

import supermercado.negocio.PrimeraEntrega.ZonaCobroPrimeraEntrega;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZonaCobroPrimeraEntregaTest {
    @Test
    public void ZonaCobroPrimeraEntregaEligeSiemprePrimeraCaja() {
        //Dada una zona cobro de la primera entrega
        ZonaCobroPrimeraEntrega zona = new ZonaCobroPrimeraEntrega(1);
        //Cuando voy a elegir caja
        //Entonces siempre me devuelve la primera caja
        assertTrue(zona.eligeCaja() == 0);
    }
    
}
