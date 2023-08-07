import java.time.LocalDate;
import java.time.Period;

public class​ Paciente
{
    public String​ Nombre;
    public String​ Apellido1;
    public LocalDate FechaNacimiento;
    public String​[] Sintomas;
    public Paciente()
    {
        this.Nombre = "";
        this.Apellido1 = "";
        this.FechaNacimiento = null;
        this.Sintomas = new String[0];
    }
    public Paciente(String nombre,String apellido1,LocalDate fechaNacimiento,String[] sintomas)
    {
        this.Nombre = nombre;
        this.Apellido1 = apellido1;
        this.FechaNacimiento = fechaNacimiento;
        this.Sintomas = sintomas;
    }
    public Boolean RequiereAislamiento()
    {
        if(this.FechaNacimiento==null) 
            return false;
        return Edad()>=70 && SintomasCOVID()>=2;
    }
    public String​ ApellidosComaNombre()
    {
        String ApellidoComaNombre;
        if(Apellido1.equals("") && !Nombre.equals(""))
            ApellidoComaNombre = Nombre;
        else if(!Apellido1.equals("") && Nombre.equals(""))
            ApellidoComaNombre = Apellido1;
        else if(Apellido1.equals("") && Nombre.equals(""))
            ApellidoComaNombre = "-";
        else
            ApellidoComaNombre = Apellido1+ ", "+Nombre;
        return ApellidoComaNombre;
    }
    private int Edad()
    {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(this.FechaNacimiento, ahora);
        int edad = periodo.getYears();
        return edad;
    }
    private int SintomasCOVID()
    {
        int numeroSintomasCovid = 0;
        for(String sintoma : Sintomas){
            if(sintoma.equals("Tos seca") || sintoma.equals("Fiebre") ||
            sintoma.equals("Cansancio"))
            numeroSintomasCovid++;
        }
        return numeroSintomasCovid;
    }
}