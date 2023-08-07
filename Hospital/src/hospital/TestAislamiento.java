package hospital;

import java.time.LocalDate;

public class TestAislamiento {
    public static void main(String[] args) {
        // TEST1
        // Dado un paciente de más de 70 años que tiene dos sintomas COVID19
        Paciente paciente1 = new Paciente("Mikel", "Martinez", LocalDate.of(1940,1,1), new String[]{"Tos seca", "Cansancio"});
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamientoPaciente1 = paciente1.RequiereAislamiento();
        // Entonces debe devolver cierto
        if(requiereAislamientoPaciente1) System.out.println("OK"); 
        else System.out.println("NOK"); 
        
        // TEST2
        // Dado un paciente de más de 70 años que tiene solo un sintoma COVID19
        Paciente paciente2 = new Paciente("Mikel", "Martinez", LocalDate.of(1940,1,1), new String[]{"Tos seca", "Diarrea", "Nauseas"});
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamientoPaciente2 = paciente2.RequiereAislamiento();
        // Entonces debe devolver cierto
        if(!requiereAislamientoPaciente2) System.out.println("OK"); 
        else System.out.println("NOK");   
    } 
}
