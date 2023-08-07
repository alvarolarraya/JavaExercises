package supermercado.negocio;

public class Carrito {
    private int tiempoEntradaPeaje;
    public int sumaPrecioProductos;
    public int cuantosProductos;
    public void setTiempoEntradaPeaje (int tiempoAhora) {
        tiempoEntradaPeaje = tiempoAhora;
    }
    public int tiempoEntradaPeaje(){
        return tiempoEntradaPeaje;
    }
    public int getSumaPrecios()
    {
        return sumaPrecioProductos;
    }
    public int getCuantosProductos()
    {
        return cuantosProductos;
    }
}
