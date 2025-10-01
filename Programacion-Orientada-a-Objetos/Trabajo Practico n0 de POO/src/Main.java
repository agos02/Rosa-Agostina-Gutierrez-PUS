public class Main { //Definimos la clase pública principal donde comienza la ejecución del programa.
    public static void main(String[] args) {
        // Creamos la carrera
        Carrera carrera = new Carrera("Programador Univesitario"); //Creamos una nueva instancia de la clase Carrera con el nombre "Programador Universitario".

        // Estudiante con constructor sin parámetros
        Estudiante e1 = new Estudiante(); //Crea una nueva instancia de Estudiante usando el constructor sin parámetros.
        e1.setNombre("Lucía"); //Asigna el nombre "Lucía" usando el método setter.
        e1.setApellido("Perazzolo"); 
        e1.setEdad(25);
        e1.setCarrera("Programador Univesitario");

        // Estudiantes con constructor con parámetros
        Estudiante e2 = new Estudiante("Agostina", "Gutierrez", 21, "Programador Univesitario", 0);
        Estudiante e3 = new Estudiante("Ramiro", "Pereira", 20, "Programador Univesitario", 0);

        // Agregamos materias
        e1.agregarMateria(new Materia("Programación", "INF101", 4, 9.0)); //Crea una nueva Materia y la agrega al estudiante e1.
        e1.agregarMateria(new Materia("Matemática", "MAT102", 3, 8.5));

        e2.agregarMateria(new Materia("Física", "FIS103", 3, 7.0)); //Crea una nueva Materia y la agrega al estudiante e2.
        e2.agregarMateria(new Materia("Diseño Web", "WEB104", 4, 8.0));

        e3.agregarMateria(new Materia("Bases de Datos", "BD105", 4, 9.5)); //Crea una nueva Materia y la agrega al estudiante e3.
        e3.agregarMateria(new Materia("Algoritmos", "ALG106", 3, 9.0));

        // Calculamos promedio
        e1.calcularPromedio(); //Llama al método para calcular y actualizar el promedio de e1 y así con los démas
        e2.calcularPromedio();
        e3.calcularPromedio();

        // Creamos arreglo de estudiantes
        Estudiante[] estudiantes = { e1, e2, e3 }; //Creamos un array de Estudiante y lo inicializa con los objetos creados (e1, e2, e3).

        // Recorremos el arreglo e imprimimos nombre y promedio
        System.out.println("Promedios de estudiantes:");
        for (int i = 0; i < estudiantes.length; i++) { //Inicia un bucle 'for' para recorrer el array de estudiantes.
            System.out.println(estudiantes[i].getNombre() + ": " + estudiantes[i].getPromedio()); //Imprime el nombre y el promedio de cada estudiante.
        }

        // Agregamos estudiantes a la carrera
        carrera.agregarEstudiante(e1); //Llama al método de Carrera para añadir a Lucía y así con los démas.
        carrera.agregarEstudiante(e2);
        carrera.agregarEstudiante(e3);

        // Mostramos todos los estudiantes de la carrera
        System.out.println("\nEstudiantes en la carrera:");
        carrera.listarEstudiantes(); //Llama al método de Carrera para imprimir la lista de nombres y apellidos de los estudiantes.

        // Mostramos materias de todos los estudiantes
        System.out.println("\nMaterias de todos los estudiantes:");
        carrera.mostrarMateriasDeTodos(); //Llama al método de Carrera para listar las materias de cada estudiante.
    }
}