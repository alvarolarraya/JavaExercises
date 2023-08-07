package supermercado.presentacion;

import supermercado.negocio.EstadoZonaCobro;
import supermercado.negocio.ProductoFinal.ControladorProductoFinal;
import supermercado.negocio.Reloj;

public class PresentadorProductoFinal extends PresentadorSegundaEntrega{
    boolean vasACerrarCajas;
    int cuantasCajasCierro;
    int[] cajasCerradas;
    VistaCuartaEntrega vista;
    ControladorProductoFinal miCont;
    public PresentadorProductoFinal(VistaCuartaEntrega vista,Reloj reloj, ControladorProductoFinal controlador, EstadoZonaCobro estadoZonaCobro)
    {
        super(vista,reloj,controlador,estadoZonaCobro);
        miCont = controlador;
        this.vista = vista;
        vasACerrarCajas = false;
    }
    public void simular(){
        while (miReloj.tiempoAhora()<tSim) {
            miReloj.tic();
            siguienteIteracion();
            if(miReloj.tiempoAhora()%3600 == 0)
            {
                vista.mostrarTamnioColas(miCont.getTamanioColas());
                preguntarModificarCajas();
                if(vasACerrarCajas)
                {
                    miCont.cerrarCajas(cajasCerradas);
                    cajasCerradas = miCont.cerradasAhora();
                    vista.actualizarCajasCerradas(cajasCerradas);
                }
            }
        }
    }
    public void preguntarModificarCajas()
    {
        if(vista.preguntarSiCerrarCajas().equals("si"))
        {
            vasACerrarCajas = true;
            cuantasCajasCierro = vista.cuantasCajasCerrar();
            cajasCerradas = new int[cuantasCajasCierro];
            cajasCerradas = vista.cualesVasACerrar(cajasCerradas);
        }
    }
}
