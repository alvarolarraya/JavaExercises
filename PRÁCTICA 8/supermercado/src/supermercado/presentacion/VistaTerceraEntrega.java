package supermercado.presentacion;

public class VistaTerceraEntrega extends VistaSegundaEntrega{
    public VistaTerceraEntrega(int numCajas)
    {
        super(numCajas);
    }
    public int obtenerTiempoMedioLLegadaCarritos()
    {
        System.out.print("¿Cual va a ser el tiempo medio de llegada de carritos?: ");
        return scan.nextInt();
    }
}
