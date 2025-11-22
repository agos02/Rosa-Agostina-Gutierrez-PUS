//Importamos Estudiante y Materia para poder usarlos en el objeto
public class SolicitudInscripcion { //Define la clase pública SolicitudInscripcion.
    private Estudiante estudiante; //Atributo privado para almacenar una referencia al objeto Estudiante que realiza la solicitud.
    private Materia materia; //Atributo privado para almacenar una referencia al objeto Materia para la cual se realiza la solicitud.
    private String fechaSolicitud; //Atributo privado para registrar la fecha o momento en que se creó la solicitud.
    private String estado; //Atributo privado para rastrear el estado actual de la solicitud (ej: "Pendiente", "Aprobada", "Rechazada").

    public SolicitudInscripcion(Estudiante estudiante, Materia materia, String fechaSolicitud) { //Define el constructor que requiere el estudiante, la materia y la fecha/hora de la solicitud.
        this.estudiante = estudiante; //Inicializa el atributo estudiante con el valor proporcionado.
        this.materia = materia; //Inicializa el atributo materia con el valor proporcionado.
        this.fechaSolicitud = fechaSolicitud; //Inicializa el atributo fechaSolicitud con el valor proporcionado.
        this.estado = "Pendiente"; //Inicializa el estado de la solicitud como "Pendiente".
    }

    //Getters y Setters
    public Estudiante getEstudiante() { //Getter para obtener el objeto Estudiante asociado.
        return estudiante; 
    }
    public Materia getMateria() { 
        return materia; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
    public String getFechaSolicitud() { 
        return fechaSolicitud; 
    }   

   @Override
    public String toString() {
    //Sobrescribe el método toString() para generar una representación legible del objeto SolicitudInscripcion.
    //Incluyendo la fecha para que el campo también se use en la representación en cadena.
    return "Solicitud de: " + getEstudiante().getNombre() + //Llama al getter de Estudiante y luego a su método getNombre() para identificar al solicitante.
           " | Materia: " + getMateria().getNombre() + //Llama al getter de Materia y luego a su método getNombre() para identificar la materia solicitada.
           " | Estado: " + estado + //Incluye el estado actual de la solicitud.
           " | Fecha: " + fechaSolicitud; //Muestra la fecha de la solicitud (asegurando que el campo 'fechaSolicitud' sea usado).
    }
}