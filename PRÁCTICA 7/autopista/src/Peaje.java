import java.util.ArrayList;
import java.util.Collections;

public class Peaje {
    final int [][] tipoCobro = {{15,30}, {15,30}, {15,45}, {30,60},{45,60}};
    int numCabinas;
    private ArrayList<Cabina> myCabinas;
    private ArrayList<Orden> ordenCabinas;
    public Peaje(int estaciones){
        myCabinas = new ArrayList<Cabina>();
        numCabinas = estaciones;
        for (int i = 0; i < numCabinas; i++)
            myCabinas.add(new Cabina(tipoCobro[i][0], tipoCobro[i][1]));
    }
    public void guardarCola(int nCab,Reloj reloj)
    {
        myCabinas.get(nCab).encolarCoche(reloj);
        ordenar();
    }
    public int eligeCabina()
    {
        ordenCabinas = new ArrayList<Orden>();
        final double [] elec = {0.6, 0.9, 1.0};
        double x = Math.random();
        int n = 0;
        while((elec[n]<x  && (n<2)))
            n++;
        return ordenCabinas.get(n).cabina​;
    }
    public void rondaCabinas(Reloj reloj)
    {
        for(int i = 0; i < numCabinas;i++)
            myCabinas.get(i).servirCabina(reloj);
        ordenar();
    }
    private void ordenar()
    {
        for(int i = 0; i < numCabinas; i++)
            ordenCabinas.add(new Orden(myCabinas.get(i).numeroCochesEnCola(), i));
        Collections.sort(ordenCabinas);
    }
    public void estado()
    {
        int tiempoMedioEsperaPorCoche,cochesServidos = 0,tiempoTotalEsperado = 0,mediaCochesPorCabina,maximoCochesSimultaneamente  = 0,tiempoMedioEsperaPorCabina;
        for(int i = 0; i < numCabinas;i++)
        {
            tiempoTotalEsperado = tiempoTotalEsperado + myCabinas.get(i).tiempoTotalEsperado();
            cochesServidos = cochesServidos + myCabinas.get(i).numeroCochesServidos();
            if(maximoCochesSimultaneamente < myCabinas.get(i).maximoNumeroCochesEsperandoSimultaneamente ())
                maximoCochesSimultaneamente  = myCabinas.get(i).maximoNumeroCochesEsperandoSimultaneamente ();
        }
        tiempoMedioEsperaPorCoche = tiempoTotalEsperado/cochesServidos;
        System.out.println("El tiempo medio de espera por coche es: " + tiempoMedioEsperaPorCoche);
        mediaCochesPorCabina = cochesServidos / numCabinas;
        System.out.println("El numero medio de coches atendidos por cabina es: "+mediaCochesPorCabina);
        System.out.println("Se han servido "+cochesServidos+" coches en total");
        System.out.println("El maximo numero de coches en cola simultaneamente es: "+maximoCochesSimultaneamente);
        tiempoMedioEsperaPorCabina = tiempoTotalEsperado / numCabinas;
        System.out.println("El tiempo medio de espera por cabina es: "+tiempoMedioEsperaPorCabina);
    }
}