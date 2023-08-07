package casino.negocio;

public class Dado {
    
    private int valor;

    public Dado() {
    }
    
    public int valor(){
        return valor;
    }
    
    public void tirar(){
        valor = (int)(Math.random()*6) + 1;
    }
}
