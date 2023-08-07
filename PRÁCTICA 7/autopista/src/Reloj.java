public class Reloj {
    private int tiempo;
    public void Reloj()
    {
        tiempo = 0;
    }
    public void tic()
    {
        tiempo++;
    }
    public int tiempoAhora()
    {
        return tiempo;
    }
}