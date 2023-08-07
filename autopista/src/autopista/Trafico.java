/*
 * Copyright (C) 2015 Fitxi
 */
package autopista;

/**
 * Clase Trafico
 * Se encarga de crear llegadas de coche de modo que sigan una distribución 
 * exponencial con una media determinada
 * @author Fitxi
 * @version 1.0.0
 * @see Math
 */
public class Trafico {
    private final int tMedio; //media de la distribución de llegadas
    private int tLlegada; // tiempo de la próxima llegada
    
    /**
     * Constructor del Trafico
     * @param tiempo tiempo medio de llegada
     */
    public Trafico(int tiempo){
         tMedio = tiempo;
    }
    
    /**
     * método getProximaLlegada
     * @return tiempo de proxima llegada
     */
    public int getProximaLlegada(){
        return tLlegada;
    }
    
    /** 
     * método proximaLlegada
     * Calcula el timepo de proxima llegada teniendo en cuenta la distribucion
     * considerada y el tiempo actual
     * @param r reloj con el tiempo actual
     */
    public void proximaLlegada(Reloj r){
        tLlegada = (int)(r.tiempoAhora()+1-tMedio*Math.log(1-Math.random()));
    }
}
