package casino.negocio;

/**
 *
 * @author roberto
 */
public class Jugador {
    
    private String nombre;
    private Dado dado;
    private ResultadoJuego resultado;
    private int numeroJuegosGanados;

    public Jugador(Dado dado) {
        this.nombre = "";
        this.dado = dado;
        this.resultado = new ResultadoJuego();
        this.numeroJuegosGanados = 0;
    }
    
    public void juega(){
	dado.tirar();
        int valorDado1 = dado.valor();
	dado.tirar();
        int valorDado2 = dado.valor();
        this.resultado =  new ResultadoJuego(valorDado1, valorDado2);
    }
    
    public ResultadoJuego resultado(){
        return this.resultado;
    }
    
    public void darNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String nombre(){
        return this.nombre;
    }     
    
    public void computarVictoria(){
        numeroJuegosGanados++;
    }
    
    public int victorias(){
        return this.numeroJuegosGanados;
    }
    
     
}
