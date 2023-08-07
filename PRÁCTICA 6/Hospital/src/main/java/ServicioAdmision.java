import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ServicioAdmision
{
    public ServicioAdmision(){
    }
    public String Ingresar(String fichero)
    {
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fichero)));
            String linea;
            while((linea=reader.readLine())!=null){
                // Parsear la línea a un objeto Paciente:
                RellenarDesdeLinea(linea,pacientes);
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
    public void RellenarDesdeLinea(String linea,ArrayList<Paciente> pacientes){
        // poblar los atributos del objeto con los valores de la linea
        String[] partes = linea.split("\\|",-1);
        String[] sintomas = partes[3].split(",");
        String nombre = partes[0];
        String apellido =partes[1];
        LocalDate fecha = LocalDate.parse(partes[2],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        pacientes.add(new Paciente(nombre,apellido,fecha,sintomas));
    }
}