package supermercado.negocio;

public class Reloj {
    private int tiempo;
    public void aCero(){
        tiempo = 0;
    }
    public int tiempoAhora(){
        return tiempo;
    }
    public void tic(){
        tiempo++;
    }
}
