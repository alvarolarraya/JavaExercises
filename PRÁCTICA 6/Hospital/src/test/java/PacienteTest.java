
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PacienteTest {
    @Test
    public​ void Un_paciente_mayor_con_dos_sintomas_covid_requiere_aislamiento()
    {
        // Dado un paciente de más de 70 años que tiene dos sintomas COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas =  new String​[]{"Tos seca","Cansancio"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertTrue(requiereAislamiento);
    }
    @Test
    public void Un_paciente_mayor_con_un_sintoma_covid_no_requiere_aislamientoTest() {
        // Dado un paciente de más de 70 años que tiene un sintoma COVID19
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas = new String[]{"Tos seca", "Diarrea", "Nauseas"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver falso
        assertFalse(requiereAislamiento);
    }
    @Test
    public void Un_paciente_mayor_con_fiebre_cansancio_diarrea_requiere_aislamiento()
    {
        //Dado un paciente mayor con fiebre,cansancio y diarrea
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas = new String[]{"Fiebre", "Cansancio", "Diarrea"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver cierto
        assertTrue(requiereAislamiento);
    }
    @Test
    public void Un_paciente_mayor_con_cansancio_diarrea_no_requiere_aislamiento()
    {
        //Dado un paciente mayor con cansancio y diarrea
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        paciente.Sintomas = new String[]{"Cansancio", "Diarrea"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver falso
        assertFalse(requiereAislamiento);
    }
    @Test
    public void Un_paciente_no_mayor_con_cansancio_tosSeca_no_requiere_aislamiento()
    {
        //Dado un paciente no mayor con cansancio y tos seca
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(2001,1,1);
        paciente.Sintomas = new String[]{"Cansancio", "Tos Seca"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver falso
        assertFalse(requiereAislamiento);
    }
    @Test
    public void Un_paciente_no_mayor_con_cansancio_tosSeca_fiebre_no_requiere_aislamiento()
    {
        //Dado un paciente no mayor con cansancio y tos seca
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(2001,1,1);
        paciente.Sintomas = new String[]{"Cansancio","Tos Seca","Fiebre"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver falso
        assertFalse(requiereAislamiento);
    }
    @Test
    public void Un_paciente_sin_edad_con_cansancio_tosSeca_fiebre_no_requiere_aislamiento()
    {
        //Dado un paciente sin edad con fiebre, cansancio y tos seca
        Paciente paciente = new Paciente();
        paciente.Sintomas = new String[]{"Cansancio","Tos Seca","Fiebre"};
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver falso
        assertFalse(requiereAislamiento);
    }
    @Test
    public void Un_paciente_mayor_sin_sintomas_no_requiere_aislamiento()
    {
        //Dado un paciente mayor sin sintomas
        Paciente paciente = new Paciente();
        paciente.FechaNacimiento = LocalDate.of(1940,1,1);
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver falso
        assertFalse(requiereAislamiento);
    }
    @Test
    public void Un_paciente_sin_edad_ni_sintomas_no_requiere_aislamiento()
    {
        //Dado un paciente mayor sin edad ni sintomas
        Paciente paciente = new Paciente();
        // Cuando chequeo si requiere o no aislamiento
        Boolean requiereAislamiento = paciente.RequiereAislamiento();
        // Entonces debe devolver falso
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
    public void Un_paciente_sin_nombre_pero_con_apellido_se_muestra_con_el_apellido()
    {
        // Dado un paciente con apellido, pero sin nombre
        Paciente paciente = new Paciente();
        paciente.Apellido1 = "Martinez";
        // Cuando calculo su nombre descriptivo
        String nombreDescriptivo = paciente.ApellidosComaNombre();
        // Entonces debe ser el apellido
        assertEquals(nombreDescriptivo, paciente.Apellido1);
    }
    @Test
    public void Un_paciente_sin_apellido_pero_con_nombre_se_muestra_con_el_nombre()
    {
        // Dado un paciente con nombre pero sin apellido
        Paciente paciente = new Paciente();
        paciente.Nombre = "Mikel";
        // Cuando calculo su nombre descriptivo
        String nombreDescriptivo = paciente.ApellidosComaNombre();
        // Entonces debe ser el nombre
        assertEquals(nombreDescriptivo, paciente.Nombre);
    }
    @Test
    public void Un_paciente_sin_apellido_ni_nombre_se_muestra_un_guion()
    {
        // Dado un paciente sin nombre ni apellido
        Paciente paciente = new Paciente();
        // Cuando calculo su nombre descriptivo
        String nombreDescriptivo = paciente.ApellidosComaNombre();
        // Entonces debe ser guion
        assertEquals(nombreDescriptivo, "-");
    }
}
