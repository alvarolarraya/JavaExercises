package casino.negocio;

/**
 *
 * @author roberto
 */
public class ResultadoJuego {
    
    public int valorDado1;
    public int valorDado2;

    public ResultadoJuego() {
        this.valorDado1 = 0;
        this.valorDado2 = 0;
    }

    public ResultadoJuego(int valorDado1, int valorDado2) {
        this.valorDado1 = valorDado1;
        this.valorDado2 = valorDado2;
    }
    
    public int puntuacion(){
        return valorDado1 + valorDado2;
    }
    
    public boolean esOjosDeTigre(){
        return valorDado1 == 1 && valorDado2 == 1;
    }
    
    public eResultado Comparar(ResultadoJuego otroResultado){
        return otroResultado.puntuacion() == this.puntuacion()       ? eResultado.EMPATAR :
               otroResultado.puntuacion() >  this.puntuacion()       ? eResultado.PERDER : 
                                                                       eResultado.GANAR;
    }
    
}
