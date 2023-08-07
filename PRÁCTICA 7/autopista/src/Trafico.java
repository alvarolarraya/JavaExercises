public class Trafico {
    private int tLlegada;
    public int tMedio;
    public Trafico(int tiempoMedioLLegadaCoches)
    {
        tMedio = tiempoMedioLLegadaCoches;
    }
    public void proximaLlegada(Reloj reloj)
    {
        tLlegada = (int)(reloj.tiempoAhora()+1-tMedio*Math.log(1-Math.random()));
    }
    public int getProximaLlegada()
    {
        return tLlegada;
    }
}