/*
 * Copyright (C) 2015 Fitxi
 *
 */
package autopista;

/**
 * Clase Reloj
 * Clase muy tonta que permite simular el paso del tiempo (contador de segundos) 
 * (es absurda, pero daba problemas a los alumnos como subclase, así que 
 * la promocioné a clase)
 * @author Fitxi
 * @version 1.0.1 (enero/2015)
 */
public class Reloj {
    private int tiempo;
    
    /**
     * método aCero
     * Inicializa el reloj
     */
    public void aCero(){
        tiempo = 0;
    }
    
    /**
     * metodo tiempoAhora
     * getter para el tiempo actual
     * @return tiempo actual
     */
    public int tiempoAhora(){
        return tiempo;
    }
    
    /**
     * método tic
     * simula el paso de un segundo
     */
    public void tic(){
        tiempo++;
    }
}
