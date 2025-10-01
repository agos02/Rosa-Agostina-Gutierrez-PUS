
public class Carrera {
    private String nombre; //Se declara una variable de instancia privada para almacenar el nombre de la carrera (de tipo String).
    private Estudiante[] estudiantes = new Estudiante[20]; //Se declara un array privado de objetos Estudiante, inicializado con una capacidad máxima de 20.
    private int cantidadEstudiantes = 0; //Se declara e inicializa a 0 una variable privada para contar cuántos estudiantes hay realmente en el array.

    public Carrera(String nombre) { //Se define el constructor de la clase Carrera que acepta un parámetro String para el nombre.
        this.nombre = nombre; //Se asigna el valor del parámetro 'nombre' a la variable de instancia 'nombre'.
    }

    public void agregarEstudiante(Estudiante estudiante) { //Definimos un método público para añadir un objeto Estudiante a la carrera.
        if (cantidadEstudiantes < estudiantes.length) { //Comprueba si el array de estudiantes aún tiene espacio (si la cantidad actual es menor que la capacidad total).
            estudiantes[cantidadEstudiantes++] = estudiante; //Añade el objeto Estudiante al índice actual de cantidadEstudiantes y luego incrementa cantidadEstudiantes en 1.
        }
    }

    public void listarEstudiantes() { //Definimos un método público para imprimir los nombres y apellidos de todos los estudiantes.
        for (int i = 0; i < cantidadEstudiantes; i++) { //El bucle 'for' que itera desde el índice 0 hasta el número de estudiantes actuales (cantidadEstudiantes - 1).
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido());
        }
    }

    public Estudiante buscarEstudiante(String nombre) { //Definimos un método público para buscar un estudiante por su nombre, devuelve el objeto Estudiante o null.
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre)) { //Comprueba si el nombre del estudiante actual (obtenido con getNombre()) es igual al nombre buscado, ignorando mayúsculas/minúsculas.
                return estudiantes[i]; //Si encuentra una coincidencia, devuelve el objeto Estudiante.
            }
        }
        return null; //Si no encuentra ninguna coincidencia devuelve null.
    }

    public void mostrarMateriasDeTodos() { //Definimos un método público para mostrar las materias inscritas de cada estudiante.
        for (int i = 0; i < cantidadEstudiantes; i++) { 
            Estudiante e = estudiantes[i]; //Se asigna el estudiante actual a una variable local 'e' para facilitar la lectura.
            System.out.println("\nMaterias de " + e.getNombre() + ":"); //Imprime un encabezado indicando de qué estudiante se mostrarán las materias.
            e.mostrarMaterias(); //Llama al método mostrarMaterias() del objeto Estudiante para que imprima sus materias. 
        }
    }
}
