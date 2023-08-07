/*
 * Copyright (C) 2015 Fitxi
 */
package autopista;

import java.util.Scanner;

/**
 * Clase Controlador: Gestiona la llegada y marcha de coches del peaje, así como
 * la localización de información para la salida
 * @author Fitxi
 * @version 1.0.0 (enero/2015)
 * @see Trafico
 * @see Peaje
 * @see Scanner
 * @see Reloj
 */
public class Controlador {
    private Trafico miTrafico;
    private Peaje miPeaje;
    public final int estaciones = 5;
    
    /**
     * Constructor del controlador
     * @param r el reloj para que se calcule el tiempo de primera llegada
     */
    public Controlador(Reloj r){
        miPeaje = new Peaje(estaciones);
        Scanner sc = new Scanner(System.in);
        System.out.print("Indique el tiempo medio de llegada de vehiculos: ");
        miTrafico = new Trafico(sc.nextInt());
        miTrafico.proximaLlegada(r);
    }
    
    /** 
     * Método LlegaCoche
     * Comprueba si es el momento de que llegue un nuevo coche y, en tal caso
     * simula su llegada y lo incluye en la cabina que corresponda. Tras ello 
     * programa la siguiente llegada
     * @param r reloj para concultar el tiempo actual
     */
    public void LlegaCoche(Reloj r){
        if (r.tiempoAhora() == miTrafico.getProximaLlegada()) {
            miPeaje.guardarCola(miPeaje.eligeCabina(), r);
            miTrafico.proximaLlegada(r);
        }
    }
  
    /**
     * Método estadoPeaje
     * Le indica al peaje que saque por pantalla los resultados de la simulacion
     * @param r tiempo actual
     */
    public void estadoPeaje(Reloj r){
        miPeaje.estado(r);
    }
    
    /**
     * Metodo marchaCoche
     * Le dice al peaje que haga una ronda de comprobación entre sus cabinas
     * @param r tiempo actual
     */
    public void marchaCoche(Reloj r){
        miPeaje.rondaCabinas(r);
    }
}
