public class Simulador {
    public int tSim;
    private Reloj reloj;
    private Controlador controlador;
    public Simulador(int tiempoSimulacion)
    {
        tSim = tiempoSimulacion;
        reloj = new Reloj();
        controlador = new Controlador(reloj);
    }
    public void simular()
    {
        while(reloj.tiempoAhora() < tSim)
        {
            siguienteIteracion();
            reloj.tic();
        }
    }
    public void siguienteIteracion()
    {
        controlador.llegaCoche(reloj);
        controlador.marchaCoche(reloj);
    }
    public void mostrarResultados()
    {
        controlador.estadoPeaje();
    }
    public static void main(String[] args)
    {
        //empiezo el simulador con tiempo 3 horas
        Simulador simulador = new Simulador(10800);
        simulador.simular();
        simulador.mostrarResultados();
    }
}