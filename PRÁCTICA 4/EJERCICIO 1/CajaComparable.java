public class CajaComparable extends Caja implements Comparable
{
    public CajaComparable(double longitud, double anchura, double altura)
    {
        super(longitud,anchura,altura);
    }
    public int esMasGrandeQue(Comparable otro)
    {
        Caja elOtro = (Caja) otro;
        if(this.calcularVolumen() > elOtro.calcularVolumen())
            return MASGRANDEQUE;
        else if (this.calcularVolumen() == elOtro.calcularVolumen())
            return IGUALQUE;
        else
            return MASPEQUENIOQUE;
    }
}
