package supermercado.negocio.SegundaEntrega;

import supermercado.negocio.Carrito;
import supermercado.negocio.Producto;

public class CarritoSegundaEntrega extends Carrito{
    private Producto[] productos;
    private int mediaPrecioProductos;
    private int mediaProductosPorCarro;
    public CarritoSegundaEntrega(int mediaPrecioProductos,int mediaProductosPorCarro)
    {
        this.mediaPrecioProductos = mediaPrecioProductos;
        this.mediaProductosPorCarro = mediaProductosPorCarro;
        obtenerNumeroProductos();
        productos = new Producto[cuantosProductos];
        for(int i = 0; i < cuantosProductos; i++)
        {
            productos[i] = new Producto(mediaPrecioProductos);
        }
        obtenerPrecioTotalCarro();
    }
    private void obtenerNumeroProductos()
    {
        cuantosProductos = (int)(1-mediaProductosPorCarro*Math.log(1-Math.random()));
    }
    private void obtenerPrecioTotalCarro()
    {
        sumaPrecioProductos = 0;
        for(int i = 0; i < cuantosProductos; i++)
        {
            sumaPrecioProductos += productos[i].getPrecioProducto();
        }
    }
}
