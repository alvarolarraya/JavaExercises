public class Partida
{
    Turno[] partida;
    boolean hayGanadorPrematuro, ganaJugador1,turnoJugador1;    //si sabemos que no ha ganado uno y no ha habido un empate => sabemos que ha ganado el otro (no hace falta dos variables de turno y gana)
    public Partida()
    {
        partida = new Turno[5];
    }
    public void juegaTurno(int numeroTurno,String nombre1,String nombre2)
    {
        partida[numeroTurno] = new Turno();
        partida[numeroTurno].imprimelo(nombre1,nombre2);
    }
    public void ojosDeTigre(int numeroTurno)
    {
        hayGanadorPrematuro = partida[numeroTurno].finPorOjosDeTigre();
        if ((hayGanadorPrematuro) && (partida[numeroTurno].finPorOjosDeTigre() == true))
            ganaJugador1 = true;
        else
            ganaJugador1 = false;
    }
    public void ganaTurno(int numeroTurno)
    {
        if (partida[numeroTurno].jugador1.suma > partida[numeroTurno].jugador2.suma)
            turnoJugador1 = true;
        else
            turnoJugador1 = false;
    }
}
