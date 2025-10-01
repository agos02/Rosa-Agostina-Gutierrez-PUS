public class Universidad {
    private String nombre;
    private String direccion;
    private Estudiante[] estudiantes = new Estudiante[100];
    private int cantidadEstudiantes = 0;

    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (cantidadEstudiantes < estudiantes.length) {
            estudiantes[cantidadEstudiantes++] = estudiante;
        }
    }

    public void mostrarEstudiantes() {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido());
        }
    }
}
