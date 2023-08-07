/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalTests;

import hospital.Paciente;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto
 */
public class PacienteTest {
    
    public PacienteTest() {
    }

    @Test
    public void Un_paciente_mayor_con_dos_sintomas_covid_requiere_aislamiento() {
         // Dado un paciente de más de 70 años que tiene dos sintomas COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas = new String[]{"Tos seca", "Cansancio"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertTrue(requiereAislamiento);
    }
    
    @Test
    public void Un_paciente_mayor_con_un_sintoma_covid_no_requiere_aislamiento() {
        // Dado un paciente de más de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas = new String[]{"Tos seca", "Diarrea", "Nauseas"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertFalse(requiereAislamiento);
    }
    
    @Test
    public void Un_paciente_mayor_con_tres_sintomas_y_dos_de_ellos_covid_requiere_aislamiento() {
        // Dado un paciente de más de 70 años que tiene dos sintomas COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas = new String[]{"Fiebre", "Cansancio", "Diarrea"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertTrue(requiereAislamiento);
    }
    
    @Test
    public void Un_paciente_mayor_con_tres_sintomas_y_uno_de_ellos_covid_no_requiere_aislamiento() {
        // Dado un paciente de más de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas = new String[]{"Cansancio", "Diarrea"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertFalse(requiereAislamiento);
    }
    
    @Test
    public void Un_paciente_joven_con_tres_sintomas_covid_no_requiere_aislamiento() {
        // Dado un paciente menor de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento =  LocalDate.of(2001,1,1);
        paciente.Sintomas = new String[]{"Cansancio", "Fiebre","Tos seca"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertFalse(requiereAislamiento);
    }
    
    @Test
    public void Un_paciente_joven_con_dos_sintomas_covid_no_requiere_aislamiento() {
        // Dado un paciente menor de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento =  LocalDate.of(2001,1,1);
        paciente.Sintomas = new String[]{"Cansancio", "Fiebre","Tos seca"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertFalse(requiereAislamiento);
    }
    
    @Test
    public void Un_paciente_mayor_sin_sintomas_no_requiere_aislamiento() {
        // Dado un paciente menor de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento =  LocalDate.of(1940,1,1);
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertFalse(requiereAislamiento);
    }
    
     @Test
    public void Un_paciente_sin_fecha_nacimiento_y_con_sitomas_no_requiere_aislamiento() {
        // Dado un paciente menor de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.Sintomas =  new String[]{"Cansancio", "Fiebre","Tos seca"};;
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertFalse(requiereAislamiento);
    }
    
     @Test
    public void Un_paciente_sin_fecha_nacimiento_y_sin_sintomas_COVID_no_requiere_aislamiento() {
        // Dado un paciente menor de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento =  null;
        paciente.Sintomas = null;
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertFalse(requiereAislamiento);
    }
    
    

    @Test
    public void Un_paciente_con_nombre_y_apellido_se_muestra_con_el_apellido_coma_nombre() {
        // Dado un paciente con nombre y apellido
        Paciente paciente = new Paciente();
        paciente.Nombre = "Mikel";
        paciente.Apellido1 = "Martinez";
        // Cuando calculo su nombre descriptivo
        String nombreDescriptivo = paciente.ApellidosComaNombre();
        // Entonces debe ser apellido, nombre
        assertEquals(nombreDescriptivo, "Martinez, Mikel");
    }
    
    @Test
    public void Un_paciente_con_nombre_y_sin_apellido_se_muestra_con_el_nombre() {
        // Dado un paciente con nombre y sin apellido
        Paciente paciente = new Paciente();
        paciente.Nombre = "Mikel";
        // Cuando calculo su nombre descriptivo
        String nombreDescriptivo = paciente.ApellidosComaNombre();
        // Entonces debe ser el nombre
        assertEquals(nombreDescriptivo, "Mikel");
    }
    
    @Test
    public void Un_paciente_sin_nombre_y_con_apellido_se_muestra_con_el_apellido() {
        // Dado un paciente sin nombre y con apellido
        Paciente paciente = new Paciente();
        paciente.Apellido1 = "Martinez";
        // Cuando calculo su nombre descriptivo
        String nombreDescriptivo = paciente.ApellidosComaNombre();
        // Entonces debe ser el apellido
        assertEquals(nombreDescriptivo, "Martinez");
    }
    
    @Test
    public void Un_paciente_sin_nombre_y_sin_apellido_se_muestra_con_un_guion() {
        // Dado un paciente sin nombre y sin apellido
        Paciente paciente = new Paciente();
        // Cuando calculo su nombre descriptivo
        String nombreDescriptivo = paciente.ApellidosComaNombre();
        // Entonces debe ser un guion
        assertEquals(nombreDescriptivo, "-");
    }
    
    @Test
    public void El_paciente_se_rellena_con_linea_de_dos_sintomas() {
        // Dada una linea con dos sintomas
        String linea = "Mikel|Martinez|01/01/2001|Tos seca,Nauseas";
        Paciente paciente = new Paciente();
        // Cuando relleno el paciente con la linea
        paciente.RellenarDesdeLinea(linea);
        // Entonces el paciente tiene dos sintomas
        assertEquals(paciente.Sintomas.length,2);
    }
    
    @Test
    public void El_paciente_se_rellena_con_linea_de_tres_sintomas() {
        // Dada una linea con dos sintomas
        String linea = "Fermin|Navarro|01/01/1940|Cansancio,Fiebre,Nauseas";
        Paciente paciente = new Paciente();
        // Cuando relleno el paciente con la linea
        paciente.RellenarDesdeLinea(linea);
        // Entonces el paciente tiene dos sintomas
        assertEquals(paciente.Sintomas.length,3);
    }
    
    @Test
    public void El_paciente_se_rellena_con_linea_sin_sintomas() {
        // Dada una linea sin sintomas
        String linea = "Aitor|Menta|01/01/2001|";
        Paciente paciente = new Paciente();
        // Cuando relleno el paciente con la linea
        paciente.RellenarDesdeLinea(linea);
        // Entonces el paciente tiene dos sintomas
        assertEquals(paciente.Nombre, "Aitor");
        assertEquals(paciente.Sintomas.length,0);
    }
    
     @Test
    public void El_paciente_se_rellena_con_linea_sin_fecha_de_nacimiento() {
        // Dada una linea sin sintomas
        String linea = "Aitor|Menta||Tos seca";
        Paciente paciente = new Paciente();
        // Cuando relleno el paciente con la linea
        paciente.RellenarDesdeLinea(linea);
        // Entonces el paciente tiene dos sintomas
        assertEquals(paciente.Nombre,"Aitor");
    }
    
     @Test
    public void El_paciente_se_rellena_con_linea_vacia() {
        // Dada una linea sin sintomas
        String linea = "|||";
        Paciente paciente = new Paciente();
        // Cuando relleno el paciente con la linea
        paciente.RellenarDesdeLinea(linea);
        // Entonces el paciente tiene dos sintomas
        assertEquals(paciente.Nombre, "");
        assertEquals(paciente.Apellido1,"");
        assertEquals(paciente.FechaNacimiento,null);
        assertEquals(paciente.Sintomas.length,0);
    }
    
}
