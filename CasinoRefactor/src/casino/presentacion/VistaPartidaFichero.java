package casino.presentacion;

import casino.negocio.IVistaPartida;
import casino.negocio.ResultadoJuego;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class VistaPartidaFichero implements IVistaPartida{

    private int numeroInvocacionesObtenerJugador=0;
    private BufferedWriter fileWriter;
    
    public VistaPartidaFichero(String fichero) {
        try {
            fileWriter = new BufferedWriter(new FileWriter(new File(fichero)));
        } catch (IOException ex) {
            Logger.getLogger(VistaPartidaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public String obtenerNombreJugador() {
        numeroInvocacionesObtenerJugador++;
        return numeroInvocacionesObtenerJugador == 1 ? "JugadorA" : "JugadorB";
    }

    @Override
    public void comienzaPartida() {
       
    }

    @Override
    public void comienzaTurno(int numeroTurno) {
        try {
            this.fileWriter.newLine();
        } catch (IOException ex) {
            Logger.getLogger(VistaPartidaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    @Override
    public void empate() { 
    }

    @Override
    public void ganaJugador(String nombreJugador) {
        try {
            this.fileWriter.write(nombreJugador + "\r\n");
        } catch (IOException ex) {
            Logger.getLogger(VistaPartidaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mostrarResultado(String nombreJugador, ResultadoJuego resultado) {
        try {
            this.fileWriter.write(nombreJugador          + " | " +
                    String.valueOf(resultado.valorDado1) + " | " +
                    String.valueOf(resultado.valorDado2) + "\r\n");
        } catch (IOException ex) {
            Logger.getLogger(VistaPartidaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ganadorPartida(String nombreGanador) {
        try {
            this.fileWriter.newLine();
            this.fileWriter.write("GANADOR " + nombreGanador + "\r\n");
            
            this.fileWriter.flush();
            this.fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(VistaPartidaFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
