package supermercado.negocio.PrimeraEntrega;

import supermercado.negocio.Reloj;
import supermercado.negocio.Trafico;

public class TraficoPrimeraEntrega extends Trafico{
    public TraficoPrimeraEntrega() {
        super(60);
    }
    public void proximaLLegada(Reloj reloj){
        tLlegada = reloj.tiempoAhora()+this.tMedio;
    }
}
