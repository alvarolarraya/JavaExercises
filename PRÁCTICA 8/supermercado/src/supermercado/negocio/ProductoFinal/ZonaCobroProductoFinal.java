package supermercado.negocio.ProductoFinal;

import java.util.ArrayList;
import supermercado.negocio.Orden;
import supermercado.negocio.ZonaCobro;

public class ZonaCobroProductoFinal extends ZonaCobro{
    private int cerradas[];
    public ZonaCobroProductoFinal(int numCajas)
    {
        super(numCajas);
        cerradas = new int[1];
        cerradas[0] = -1;
    }
    public int eligeCaja(){
        int numCajasAbiertas = 0;
        miOrden = new ArrayList<Orden>();
        for (int i = 0; i < numCajas; i++)
        {
            if(!estaEnElArray(i,cerradas))
            {
                miOrden.add(new Orden(i, misCajas.get(i).getNCarritos()));
                numCajasAbiertas++;
            }
        }
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
            return miOrden.get((int)(Math.random()*numCajasAbiertas)).caja;
    }
    public boolean estaEnElArray(int numero,int[] array)
    {
        int i = 0;
        while(i < array.length && numero != array[i])
        {
            i++;
        }
        return(i != array.length);
    }
    public void actualizarCajasCerradas(int[] cerradas)
    {
        //en este metodo realmaceno las cajas que esten cerradas, si estaba cerrada y la han abierto no la vuelvo a escribir
        //si estaba cerrada y no la han abierto la dejo cerrada
        //si estaba abierta y la han cerrado la incluyo en las cajas cerradas
        int cuantasCerradas = 0;
        int antiguasCerradas[];
        antiguasCerradas = this.cerradas;
        for(int i = 0;i<antiguasCerradas.length;i++)
        {
            if(!estaEnElArray(antiguasCerradas[i],cerradas))
                cuantasCerradas++;
        }
        for(int i = 0;i<cerradas.length;i++)
        {
            if(!estaEnElArray(cerradas[i],antiguasCerradas))
                cuantasCerradas++;
        }
        this.cerradas = new int[cuantasCerradas];
        int i = 0,j = 0;
        while(i<antiguasCerradas.length)
        {
            if(estaEnElArray(antiguasCerradas[i],cerradas))
                i++;
            else
            {
                this.cerradas[j] = antiguasCerradas[i];
                j++;
                i++;
            }
        }
        i = 0;
        while(j<cuantasCerradas)
        {
            if(estaEnElArray(cerradas[i],antiguasCerradas))
                i++;
            else
            {
                this.cerradas[j] = cerradas[i];
                j++;
                i++;
            }
        }
    }
    public int[] getCerradasAhora()
    {
        return cerradas;
    }
}
