package hospital;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Paciente {
    public String Nombre;
    public String Apellido1;
    public LocalDate FechaNacimiento;
    public String[] Sintomas;

    public Paciente() {
        this.Nombre = "";
        this.Apellido1  = "";
        this.FechaNacimiento = null;
        this.Sintomas = new String[0];
    }
    
    public Paciente(String Nombre, String Apellido1, LocalDate FechaNacimiento, String[] Sintomas) {
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.FechaNacimiento = FechaNacimiento;
        this.Sintomas = Sintomas;
    }
    
    public Boolean RequiereAislamiento(){
/*
        if(this.FechaNacimiento==null) return false;
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(this.FechaNacimiento, ahora);
        int edad = periodo.getYears();
        if(edad < 70) return false;
        int numeroSintomasCovid = 0;
        for(String sintoma : Sintomas){
            if(sintoma.equals("Tos seca") || sintoma.equals("Fiebre") || sintoma.equals("Cansancio"))
                numeroSintomasCovid++;
        }
        if(numeroSintomasCovid>= 2) return true;
        return false;
*/
        if(this.FechaNacimiento==null) return false;
        return Edad()>=70 && SintomasCOVID()>=2;
    }
    
    private Integer Edad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(this.FechaNacimiento, ahora);
        return periodo.getYears();
    }
    
    private Integer SintomasCOVID(){
        int numeroSintomasCovid = 0;
        for(String sintoma : Sintomas){
            if(sintoma.equals("Tos seca") || sintoma.equals("Fiebre") || sintoma.equals("Cansancio"))
                numeroSintomasCovid++;
        }
        return numeroSintomasCovid;
    }
    
    public String ApellidosComaNombre(){
        if(this.Nombre.equals("") && this.Apellido1.equals("")) return "-";
        if(this.Nombre.equals("")) return this.Apellido1;
        if(this.Apellido1.equals("")) return this.Nombre;
        return this.Apellido1 + ", " + this.Nombre;
    }
    
    public void RellenarDesdeLinea(String linea){
        String[] partes = linea.split("\\|", -1); // para no eliminar las partes vacias!
        String[] sintomas = new String[0];
        if(!"".equals(partes[3])){
            sintomas = partes[3].split(",");
        }
        this.Nombre = partes[0];
        this.Apellido1 = partes[1];
        if(!"".equals(partes[2])){
            this.FechaNacimiento = LocalDate.parse(partes[2],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        this.Sintomas = sintomas;
               
    }
    
}
