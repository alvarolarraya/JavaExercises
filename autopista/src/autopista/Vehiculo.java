/*
 * Copyright (C) 2015 Fitxi
 */
package autopista;

/**
 * Clase Vehiculo
 * Simula un vehiculo. EL unico dato que importa es el timepo de entrada en el 
 * peaje
 * @author Fitxi
 * @version 1.0.0
 */
public class Vehiculo {
    private int tiempoEntradaPeaje; //tiempo de entrada en el peaje
    
    /**
     * metodo setTiempoEntradaPeaje
     * Fija el tiempo en que entra el coche en el peaje
     * @param tiempoAhora tiempo de entrada
     */
    public void setTiempoEntradaPeaje (int tiempoAhora) {
        tiempoEntradaPeaje = tiempoAhora;
    }
    
    /**
     * método tiempoEntradaPeaje
     * permite consultar el tiempo de entrada en el peaje
     * @return el tiempo de entrada en el peaje
     */
    public int tiempoEntradaPeaje(){
        return tiempoEntradaPeaje;
    }
}
