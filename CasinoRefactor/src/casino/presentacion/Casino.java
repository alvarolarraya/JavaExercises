package casino.presentacion;

import casino.negocio.*;

/**
 *
 * @author roberto
 */
public class Casino {

    public static void main(String[] args) {
        new PresentadorPartida(
                new VistaPartidaConsola(),
                new Turno(
                        new Jugador(new Dado()),
                        new Jugador(new Dado())
                )
        ).jugarTurnos();
        
//        new PresentadorPartida(
//                new VistaPartidaFichero("fichero.txt"),
//                new Turno(
//                        new Jugador(new Dado()),
//                        new Jugador(new Dado())
//                )
//        ).jugarTurnos();
        
//        new Partida(
//                new Turno(new Jugador(new Dado()), 
//                          new Jugador(new Dado()))
//        ).jugarTurnos();
    }
    
}
