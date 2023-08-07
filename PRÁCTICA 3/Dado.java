/*package dado;*/
public class Dado
{   
    private int resultado;
    //Constructor
    public Dado()
    {
        resultado = (int)(java.lang.Math.random()*6) + 1;
    }
    public int mostrarResultado()
    {
        return resultado;
    }
}
