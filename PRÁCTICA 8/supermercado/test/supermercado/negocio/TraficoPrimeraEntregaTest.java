package supermercado.negocio;

import supermercado.negocio.PrimeraEntrega.TraficoPrimeraEntrega;
import org.junit.Test;
import static org.junit.Assert.*;

public class TraficoPrimeraEntregaTest {
    @Test
    public void TraficoPrimeraEntregaDevuelveSiempreProximaLLegada60Segundos() {
        //Dado un trafico de la primera entrega
        TraficoPrimeraEntrega trafico = new TraficoPrimeraEntrega();
        Reloj reloj = new Reloj();
        //Cuando calculo la proxima llegada
        trafico.proximaLLegada(reloj);
        //Entonces siempre devuelve un minuto mas que el momento actual
        assertTrue(trafico.getProximaLlegada() == 60);
        
    }
    
}
