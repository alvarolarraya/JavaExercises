public class DadoBueno implements Dado
{
    private int resultado;
    public void lanzar()
    {
        resultado = (int)(java.lang.Math.random()*6) + 1;
    }
    public int getValor()
    {
        return resultado;
    }
}
