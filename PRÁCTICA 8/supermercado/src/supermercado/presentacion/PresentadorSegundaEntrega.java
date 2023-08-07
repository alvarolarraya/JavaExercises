package supermercado.presentacion;

import supermercado.negocio.PrimeraEntrega.ControladorPrimeraEntrega;
import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.Reloj;

public class PresentadorSegundaEntrega extends PresentadorPrimeraEntrega{
    int mediaProductosPorCarro;
    int mediaPrecioPorProducto;
    public PresentadorSegundaEntrega(VistaPrimeraEntrega vista,Reloj reloj, ControladorPrimeraEntrega controlador, EstadoZonaCobro estadoZonaCobro)
    {
        super(vista,reloj,controlador,estadoZonaCobro);
    }
    public void obtenerMediaProductosPorCarro(int mediaProductosPorCarro)
    {
        this.mediaProductosPorCarro = mediaProductosPorCarro;
    }
    public void obtenerMediaPrecioPorProducto(int mediaPrecioPorProducto)
    {
        this.mediaPrecioPorProducto = mediaPrecioPorProducto;
    }
    public void ejecutarSimulador(int tSim)
    {
        obtenerUsuarioTiempoSimulacion(tSim);
        simular();
        obtenerResultados();
        mostrarResultados();
    }
}
