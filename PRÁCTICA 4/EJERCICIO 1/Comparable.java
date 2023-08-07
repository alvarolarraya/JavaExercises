public interface Comparable
{
    // Se emplean las siguientes constantes para indicar el
    // resultado de la comparacion
    public static final int MASPEQUENIOQUE = -1;
    int MASGRANDEQUE = 1;
    int IGUALQUE = 0;
    // El siguiente metodo se emplea para comparar el
    // objeto con el que se invoca contra otro. El
    // resultado indicara si el objeto es menor, mayor
    // o igual que el otro.
    public int esMasGrandeQue(Comparable otro);
}
