public class Universidad {
    private String nombre; //Variable de instancia privada para almacenar el nombre de la universidad.
    private String direccion;
    private Estudiante[] estudiantes = new Estudiante[100]; //Declaramos un array privado de objetos Estudiante, inicializado con una capacidad máxima de 100.
    private int cantidadEstudiantes = 0; //Contador para el número actual de estudiantes inscritos (inicializado a 0).

    public Universidad(String nombre, String direccion) { //Definimos el constructor de la clase Universidad que acepta el nombre y la dirección.
        this.nombre = nombre; //Asigna el valor del parámetro 'nombre' a la variable de instancia 'nombre'.
        this.direccion = direccion; //Asigna el valor del parámetro 'direccion' a la variable de instancia 'direccion'.
    }

    public void agregarEstudiante(Estudiante estudiante) { //Definimos un método público para añadir un objeto Estudiante a la universidad.
        if (cantidadEstudiantes < estudiantes.length) { //Comprueba si el array de estudiantes aún tiene espacio (si la cantidad actual es menor que la capacidad total).
            estudiantes[cantidadEstudiantes++] = estudiante; //Añade el objeto Estudiante al índice actual y luego incrementa el contador cantidadEstudiantes en 1.
        }
    }

    public void mostrarEstudiantes() { //Definimos un método público para imprimir en consola el nombre completo de todos los estudiantes.
        for (int i = 0; i < cantidadEstudiantes; i++) { //Inicia un bucle 'for' que itera desde el índice 0 hasta el número de estudiantes actuales (cantidadEstudiantes - 1).
            System.out.println(estudiantes[i].getNombre() + " " + estudiantes[i].getApellido()); //Imprime el nombre y el apellido del estudiante en la posición 'i'.
        }
    }
}