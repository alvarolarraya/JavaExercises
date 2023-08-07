package supermercado.negocio.ProductoFinal;

import supermercado.negocio.Reloj;
import supermercado.negocio.SegundaEntrega.ControladorSegundaEntrega;
import supermercado.negocio.Trafico;
import supermercado.negocio.ZonaCobro;

public class ControladorProductoFinal extends ControladorSegundaEntrega{
    ZonaCobroProductoFinal miZonaCobro;
    public ControladorProductoFinal(Reloj r,Trafico trafico,ZonaCobroProductoFinal zonaCobro,int mediaPrecioProductos,int mediaProductosPorCarro)
    {
        super(r,trafico,zonaCobro,mediaPrecioProductos,mediaProductosPorCarro);
        miZonaCobro = zonaCobro;
    }
    public void cerrarCajas(int[] cerradas)
    {
        miZonaCobro.actualizarCajasCerradas(cerradas);
    }
    public int[] cerradasAhora()
    {
        return miZonaCobro.getCerradasAhora();
    }
}
