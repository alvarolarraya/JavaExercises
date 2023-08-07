package supermercado.negocio;

public class Orden {
    public int caja;
    public int carritos;
    public Orden(int caja, int num){
        this.caja = caja;
        carritos = num;
    }
}
