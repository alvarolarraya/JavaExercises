package casino.test;

import casino.negocio.Dado;

/**
 *
 * @author roberto
 */
public class DadoTrucado extends Dado {

    private final int[] valorDeCadaTirada;
    private int numeroTiradas;
    
    
    public DadoTrucado(int[] valorDeCadaTirada) {
        this.valorDeCadaTirada = valorDeCadaTirada;
        numeroTiradas = 0;
    }
    
    @Override
    public void tirar(){
       numeroTiradas++;
    }

    @Override
    public int valor(){
       return valorDeCadaTirada[numeroTiradas-1];
    }
    
}