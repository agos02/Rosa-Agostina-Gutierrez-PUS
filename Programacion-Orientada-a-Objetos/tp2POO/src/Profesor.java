public class Profesor extends Persona implements MiembroUniversidad { //Definimos la clase Profesor, que HEREDA de Persona y CUMPLE el contrato de MiembroUniversidad.
    private String especialidad; //Especialización del profesor
    private int añosExperiencia;

    // Lista enlazada de materias asignadas (antes era array)
    private ListaEnlazada<Materia> materiasAsignadas = new ListaEnlazada<>();

    //Constructor que recibe todos los atributos (heredados y propios).
    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, int añosExperiencia) {
        //Llama al constructor de la clase base Persona para inicializar los atributos heredados.
        super(nombre, apellido, edad, documento);
        //Inicializa los atributos propios.
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }

    //GETTERS Y SETTERS
    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia(){
        return añosExperiencia;
    }
    public void setAñosExperiencia(int añosExperiencia){
        this.añosExperiencia = añosExperiencia;
    }

    // Agregamos una materia siempre que no se pase del máximo de 5
    public void asignarMateria(Materia materia) {
        if (materia == null) return;

        // usamos size() de la lista genérica
        if (materiasAsignadas.size() < 5) {
            materiasAsignadas.agregar(materia);
        } else {
            System.out.println("El profesor " + getNombre() + " ya tiene el máximo de materias asignadas.");
        }
    }

    public ListaEnlazada<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    //Método requerido por la interfaz: define el rol del miembro.
    @Override
    public String obtenerRol() {
        return "Profesor"; //Devuelve el rol específico.
    }

    //Método requerido por la interfaz: devuelve toda la información.
    @Override
    public String obtenerInformacionCompleta() {
        //Llama al método toString() para generar la cadena de información completa.
        return this.toString();
    }

    //Método toString, Muestra la información de los objetos de manera legible.
    public String toString() {
        //Concatena la información heredada de Persona y los atributos propios.
        return "Nombre: " + getNombre() + ", " +
               "Apellido: " + getApellido() + ", " +
               "Edad: " + getEdad() + ", " +
               "Documento: " + getDocumento() + ", " +
               "Especialidad: " + especialidad + ", " +
               "Años Experiencia: " + añosExperiencia  ;
    }

}
