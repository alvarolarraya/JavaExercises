/*
 * Copyright (C) 2015 Fitxi
 */
package autopista;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


/**
 * Clase Cabina.
 * Simula el funcionamiento de una cabina de un peaje
 * @author Fitxi
 * @version 1.0.0 (enero/2015)
 * @see Vehiculo
 * @see Queue
 * @see Iterator
 * @see LinkedList
 * @see NoSuchElementException
 */
public class Cabina {
    private Queue<Vehiculo> miColaVehiculos;    //cola de vehiculos
    private int nCoches;    //numero de coches en la cola
    private int maxCoches;  //numero máximo de coches en la cola
    private final int maxServ;  // tiempo maximo de espera del siguiente cocbro
    private final int minServ;  //tiempo minimo de espera del siguiente cobro
    private int servidos;   //numero de coches servidos
    private int totalEsperado;  //tiempo total esperado por los coches servidos
    private int proxServ;   //tiempo del proximo servicio simulado
    
    /**
     * Constructor de Cabina
     * @param minServ Indica el tiempo mímino del servicio para la cabina
     * @param maxServ Indica el tiempo máximo de espera por el servicio 
     */
    public Cabina(int minServ, int maxServ){
        miColaVehiculos = new LinkedList<Vehiculo>();
        nCoches = 0;
        maxCoches = 0;
        this.maxServ = maxServ;
        this.minServ = minServ;
        servidos = 0;
        totalEsperado = 0;
        proxServ = 0;
    }
    
    /** 
     * Metodo proximoCobro
     * Calcula el tiempo del proximo cobro en funcion de los tiempos de servicio
     * de la cabina y el tiempo actual siguiendo una distribución equiprobable
     * @param reloj el reloj con el tiempo actual
     * @return instante de tiempo en que se cobrará al siguiente vehículo
     */
    private int proximoCobro(Reloj reloj){
        return (int)(((maxServ - minServ) * Math.random()) + minServ + 
                reloj.tiempoAhora());
    }
    
    /**
     * Método contarCoche
     * Si es necesario establecer un tiempo de cobro porque no había coches en
     * la cabina, lo establece. Contabiliza el coche en la cola y si es superior
     * al maximo de coches encolados hasta ahora, modifica dicho valor
     * @param reloj el reloj con el tiempo actual
     */
    private void contarCoche(Reloj reloj){
        if (nCoches == 0)
            proxServ = proximoCobro(reloj);
        if (++nCoches > maxCoches)
            maxCoches = nCoches;
    }
    
    /**
     * Método encolarCoche
     * Simula la llegada de un nuevo coche a la cabina. Se contabiliza, se crea
     * el vehiculo con su tiempo de entrada y se encola
     * @param reloj el reloj con el tiempo actual
     */
    public void encolarCoche(Reloj reloj){
        contarCoche(reloj);
        Vehiculo coche = new Vehiculo();
        coche.setTiempoEntradaPeaje(reloj.tiempoAhora());
        miColaVehiculos.offer(coche);
    }
    
    /**
     * Metodo servirCabina
     * Si ha llegado el momento de servir un vehículo, se le da servicio. Se
     * contabiliza como servido, se elimina el vehiculo de la cola, se 
     * contabiliza el tiempo que ha estado esperando y, si es necesario, se
     * programa un nuevo servicio
     * @param reloj el reloj con el tiempo actual
     * @throws NoSuchElementException cuando se trata de acceder a una lista 
     * vacia
     */
    public void servirCabina(Reloj reloj) throws NoSuchElementException{
        if (proxServ == reloj.tiempoAhora()){
            ++servidos;
            Vehiculo coche = miColaVehiculos.remove();
            
            totalEsperado += reloj.tiempoAhora() - coche.tiempoEntradaPeaje();
            if (--nCoches > 0) 
                proxServ = proximoCobro(reloj);
            else
                proxServ=0;
        }  
    }
    /**
     * Método getTotalEsperadoConCola
     * @param reloj tiempo actual
     * @return tiempo esperado en la cola considerando tanto servidos como aun 
     * no servidos
     */
    public int getTotalEsperadoConCola(Reloj reloj){
        int suma = 0;
        Iterator<Vehiculo> i;
        i = miColaVehiculos.iterator();
        while (i.hasNext())
            suma += reloj.tiempoAhora()-i.next().tiempoEntradaPeaje();
        return suma+totalEsperado;
    }
    /*
     * Metodos getter
     */
    
    /**
     * Metodo getMaxCoches
     * @return numero de coches máximo en la cola
     */
    public int getMaxCoches(){
        return maxCoches;
    } 
    
    /** 
     * Metodo getproxServ
     * @return tiempo del proximo servicio
     */
    public int getproxServ(){
        return proxServ;
    } 
    
    /**
     * Metodo getNCoches
     * @return Tamaño de la cola de vehiculos
     */
    public int getNCoches(){
        return miColaVehiculos.size();
    }
    
    /**
     * metodo getServidos
     * @return numero de coches servidos
     */
    public int getServidos(){
        return servidos;
    }
    
    /**
     * Metodo getTotalEsperado
     * @return tiempo total esperado por los coches servidos
     */
    public int getTotalEsperado(){
        return totalEsperado;
    }
}
