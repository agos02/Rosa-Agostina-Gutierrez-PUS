// Universidad.java
public class Universidad {
    private String nombre;
    private String direccion;
    private ListaEnlazada<MiembroUniversidad> miembros; // ahora genérico

    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.miembros = new ListaEnlazada<>();
    }

    public ListaEnlazada<MiembroUniversidad> getMiembros() { return miembros; }

    // Agrega manteniendo orden por apellido (usa el método genérico)
    public void agregarMiembro(MiembroUniversidad miembro) {
        if (miembro != null) {
            miembros.agregarEnOrdenPorApellido(miembro);
            System.out.println(miembro.obtenerRol() + " " + ((Persona)miembro).getNombre() + " agregado a la universidad.");
        }
    }

    public void listarTodosLosMiembros() {
        System.out.println("\n--- Miembros de la Universidad " + this.nombre + " ---");
        if (miembros.size() == 0) {
            System.out.println("No hay miembros registrados.");
            return;
        }
        for (MiembroUniversidad m : miembros) {
            System.out.println("[" + m.obtenerRol() + "] " + m.obtenerInformacionCompleta());
        }
    }

    public void listarMiembrosPorRol(String rolBuscado) {
        System.out.println("\n--- Listado de " + rolBuscado + " ---");
        boolean encontrado = false;
        for (MiembroUniversidad m : miembros) {
            if (m.obtenerRol().equalsIgnoreCase(rolBuscado)) {
                System.out.println(m.obtenerInformacionCompleta());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron miembros con el rol: " + rolBuscado);
    }

    @Override
    public String toString() {
        return super.toString() + " Nombre: " + nombre + ", Dirección: " + direccion + ", Total de Miembros: " + miembros.size();
    }

    // Ejemplos adaptados usando ListaEnlazada<Estudiante>
    public static int contarEstudiantesIterativo(ListaEnlazada<Estudiante> estudiantes, String carrera) {
        if (estudiantes == null) return 0;
        int total = 0;
        for (Estudiante e : estudiantes) {
            if (e != null && carrera != null && carrera.equalsIgnoreCase(e.getCarrera())) total++;
        }
        return total;
    }

    public static int contarEstudiantesRecursivo(ListaEnlazada<Estudiante> estudiantes, String carrera) {
        if (estudiantes == null) return 0;
        return contarRecursivo(estudiantes.getPrimero(), carrera);
    }
    private static int contarRecursivo(Nodo<Estudiante> actual, String carrera) {
        if (actual == null) return 0;
        Estudiante e = actual.dato;
        int sum = (e != null && carrera != null && carrera.equalsIgnoreCase(e.getCarrera())) ? 1 : 0;
        return sum + contarRecursivo(actual.siguiente, carrera);
    }

    public static Estudiante buscarEstudianteIterativo(ListaEnlazada<Estudiante> estudiantes, String documento) {
        if (estudiantes == null) return null;
        for (Estudiante e : estudiantes) {
            if (e != null && documento != null && documento.equals(e.getDocumento())) return e;
        }
        return null;
    }

    public static Estudiante buscarEstudianteRecursivo(ListaEnlazada<Estudiante> estudiantes, String documento) {
        if (estudiantes == null) return null;
        return buscarRecursivo(estudiantes.getPrimero(), documento);
    }
    private static Estudiante buscarRecursivo(Nodo<Estudiante> actual, String documento) {
        if (actual == null) return null;
        Estudiante e = actual.dato;
        if (e != null && documento != null && documento.equals(e.getDocumento())) return e;
        return buscarRecursivo(actual.siguiente, documento);
    }

    // Ordenar: convertimos a array y usamos selection sort, luego reconstruimos lista
    public static ListaEnlazada<Estudiante> ordenarEstudiantesPorApellido(ListaEnlazada<Estudiante> estudiantes) {
        Estudiante[] arr = estudiantes.convertirAArray(Estudiante.class);
        if (arr == null || arr.length <= 1) return ListaEnlazada.convertirArrayALista(arr);

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getApellido().compareToIgnoreCase(arr[idxMin].getApellido()) < 0) {
                    idxMin = j;
                }
            }
            if (idxMin != i) {
                Estudiante tmp = arr[i];
                arr[i] = arr[idxMin];
                arr[idxMin] = tmp;
            }
        }
        return ListaEnlazada.convertirArrayALista(arr);
    }

    public static int busquedaBinariaEstudiantes(ListaEnlazada<Estudiante> estudiantes, String apellido) {
        Estudiante[] arr = estudiantes.convertirAArray(Estudiante.class);
        if (arr == null) return -1;
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int cmp = apellido.compareToIgnoreCase(arr[medio].getApellido());
            if (cmp == 0) return medio;
            else if (cmp < 0) fin = medio - 1;
            else inicio = medio + 1;
        }
        return -1;
    }
}
