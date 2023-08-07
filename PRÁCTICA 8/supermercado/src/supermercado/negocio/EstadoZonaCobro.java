package supermercado.negocio;

import java.util.Queue;

public class EstadoZonaCobro {
    private int cuantasCajas;
    private int tiempoMedioEsperaPorCaja[];
    private int maximoNumeroCarritosPorCaja[];
    private int numeroProductosPorCaja[];
    private int ventasPorCaja[];
    private int tiempoMedioEsperado;
    private int totalClientesServidos;
    private int totalProductosCobrados;
    private int totalVentas;
    public EstadoZonaCobro(int numCajas)
    {
        cuantasCajas = numCajas;
        tiempoMedioEsperaPorCaja = new int[numCajas];
        maximoNumeroCarritosPorCaja = new int[numCajas];
        numeroProductosPorCaja = new int[numCajas];
        ventasPorCaja = new int[numCajas];
    }
    public void setTiempoMedioEsperadoCaja(int[] tiemposMediosEspera)
    {
        tiempoMedioEsperaPorCaja = tiemposMediosEspera;
    }
    public void setMaximoNumeroCarritosPorCaja(int[] maximos)
    {
        maximoNumeroCarritosPorCaja = maximos;
    }  
    public void setNumeroProductosPorCaja(int[] numeroProductosPorCaja)
    {
        this.numeroProductosPorCaja = numeroProductosPorCaja;
    }
    public void setVentasPorCaja(int[] ventasPorCaja)
    {
        this.ventasPorCaja = ventasPorCaja;
    }
    public void setTiempoMedioEsperado(int tiempoMedioEsperado)
    {
        this.tiempoMedioEsperado = tiempoMedioEsperado;
    }
    public void setTotalClientesServidos(int totalClientesServidos)
    {
        this.totalClientesServidos = totalClientesServidos;
    }
    public void setTotalProductosCobrados(int totalProductosCobrados)
    {
        this.totalProductosCobrados = totalProductosCobrados;
    }
    public void setTotalVentas(int totalVentas)
    {
        this.totalVentas = totalVentas;
    }
    public int[] getTiempoMedioEsperadoCaja()
    {
        return tiempoMedioEsperaPorCaja;
    }
    public int[] getMaximoNumeroCarritosPorCaja()
    {
        return maximoNumeroCarritosPorCaja;
    }
    public int[] getNumeroProductosPorCaja()
    {
        return numeroProductosPorCaja;
    }
    public int[] getVentasPorCaja()
    {
        return ventasPorCaja;
    }
    public int getTiempoMedioEsperado()
    {
        return tiempoMedioEsperado;
    }
    public int getTotalClientesServidos()
    {
        return totalClientesServidos;
    }
    public int getTotalProductosCobrados()
    {
        return totalProductosCobrados;
    }
    public int getTotalVentas()
    {
        return totalVentas;
    }
}
