package supermercado.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ZonaCobro {
    private final int [][] tipoCobro = {
        {2,10},
        {2,10},
        {2,10},
        {2,10},
        {2,10},
        {3,20},
        {3,20},
        {3,20},
        {3,20},
        {3,20}};
    public int numCajas;
    public ArrayList<Caja> misCajas;
    public ArrayList<Orden> miOrden;
    private int tiempoMedioEsperaPorCaja[];
    private int maximoNumeroCarritosPorCaja[];
    private int numeroProductosPorCaja[];
    private int ventasPorCaja[];
    private int tamanioColas[];
    public ZonaCobro(int numCajas){
        tamanioColas = new int[numCajas];
        tiempoMedioEsperaPorCaja = new int[numCajas];
        maximoNumeroCarritosPorCaja = new int[numCajas];
        numeroProductosPorCaja = new int[numCajas];
        ventasPorCaja = new int[numCajas];
        misCajas = new ArrayList<Caja>(); 
        this.numCajas = numCajas;
        for (int i = 0; i < numCajas; i++)
             misCajas.add(new Caja(tipoCobro[i][0], tipoCobro[i][1]));
    }
    public void guardarTamanioColas(int queHora)
    {
        for(int i = 0; i < numCajas; i++)
            tamanioColas[i] = misCajas.get(i).getNCarritos();
    }
    public void guardarCola(int nCab, Reloj myReloj,Carrito carrito){
        Caja miCaja = (Caja)misCajas.get(nCab);
        miCaja.encolarCarrito(myReloj,carrito);
    }
    public void ordenar(ArrayList<Orden> miOrden){
        Collections.sort(miOrden,new Comparator<Orden>(){
            @Override
            public int compare(Orden o1, Orden o2){
                return new Integer(o1.carritos).compareTo(o2.carritos);
            }
        });
    }
    public int[] getTamanioColas()
    {
        return tamanioColas;
    }
    public int eligeCaja(){
        miOrden = new ArrayList<Orden>();
        for (int i = 0; i < numCajas; i++)
            miOrden.add(new Orden(i, misCajas.get(i).getNCarritos()));
        ordenar(miOrden);
        final double [] elec = {0.5, 0.8, 0.9,1.0};
        double x = Math.random();
        int n = 0;
        while ((elec[n]<x) && (n<3)){
            n++;
        }
        if(n>=0 && n<3)
            return miOrden.get(n).caja;
        else
            return miOrden.get((int)(Math.random()*10)).caja;
    }
    public void rondaCajas(Reloj miOrloj){
        for (Caja i:misCajas){
            i.servirCaja(miOrloj);
        }
    }
    public EstadoZonaCobro estado(Reloj reloj, EstadoZonaCobro estadoZonaCobro){
        int tiempoMedioEsperado = 0,totalClientesServidos = 0,totalProductosCobrados = 0,totalVentas = 0;
        for(int i = 0; i < numCajas; i++)
        {
            if(misCajas.get(i).getServidos() != 0)
                tiempoMedioEsperado += misCajas.get(i).getTotalEsperado()/misCajas.get(i).getServidos();
            totalClientesServidos += misCajas.get(i).getServidos();
            totalProductosCobrados += misCajas.get(i).getProductosCobrados();
            totalVentas += misCajas.get(i).getVentas();
            if(misCajas.get(i).getServidos() != 0)
                tiempoMedioEsperaPorCaja[i] = misCajas.get(i).getTotalEsperado()/misCajas.get(i).getServidos();
            else
                tiempoMedioEsperaPorCaja[i] = 0;
            maximoNumeroCarritosPorCaja[i] = misCajas.get(i).getMaxCarritos();
            numeroProductosPorCaja[i] = misCajas.get(i).getProductosCobrados();
            ventasPorCaja[i] = misCajas.get(i).getVentas();
        }
        tiempoMedioEsperado = tiempoMedioEsperado/numCajas;
        estadoZonaCobro.setTiempoMedioEsperadoCaja(tiempoMedioEsperaPorCaja);
        estadoZonaCobro.setMaximoNumeroCarritosPorCaja(maximoNumeroCarritosPorCaja);
        estadoZonaCobro.setNumeroProductosPorCaja(numeroProductosPorCaja);
        estadoZonaCobro.setVentasPorCaja(ventasPorCaja);
        estadoZonaCobro.setTiempoMedioEsperado(tiempoMedioEsperado);
        estadoZonaCobro.setTotalClientesServidos(totalClientesServidos);
        estadoZonaCobro.setTotalProductosCobrados(totalProductosCobrados);
        estadoZonaCobro.setTotalVentas(totalVentas);
        return estadoZonaCobro;
    }
}
