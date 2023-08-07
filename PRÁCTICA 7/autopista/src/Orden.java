public class Orden implements Comparable {
    protected int cabina;
    protected int coches;
    public Orden(int num,int cabina)
    {
        this.cabina = cabina;
        coches = num;
    }
    public int compareTo(Object otro) {
        if(this.coches > ((Orden)otro).coches)
            return 1;
        else if(this.coches < ((Orden)otro).coches)
            return -1;
        else
            return 0;
    }
}