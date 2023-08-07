package supermercado.negocio.TerceraEntrega;

import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.Reloj;
import supermercado.negocio.SegundaEntrega.ControladorSegundaEntrega;
import supermercado.negocio.SegundaEntrega.SimuladorSegundaEntrega;
import supermercado.negocio.Trafico;
import supermercado.negocio.ZonaCobro;
import supermercado.presentacion.PresentadorSegundaEntrega;
import supermercado.presentacion.VistaTerceraEntrega;

public class SimuladorTerceraEntrega {
    public final int numCajas = 10;
    public EstadoZonaCobro miEstadoZonaCobro;
    public Reloj miReloj;
    public ControladorSegundaEntrega miCont;
    public VistaTerceraEntrega vista;
    private int tiempoSimulacion;
    public SimuladorTerceraEntrega()
    {
        miEstadoZonaCobro = new EstadoZonaCobro(numCajas);
        this.vista = new VistaTerceraEntrega(numCajas);
        miReloj = new Reloj();
        tiempoSimulacion = vista.obtenerTiempoSimulacion();
        miCont = new ControladorSegundaEntrega(miReloj,new Trafico(vista.obtenerTiempoMedioLLegadaCarritos()),new ZonaCobro(numCajas),vista.obtenerMediaPrecioPorProducto(),vista.obtenerMediaProductosPorCarro());
        new PresentadorSegundaEntrega(vista,miReloj,miCont,miEstadoZonaCobro).ejecutarSimulador(tiempoSimulacion);
    }
    public static void main(String[] args){
        new SimuladorTerceraEntrega();
    }
}
