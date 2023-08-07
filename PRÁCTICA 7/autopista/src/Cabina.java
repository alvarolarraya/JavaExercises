import java.util.LinkedList;
import java.util.Queue;

public class Cabina {
    private int nCoches;
    private int maxCoches;
    private int minServ;
    private int maxServ;
    private int servidos;
    private int totalEsperado;
    private int proxServ;
    public int newAttr;
    private Queue<Vehiculo> miColaVehiculos;
    public Cabina(int minServicio, int maxServicio)
    {
        miColaVehiculos = new LinkedList<Vehiculo>();
        nCoches = 0;
        maxCoches = 0;
        minServ = minServicio;
        maxServ = maxServicio;
        servidos = 0;
        totalEsperado = 0;
    }
    private int proximoCobro(Reloj reloj)
    {
        return (int)(((maxServ-minServ)*Math.random())+ minServ +
reloj.tiempoAhora()); 
    }
    private void contarCoche(Reloj reloj)
    {
        nCoches++;
        if(nCoches == 0)
            proxServ = proximoCobro(reloj);
        if(maxServ < nCoches)
            maxServ = nCoches;
    }
    public void encolarCoche(Reloj reloj)
    {
        contarCoche(reloj);
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setTiempoEntradaPeaje(reloj.tiempoAhora());
        miColaVehiculos.add(vehiculo);
    }
    public void servirCabina(Reloj reloj)
    {
        if(reloj.tiempoAhora() == proxServ)
        {
            servidos++;
            Vehiculo vehiculo = miColaVehiculos.element();
            miColaVehiculos.remove();
            nCoches--;
            totalEsperado = reloj.tiempoAhora()-vehiculo.tiempoEntradaPeaje();
            if(nCoches == 0)
                proxServ = 0;
            else
                proxServ = proximoCobro(reloj);
        }
    }
    public int maximoNumeroCochesEsperandoSimultaneamente ()
    {
        return maxCoches;
    }
    public int numeroCochesServidos()
    {
        return servidos;
    }
    public int tiempoTotalEsperado()
    {
        return totalEsperado;
    }
    public int numeroCochesEnCola()
    {
        return nCoches;
    }
}