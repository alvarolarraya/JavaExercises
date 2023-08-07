package supermercado.negocio.PrimeraEntrega;

import supermercado.negocio.PrimeraEntrega.CarritoPrimeraEntrega;
import java.util.Scanner;
import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.Reloj;
import supermercado.negocio.Trafico;
import supermercado.negocio.ZonaCobro;

public class ControladorPrimeraEntrega {
    public Trafico miTrafico;
    public ZonaCobro miZonaCobro;
    public int[] tamanioColas;
    public ControladorPrimeraEntrega(Reloj r,Trafico trafico,ZonaCobro zonaCobro){
        miZonaCobro = zonaCobro;
        miTrafico = trafico;
        miTrafico.proximaLlegada(r);
    }
    public void LlegaCarrito(Reloj r){
        if (r.tiempoAhora() == miTrafico.getProximaLlegada()) {
            CarritoPrimeraEntrega carrito = new CarritoPrimeraEntrega();
            miZonaCobro.guardarCola(miZonaCobro.eligeCaja(), r,carrito);
            miTrafico.proximaLlegada(r);
        }
        if(r.tiempoAhora()%3600 == 0)
        {
            miZonaCobro.guardarTamanioColas((r.tiempoAhora()/3600)-1);
            tamanioColas = miZonaCobro.getTamanioColas();
        }
    }
    public int[] getTamanioColas()
    {
        return tamanioColas;
    }
    public EstadoZonaCobro estadoZonaCobro(Reloj r,EstadoZonaCobro estadoZonaCobro){
        estadoZonaCobro = miZonaCobro.estado(r,estadoZonaCobro);
        return estadoZonaCobro;
    }
    public void marchaCarrito(Reloj r){
        miZonaCobro.rondaCajas(r);
    }
}
