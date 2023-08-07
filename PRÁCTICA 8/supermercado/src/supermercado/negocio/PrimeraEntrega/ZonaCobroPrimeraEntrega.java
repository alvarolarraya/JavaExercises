package supermercado.negocio.PrimeraEntrega;

import supermercado.negocio.ZonaCobro;

public class ZonaCobroPrimeraEntrega extends ZonaCobro{
    public ZonaCobroPrimeraEntrega(int numCajas)
    {
        super(numCajas);
    }
    public int eligeCaja(){
        return 0;
    }
}
