package supermercado.negocio;

import supermercado.negocio.PrimeraEntrega.CarritoPrimeraEntrega;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarritoPrimeraEntregaTest {
    @Test
    public void CarritoPrimeraEntregaTieneUnProductoQueCuestaUnEuro() {
        //Dado un carrito de la primera entrega
        //Cuando lo inicializo
        CarritoPrimeraEntrega carrito = new CarritoPrimeraEntrega();
        //Entonces lleva 1 producto que cuesta 1 euro
        assertTrue(carrito.getSumaPrecios() == 1 && carrito.getCuantosProductos() == 1);
    }
    @Test
    public void CarritoEntraEnElSegundo20ZonaCobro()
    {
        //Dado un carrito
        CarritoPrimeraEntrega carrito = new CarritoPrimeraEntrega();
        //Cuando llega en el segundo 20
        carrito.setTiempoEntradaPeaje(20);
        //Entonces el tiempo de entrada debe ser 20
        assertTrue(carrito.tiempoEntradaPeaje() == 20);
    }
}
