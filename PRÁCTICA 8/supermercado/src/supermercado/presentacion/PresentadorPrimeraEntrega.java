package supermercado.presentacion;

import supermercado.negocio.PrimeraEntrega.CarritoPrimeraEntrega;
import supermercado.negocio.PrimeraEntrega.ControladorPrimeraEntrega;
import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.Reloj;

public class PresentadorPrimeraEntrega {
    public EstadoZonaCobro miEstadoZonaCobro;
    public int tSim;
    public Reloj miReloj;
    public ControladorPrimeraEntrega miCont;
    public VistaPrimeraEntrega vista;
    public PresentadorPrimeraEntrega(VistaPrimeraEntrega vista,Reloj reloj, ControladorPrimeraEntrega controlador, EstadoZonaCobro estadoZonaCobro){
        this.vista = vista;
        miReloj = reloj;
        miCont = controlador;
        miEstadoZonaCobro = estadoZonaCobro;
        reloj.aCero();
    }
    public void obtenerUsuarioTiempoSimulacion(int tSim)
    {
        this.tSim = tSim;
    }
    public void simular(){
        while (miReloj.tiempoAhora()<tSim) {
            miReloj.tic();
            siguienteIteracion();
            if(miReloj.tiempoAhora()%3600 == 0)
            {
                vista.mostrarTamnioColas(miCont.getTamanioColas());
            }
        }
    }
    public void siguienteIteracion(){
        miCont.LlegaCarrito(miReloj);
        miCont.marchaCarrito(miReloj);
    }
    public void obtenerResultados()
    {
        miEstadoZonaCobro = miCont.estadoZonaCobro(miReloj,miEstadoZonaCobro);
    }
    public void mostrarResultados(){
        vista.mostrarResultadoFinal(miEstadoZonaCobro);
    }
    public void ejecutarSimulador(int tSim)
    {
        obtenerUsuarioTiempoSimulacion(tSim);
        simular();
        obtenerResultados();
        mostrarResultados();
    }
}
