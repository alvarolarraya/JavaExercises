package supermercado.negocio.ProductoFinal;

import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.Reloj;
import supermercado.negocio.Trafico;
import supermercado.presentacion.PresentadorProductoFinal;
import supermercado.presentacion.VistaCuartaEntrega;

public class SimuladorProductoFinal {
    public final int numCajas = 10;
    public EstadoZonaCobro miEstadoZonaCobro;
    public Reloj miReloj;
    public ControladorProductoFinal miCont;
    public VistaCuartaEntrega vista;
    private int tiempoSimulacion;
    public SimuladorProductoFinal()
    {
        miEstadoZonaCobro = new EstadoZonaCobro(numCajas);
        this.vista = new VistaCuartaEntrega(numCajas);
        miReloj = new Reloj();
        tiempoSimulacion = vista.obtenerTiempoSimulacion();
        miCont = new ControladorProductoFinal(miReloj,new Trafico(vista.obtenerTiempoMedioLLegadaCarritos()),new ZonaCobroProductoFinal(numCajas),vista.obtenerMediaPrecioPorProducto(),vista.obtenerMediaProductosPorCarro());
        new PresentadorProductoFinal(vista,miReloj,miCont,miEstadoZonaCobro).ejecutarSimulador(tiempoSimulacion);
    }
    public static void main(String[] args){
        new SimuladorProductoFinal();
    }
}
