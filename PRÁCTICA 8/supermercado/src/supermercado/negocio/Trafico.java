package supermercado.negocio;

public class Trafico {
    public final int tMedio;
    public int tLlegada;
    public Trafico(int tiempo){
         tMedio = tiempo;
    }
    public int getProximaLlegada(){
        return tLlegada;
    }
    public void proximaLlegada(Reloj r){
        tLlegada = (int)(r.tiempoAhora()+1-tMedio*Math.log(1-Math.random()));
    }
}
