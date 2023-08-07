package supermercado.presentacion;

public class VistaSegundaEntrega extends VistaPrimeraEntrega{
    public VistaSegundaEntrega(int numCajas)
    {
        super(numCajas);
    }
    public int obtenerMediaProductosPorCarro()
    {
        System.out.print("¿Cual va a ser la media de productos por carrito?: ");
        return scan.nextInt();
    }
    public int obtenerMediaPrecioPorProducto()
    {
        System.out.print("¿Cual va a ser la media de precios por producto?: ");
        return scan.nextInt();
    }
}
