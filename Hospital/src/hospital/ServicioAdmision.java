/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author roberto
 */
public class ServicioAdmision {
    public String Ingresar(String fichero){
        /*
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        pacientes.add(new Paciente("Mikel","Martinez",LocalDate.of(2001,1,1),new String[]{"Fiebre"}));
        pacientes.add(new Paciente("Mikel","Martinez",LocalDate.of(1940,1,1),new String[]{"Tos seca","Fiebre"}));
        */
        
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        try {
           BufferedReader reader = new BufferedReader(new FileReader(new File(fichero)));

           String linea;
           while((linea=reader.readLine())!=null){
               /*
               Paciente paciente = new Paciente();
               paciente.RellenarDesdeLinea(linea);
               pacientes.add(paciente);
               */
               
               String[] partes = linea.split("\\|",-1);
               String[] sintomas = partes[3].split(",");
               String nombre = partes[0];
               String apellido =partes[1];
               LocalDate fecha = LocalDate.parse(partes[2],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
               pacientes.add(new Paciente(nombre,apellido,fecha,sintomas));
               
            }
        }
        catch(Exception e){
        }
        
      
        StringBuilder respuesta = new StringBuilder();
        for(Paciente paciente : pacientes){
            if(paciente.RequiereAislamiento()){
                respuesta.append(paciente.ApellidosComaNombre() + " AISLAMIENTO\n");
            }
        }
        return respuesta.toString();
    }
}
