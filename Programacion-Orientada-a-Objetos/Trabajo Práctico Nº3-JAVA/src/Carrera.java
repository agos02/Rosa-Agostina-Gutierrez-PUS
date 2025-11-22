// Carrera.java
import java.util.Arrays;

public class Carrera {
    private String nombre;
    private ListaEnlazada<Estudiante> estudiantes = new ListaEnlazada<>();

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) estudiantes.agregar(estudiante);
    }

    public void listarEstudiantes() {
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " " + e.getApellido());
        }
    }

    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre() != null && e.getNombre().equalsIgnoreCase(nombre)) return e;
        }
        return null;
    }

    public void mostrarMateriasDeTodos() {
        for (Estudiante e : estudiantes) {
            System.out.println("\nMaterias de " + e.getNombre() + ":");
            e.mostrarMaterias();
        }
    }

    @Override
    public String toString(){
        // convertir a array para mostrar (ejemplo)
        Estudiante[] arr = estudiantes.convertirAArray(Estudiante.class);
        return super.toString() + " Nombre: " + nombre + ", Estudiantes: " + Arrays.toString(arr);
    }
}
