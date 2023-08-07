public class Caja
{
    // Listado de propiedades
    private double largo;
    private double ancho;
    private double alto;
    private int estado;

    // Constructor
    public Caja (double longitud, double anchura, double altura)
    {
        largo = longitud;
        ancho = anchura;
        alto = altura;
        estado = 0;
        // representa cerrada
    }
    // Metodos
    public void abrirCaja()
    {
        estado = 1; //representa abierta
    }
    public void cerrarCaja()
    {
            estado = 0;     //representa cerrada
    }
    public double calcularVolumen()
    {
        return largo*ancho*alto;
    }
}
