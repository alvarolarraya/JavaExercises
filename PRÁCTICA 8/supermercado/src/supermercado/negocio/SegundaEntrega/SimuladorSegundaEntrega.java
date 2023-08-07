package supermercado.negocio.SegundaEntrega;

import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.Reloj;
import supermercado.negocio.SegundaEntrega.ControladorSegundaEntrega;
import supermercado.negocio.PrimeraEntrega.TraficoPrimeraEntrega;
import supermercado.negocio.PrimeraEntrega.ZonaCobroPrimeraEntrega;
import supermercado.presentacion.PresentadorSegundaEntrega;
import supermercado.presentacion.VistaSegundaEntrega;

public class SimuladorSegundaEntrega {
    public final int numCajas = 1;
    public EstadoZonaCobro miEstadoZonaCobro;
    public Reloj miReloj;
    public ControladorSegundaEntrega miCont;
    public VistaSegundaEntrega vista;
    private int tiempoSimulacion;
    public SimuladorSegundaEntrega()
    {
        miEstadoZonaCobro = new EstadoZonaCobro(numCajas);
        this.vista = new VistaSegundaEntrega(numCajas);
        miReloj = new Reloj();
        tiempoSimulacion = vista.obtenerTiempoSimulacion();
        miCont = new ControladorSegundaEntrega(miReloj,new TraficoPrimeraEntrega(),new ZonaCobroPrimeraEntrega(numCajas),vista.obtenerMediaPrecioPorProducto(),vista.obtenerMediaProductosPorCarro());
        new PresentadorSegundaEntrega(vista,miReloj,miCont,miEstadoZonaCobro).ejecutarSimulador(tiempoSimulacion);
    }
    public static void main(String[] args){
        new SimuladorSegundaEntrega();
    }
}
