/*
 * Copyright (C) 2015 Fitxi
 */
package autopista;

/**
 * Clase Simulador
 * Clase activa del programa de simulación. Lanza una simulación de  tres de 
 * funcionamiento de una autopista
 * @author Fitxi
 * @version 1.0.0
 * @see Controlador
 * @see Reloj
 */
public class Simulador {
    public int tSim; // tiempo de simulación
    public Reloj miReloj;
    public Controlador miCont;
    
    /** 
     * Constructor del Simulador
     * Fija el timepo de simulación, crea un reloj a cero y un nuevo controlador
     * @param tSim tiempo de simulación
     */
    public Simulador(int tSim){
        this.tSim = tSim;
        miReloj = new Reloj();
        miReloj.aCero();
        miCont = new Controlador(miReloj);
    }
    
    /**
     * método simular
     * Lanza la simulación
     */
    public void simular(){
        while (miReloj.tiempoAhora()<tSim) {
            miReloj.tic();
            siguienteIteracion();
        }
    }
    
    /**
     * método siguienteIteración
     * hace que el controlador simule la posible llegada y salida de coches
     */
    private void siguienteIteracion(){
        miCont.LlegaCoche(miReloj);
        miCont.marchaCoche(miReloj);
    }
    
    /**
     * método mostrarResultados
     * Solicita al controlador que saque los resultados por pantalla
     */
    public void mostrarResultados(){
        miCont.estadoPeaje(miReloj);
    }
    
    /**
     * método main
     * Instancia un simulador de 3 horas, lo pone a simular e imprime sus 
     * resultados
     * @param args 
     */
    public static void main(String[] args){
        Simulador sim;
        sim = new Simulador(10800);
        sim.simular();
        sim.mostrarResultados();
    }
}