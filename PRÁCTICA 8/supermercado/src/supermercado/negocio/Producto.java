package supermercado.negocio;

public class Producto {
    private int precio;
    public Producto(int mediaPrecioProductos)
    {
        precio = (int)(1-mediaPrecioProductos*Math.log(1-Math.random()));
    }
    public int getPrecioProducto()
    {
        return precio;
    }
}
