package supermercado.presentacion;

import org.junit.Test;
import static org.junit.Assert.*;
import supermercado.negocio.PrimeraEntrega.ControladorPrimeraEntrega;
import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.Reloj;
import supermercado.negocio.PrimeraEntrega.TraficoPrimeraEntrega;
import supermercado.negocio.PrimeraEntrega.ZonaCobroPrimeraEntrega;

public class PresentadorPrimeraEntregaTest {
    @Test
    public void ventasEnTresHorasEntreCercanasA180Euros() {
        //Dado el presentador de la primera entrega
        final int numCajas = 1;
        EstadoZonaCobro miEstadoZonaCobro;
        Reloj miReloj;
        ControladorPrimeraEntrega miCont;
        VistaPrimeraEntrega vista;
        miEstadoZonaCobro = new EstadoZonaCobro(numCajas);
        vista = new VistaPrimeraEntrega(numCajas);
        miReloj = new Reloj();
        miCont = new ControladorPrimeraEntrega(miReloj,new TraficoPrimeraEntrega(),new ZonaCobroPrimeraEntrega(numCajas));
        PresentadorPrimeraEntrega presentador = new PresentadorPrimeraEntrega(vista,miReloj,miCont,miEstadoZonaCobro);
        //Cuando simulo tres horas
        presentador.ejecutarSimulador(10800);
        presentador.obtenerResultados();
        //Entonces el numero euros recaudados esta entre los 150 y 200 euros
        assertTrue((presentador.miEstadoZonaCobro.getTotalVentas() > 150) && (presentador.miEstadoZonaCobro.getTotalVentas() < 220));
    }
}
