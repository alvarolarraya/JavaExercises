package supermercado.negocio.PrimeraEntrega;

import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.PrimeraEntrega.ControladorPrimeraEntrega;
import supermercado.negocio.Reloj;
import supermercado.presentacion.PresentadorPrimeraEntrega;
import supermercado.presentacion.VistaPrimeraEntrega;

public class SimuladorPrimeraEntrega {
    public final int numCajas = 1;
    public EstadoZonaCobro miEstadoZonaCobro;
    public Reloj miReloj;
    public ControladorPrimeraEntrega miCont;
    public VistaPrimeraEntrega vista;
    private int tiempoSimulacion;
    public SimuladorPrimeraEntrega()
    {
        miEstadoZonaCobro = new EstadoZonaCobro(numCajas);
        this.vista = new VistaPrimeraEntrega(numCajas);
        miReloj = new Reloj();
        tiempoSimulacion = vista.obtenerTiempoSimulacion();
        miCont = new ControladorPrimeraEntrega(miReloj,new TraficoPrimeraEntrega(),new ZonaCobroPrimeraEntrega(numCajas));
        new PresentadorPrimeraEntrega(vista,miReloj,miCont,miEstadoZonaCobro).ejecutarSimulador(tiempoSimulacion);
    }
    public static void main(String[] args){
        SimuladorPrimeraEntrega simulador = new SimuladorPrimeraEntrega();
    }
}
