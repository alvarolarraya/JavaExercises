/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalTests;

import hospital.ServicioAdmision;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto
 */
public class ServicioAdmisionTest {
    
    public ServicioAdmisionTest() {
    }

    @Test
    public void testIngresar() {
        String fichero = "pacientes.txt";
        String respuesta = new ServicioAdmision().Ingresar(fichero);
        assertEquals(respuesta,"Navarro, Fermin AISLAMIENTO\n");
    }
    
    @Test
    public void testIngresar2() {
        String fichero = "pacientes2.txt";
        String respuesta = new ServicioAdmision().Ingresar(fichero);
        assertEquals(respuesta,"Navarro, Fermin AISLAMIENTO\nNavarro, Fermin AISLAMIENTO\nNavarro, Fermin AISLAMIENTO\nNavarro, Fermin AISLAMIENTO\nNavarro, Fermin AISLAMIENTO\n");
    }
    
     @Test
    public void testIngresar3() {
        String fichero = "pacientesVacio.txt";
        String respuesta = new ServicioAdmision().Ingresar(fichero);
        assertEquals(respuesta,"");
    }
    
}
