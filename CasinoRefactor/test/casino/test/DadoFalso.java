package casino.test;

import casino.negocio.Dado;

/**
 *
 * @author roberto
 */
public class DadoFalso extends Dado {

    private final int valorConstante;
    
    public DadoFalso(int valor) {
        valorConstante = valor;
    }

    @Override
    public int valor(){
       return valorConstante; 
    }
    
}
