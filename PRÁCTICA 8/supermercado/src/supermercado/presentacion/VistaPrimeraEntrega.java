package supermercado.presentacion;

import java.util.Scanner;
import supermercado.negocio.EstadoZonaCobro;

public class VistaPrimeraEntrega {
    public Scanner scan;
    int numCajas;
    int[] tamanioColas;
    public VistaPrimeraEntrega(int numCajas) {
        this.scan = new Scanner(System.in);
        this.numCajas = numCajas;
    }
    public int obtenerTiempoSimulacion()
    {
        System.out.print("¿Cual va a ser la duracion de la simulacion?: ");
        return scan.nextInt();
    }
    public void mostrarTamnioColas(int[] tamanioColas)
    {
        this.tamanioColas = tamanioColas;
        System.out.println();
        System.out.println("Ha pasado una hora el tamaño de las colas son:");
        System.out.println();
        for(int i = 0; i<tamanioColas.length;i++)
        {
            System.out.println("        CABINA " +(i+1)+ ": "+tamanioColas[i]);
        }
    }
    public void mostrarResultadoFinal(EstadoZonaCobro resultado)
    {
        System.out.println();
        System.out.println("Los resultados finales son:");
        System.out.println();
        for(int i = 0;i < numCajas;i++)
        {
            System.out.println("    CABINA " +(i+1)+ ":");
            System.out.println("        Tiempo medio de espera: " +resultado.getTiempoMedioEsperadoCaja()[i]);
            System.out.println("        Maximo numero de carritos: " +resultado.getMaximoNumeroCarritosPorCaja()[i]);
            System.out.println("        Productos cobrados: " +resultado.getNumeroProductosPorCaja()[i]);
            System.out.println("        Euros recaudados: " +resultado.getVentasPorCaja()[i]);
            System.out.println("        Euros recaudados: " +resultado.getVentasPorCaja()[i]);
            System.out.println();
        }
        System.out.println("    TODO EL SUPERMERCADO: ");
        System.out.println("        Tiempo medio de espera: " +resultado.getTiempoMedioEsperado());
        System.out.println("        Clientes servidos: " +resultado.getTotalClientesServidos());
        System.out.println("        Productos cobrados: " +resultado.getTotalProductosCobrados());
        System.out.println("        Euros recaudados: " +resultado.getTotalVentas());
    }
}
