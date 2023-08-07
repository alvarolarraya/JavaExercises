package supermercado.negocio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Caja {
    private Queue<Carrito> miColaCarritos;
    private int nCarritos;
    private int maxCarritos;
    private int maxServ;
    private int minServ;
    private int servidos;
    private int totalEsperado;
    private int proxServ;
    private int ventas;
    private int productosCobrados;
    public Caja(int minServ, int maxServ){
        miColaCarritos = new LinkedList<Carrito>();
        nCarritos = 0;
        maxCarritos = 0;
        this.maxServ = maxServ;
        this.minServ = minServ;
        servidos = 0;
        totalEsperado = 0;
        proxServ = 0;
    }
    private int proximoCobro(Reloj reloj){
        return (int)(((maxServ - minServ) * Math.random()) + minServ + 
                reloj.tiempoAhora());
    }
    private void contarCarrito(Reloj reloj){
        if (nCarritos == 0)
            proxServ = proximoCobro(reloj);
        if (++nCarritos > maxCarritos)
            maxCarritos = nCarritos;
    }
    public void encolarCarrito(Reloj reloj,Carrito carrito){
        contarCarrito(reloj);
        carrito.setTiempoEntradaPeaje(reloj.tiempoAhora());
        miColaCarritos.offer(carrito);
    }
    public void servirCaja(Reloj reloj) throws NoSuchElementException{
        if (proxServ == reloj.tiempoAhora()){
            ++servidos;
            Carrito carrito = miColaCarritos.remove();
            
            totalEsperado += reloj.tiempoAhora() - carrito.tiempoEntradaPeaje();
            ventas += carrito.getSumaPrecios();
            productosCobrados += carrito.getCuantosProductos();
            if (--nCarritos > 0) 
                proxServ = proximoCobro(reloj);
            else
                proxServ=0;
        }  
    }
    public int getTotalEsperadoConCola(Reloj reloj){
        int suma = 0;
        Iterator<Carrito> i;
        i = miColaCarritos.iterator();
        while (i.hasNext())
            suma += reloj.tiempoAhora()-i.next().tiempoEntradaPeaje();
        return suma+totalEsperado;
    }
    public int getMaxCarritos(){
        return maxCarritos;
    } 
    public int getproxServ(){
        return proxServ;
    } 
    public int getNCarritos(){
        return miColaCarritos.size();
    }
    public int getServidos(){
        return servidos;
    }
    public int getTotalEsperado(){
        return totalEsperado;
    }
    public int getVentas()
    {
        return ventas;
    }
    public int getProductosCobrados()
    {
        return productosCobrados;
    }
}
