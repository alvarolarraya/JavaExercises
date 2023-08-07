package supermercado.negocio.SegundaEntrega;

import supermercado.negocio.PrimeraEntrega.ControladorPrimeraEntrega;
import supermercado.negocio.Reloj;
import supermercado.negocio.SegundaEntrega.CarritoSegundaEntrega;
import supermercado.negocio.Trafico;
import supermercado.negocio.ZonaCobro;

public class ControladorSegundaEntrega extends ControladorPrimeraEntrega{
    private int mediaPrecioProductos;
    private int mediaProductosPorCarro;
    public ControladorSegundaEntrega(Reloj r,Trafico trafico,ZonaCobro zonaCobro,int mediaPrecioProductos,int mediaProductosPorCarro)
    {
        super(r,trafico,zonaCobro);
        this.mediaPrecioProductos = mediaPrecioProductos;
        this.mediaProductosPorCarro = mediaProductosPorCarro;
    }
    public void LlegaCarrito(Reloj r)
    {
        if (r.tiempoAhora() == miTrafico.getProximaLlegada())
        {
            miZonaCobro.guardarCola(miZonaCobro.eligeCaja(), r,new CarritoSegundaEntrega(mediaPrecioProductos,mediaProductosPorCarro));
            miTrafico.proximaLlegada(r);
        }
        if(r.tiempoAhora()%3600 == 0)
        {
            miZonaCobro.guardarTamanioColas((r.tiempoAhora()/3600)-1);
            tamanioColas = miZonaCobro.getTamanioColas();
        }
    }
}
