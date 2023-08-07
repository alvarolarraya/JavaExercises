/*
 * Copyright (C) 2015 Fitxi
 */
package autopista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase Peaje
 * simula un peaje con cabinas. Controla la elección de la cabina a la que van a 
 * parar las nuevas entradas de vehiculos
 * @author Fitxi
 * @version 1.0.0
 * @see Cabina
 * @see ArrayList
 * @see Orden
 * @see Collections
 * @see Comparator
 */
public class Peaje {
    private final int [][] tipoCobro = {
        {15,30}, // tiempos mínimos y máximos de cobro de los coches que llegan
        {15,30}, // a ser los primeros en cada una de las cabinas consideradas
        {15,45}, // Cada para se asigna a la cabina que le corresponde según
        {30,60}, // su número de orden
        {45,60}};
    public int numCabinas;
    private ArrayList<Cabina> misCabinas; // las cabinas
    private ArrayList<Orden> miOrden; //los ordenes para ordenar cabinas
    
    /**
     * Constructor de Peaje
     * Crea un nuevo peaje con el numero de cabinas que se le indica. Asigna a 
     * cada cabina los tiempo smáximos y mínimos de cobro
     * @param estaciones 
     */
    public Peaje(int estaciones){
        misCabinas = new ArrayList<Cabina>(); 
        this.numCabinas = estaciones;
        for (int i = 0; i < numCabinas; i++)
             misCabinas.add(new Cabina(tipoCobro[i][0], tipoCobro[i][1]));
    }
    
    /**
     * método guardarCola
     * Mete un nuevo coche en la cabina qie se le indica con el tiempo de lle-
     * gada que también se le indica
     * @param nCab número de cabina
     * @param myReloj hora de llegada
     */
    public void guardarCola(int nCab, Reloj myReloj){
        Cabina miCabina = (Cabina)misCabinas.get(nCab);
        miCabina.encolarCoche(myReloj);
    }
    
    /**
     * método ordenar
     * Ordena el ArrayList de ordenes en función del número de coches que esté 
     * esperando en la cabina a la que representa el orden (de menor a mayor)
     * @param miOrden ArrayList a ordenar
     */
    private void ordenar(ArrayList<Orden> miOrden){
        Collections.sort(miOrden,new Comparator<Orden>(){
            @Override
            public int compare(Orden o1, Orden o2){
                return new Integer(o1.coches).compareTo(o2.coches);
            }
        });
    }
    
    /**
     * método eligeCabina
     * Elije una cabina. 60% de probabilidad que sea la de menos coches, 30% la
     * segunda de menos coches y 10% la tercera de menos coches
     * @return el número de cabina que se ha elegido
     */
    public int eligeCabina(){
        miOrden = new ArrayList<Orden>();
        for (int i = 0; i < numCabinas; i++)
            miOrden.add(new Orden(i, misCabinas.get(i).getNCoches()));
        ordenar(miOrden);
        final double [] elec = {0.6, 0.9, 1.0};
        double x = Math.random();
        int n = 0;
        while ((elec[n]<x) && (n<2)){
            n++;
        }
        return miOrden.get(n).cabina;
    }
    
    /**
     * método rondaCabinas
     * Mira a ver si hay que servir alguna de las cabinas del peaje
     * @param miOrloj tiempo actual
     */
    public void rondaCabinas(Reloj miOrloj){
        for (Cabina i:misCabinas){
            i.servirCabina(miOrloj);
        }
    }
    
    /**
     * método estado
     * Saca por pantalla los resultados de la simulación
     * @param reloj tiempo del reloj
     */
    public void estado(Reloj reloj){
        int l = 1;
        int totalServidos = 0;
        int totalTiempoEspera = 0;
        for (Cabina j: misCabinas){
            System.out.println("Resultados de la cabina " + l++);
            System.out.println("  Numero máximo de coches: " + j.getMaxCoches());
            totalServidos += j.getServidos();
            System.out.println("  Coches servidos: " + j.getServidos());
            if (j.getServidos() != 0) {
                System.out.println("  Tiempo medio de espera: " + 
                                   j.getTotalEsperado()/j.getServidos());
                totalTiempoEspera += j.getTotalEsperado();
            } else {
                System.out.println("Esta cabina no ha servido coches");
            }
            System.out.println("  Tiempo medio de espera si incluimos el" + 
                               " tiempo esperado por los no servidos " + 
                               j.getTotalEsperadoConCola(reloj));
        }
        System.out.println("En total se han servido " + totalServidos + 
                           " coches durante la simulación");
        System.out.println("El tiempo medio de espera en el peaje ha sido de " +
                            totalServidos/totalTiempoEspera + " segundos");
                
    }
}
