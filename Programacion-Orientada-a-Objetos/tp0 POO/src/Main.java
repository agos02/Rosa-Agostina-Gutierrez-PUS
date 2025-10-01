public class Main {
    public static void main(String[] args) {
        // Creamos la carrera
        Carrera carrera = new Carrera("Ingeniería en Sistemas");

        // Estudiante con constructor sin parámetros
        Estudiante e1 = new Estudiante();
        e1.setNombre("Lucía");
        e1.setApellido("Gómez");
        e1.setEdad(20);
        e1.setCarrera("Ingeniería en Sistemas");

        // Estudiantes con constructor con parámetros
        Estudiante e2 = new Estudiante("Tomás", "Pérez", 22, "Ingeniería en Sistemas", 0);
        Estudiante e3 = new Estudiante("Valentina", "Ruiz", 21, "Ingeniería en Sistemas", 0);

        // Agregamos materias
        e1.agregarMateria(new Materia("Programación", "INF101", 4, 9.0));
        e1.agregarMateria(new Materia("Matemática", "MAT102", 3, 8.5));

        e2.agregarMateria(new Materia("Física", "FIS103", 3, 7.0));
        e2.agregarMateria(new Materia("Diseño Web", "WEB104", 4, 8.0));

        e3.agregarMateria(new Materia("Bases de Datos", "BD105", 4, 9.5));
        e3.agregarMateria(new Materia("Algoritmos", "ALG106", 3, 9.0));

        // Calculamos promedio
        e1.calcularPromedio();
        e2.calcularPromedio();
        e3.calcularPromedio();

        // Creamos arreglo de estudiantes
        Estudiante[] estudiantes = { e1, e2, e3 };

        // Recorremos el arreglo e imprimimos nombre y promedio
        System.out.println("Promedios de estudiantes:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i].getNombre() + ": " + estudiantes[i].getPromedio());
        }

        // Agregamos estudiantes a la carrera
        carrera.agregarEstudiante(e1);
        carrera.agregarEstudiante(e2);
        carrera.agregarEstudiante(e3);

        // Mostramos todos los estudiantes de la carrera
        System.out.println("\nEstudiantes en la carrera:");
        carrera.listarEstudiantes();

        // Mostramos materias de todos los estudiantes
        System.out.println("\nMaterias de todos los estudiantes:");
        carrera.mostrarMateriasDeTodos();
    }
}
