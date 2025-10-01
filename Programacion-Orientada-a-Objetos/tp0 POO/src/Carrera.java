public class Carrera {
    private String nombre;
    private Estudiante[] estudiantes = new Estudiante[20];
    private int cantidadEstudiantes = 0;

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (cantidadEstudiantes < estudiantes.length) {
            estudiantes[cantidadEstudiantes++] = estudiante;
        }
    }

    public void listarEstudiantes() {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido());
        }
    }

    public Estudiante buscarEstudiante(String nombre) {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    public void mostrarMateriasDeTodos() {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            Estudiante e = estudiantes[i];
            System.out.println("\nMaterias de " + e.getNombre() + ":");
            e.mostrarMaterias();
        }
    }
}
