import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ServicioAdmisionTest {
    @Test
    public void Un_paciente_con_nombre_apellido_fecha_nacimiento_sintomas_devuelve_objeto_Paciente_con_dos_sintomas()
    {
        //Dado un paciente del que tenemos toda la informacion
        ServicioAdmision servicio = new ServicioAdmision();
        String respuesta;
        respuesta = servicio.Ingresar("Mikel|Martinez|01/01/2001|Tos seca,Nauseas");
        assertEquals("objeto Paciente con dos síntomas",respuesta);
    }
}