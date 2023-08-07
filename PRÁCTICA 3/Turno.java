/*package turno;
import dado.Dado;*/
//NO HACE FALTA HACER PAQUETES COMO MODULOS EN C, SI ESTÁN EN EL MISMO DIRECTORIO LAS CLASES TIENEN ACCESO ENTRE SÍ
public class Turno
{
    boolean empate;
    Jugador jugador1,jugador2;
    public class Jugador
    {
        int dado1,dado2,suma;
        boolean ojosDeTigre;
        public Jugador()
        {
            Dado aux = new Dado();
            dado1 = aux.mostrarResultado();
            aux = new Dado();
            dado2 = aux.mostrarResultado();
            suma = dado1+dado2;
            ojosDeTigre = false;
        }
    }
    public Turno()
    {
        empate = false;
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        if (jugador1.suma == jugador2.suma)
            empate = true;
    }
    public void imprimelo(String nombre1, String nombre2)
    {
        //Jugador 1
        System.out.println("\tJuega "+nombre1+":");
        System.out.println("\t\tEl lanzamiento del primer dado es " + jugador1.dado1);
        System.out.println("\t\tEl lanzamiento del segundo dado es " + jugador1.dado2);
        System.out.println("\t\tEl total de los dos lanzamientos es " + jugador1.suma);
        if (jugador1.suma == 2)  //ya que al no contemplar cero como resultado la unica manera de obtener una suma=2 es con dos unos
        {
            jugador1.ojosDeTigre = true;
            System.out.println(" Enhorabuena has obtenido ojos de tigre");
        }
        //Jugador 2
        System.out.println("\tJuega "+nombre2+":");
        System.out.println("\t\tEl lanzamiento del primer dado es " + jugador2.dado1);
        System.out.println("\t\tEl lanzamiento del segundo dado es " + jugador2.dado2);
        System.out.println("\t\tEl total de los dos lanzamientos es " + jugador2.suma);
        if (jugador2.suma == 2)
        {
            jugador2.ojosDeTigre = true;
            System.out.println(" Enhorabuena has obtenido ojos de tigre");
        }
    }
    public boolean finPorOjosDeTigre()
    {
        return (((this.jugador1.ojosDeTigre == true)||(this.jugador2.ojosDeTigre == true)) && (this.empate == false));
    }
}
