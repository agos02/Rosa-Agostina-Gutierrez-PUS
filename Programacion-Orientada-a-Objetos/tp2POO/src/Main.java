public class Main { //Definimos la clase pública principal donde comienza la ejecución del programa.
    public static void main(String[] args) {
        //Creamos la carrera
        Carrera carrera = new Carrera("Programador Univesitario"); //Creamos una nueva instancia de la clase Carrera con el nombre "Programador Universitario".

        //Estudiante con constructor sin parámetros
        Estudiante e1 = new Estudiante(); //Crea una nueva instancia de Estudiante usando el constructor sin parámetros.
        e1.setNombre("Lucía"); //Asigna el nombre "Lucía" usando el método setter.
        e1.setApellido("Perazzolo"); 
        e1.setEdad(25);
        e1.setDocumento("42.799.841");
        e1.setCarrera("Programador Univesitario");
        
        //Estudiantes con constructor con parámetros
        Estudiante e2 = new Estudiante("Agostina", "Gutierrez", 22, "44.953.861", "Programador Univesitario", 0);
        Estudiante e3 = new Estudiante("Ramiro", "Pereira", 20 , "45.995.692" , "Programador Univesitario", 0);

        //Crear la Universidad
        Universidad universidad = new Universidad("Unvime", "Sede Los Poetas");

        //Crear profesor y administracion
        Profesor p1 = new Profesor("Vanesa", "Torres", 33, "35.456.789", "Licenciada en Informática", 10);
        Profesor p2 = new Profesor("Reynaldo" , "Gomez" , 40 , "30.234.543" , "Ingeniero en sistemas", 20);
        Personal admin1 = new Personal("Javier", "Lopez", 35, "30.000.111", "Recursos Humanos", "Jefe de Personal", "2019-03-01");
        
        //Agregamos miembros a la universidad usando metodo
        universidad.agregarMiembro(e1); // Estudiante
        universidad.agregarMiembro(e2); // Estudiante
        universidad.agregarMiembro(e3); // Estudiante
        universidad.agregarMiembro(p1); // Profesor
        universidad.agregarMiembro(p2); //Profesor
        universidad.agregarMiembro(admin1); // Personal
        
        //Agregamos materias a estudiantes
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

        //--- ORDENAMIENTO ---
        System.out.println("\n--- Ordenando estudiantes por Apellido ---"); //Imprime un encabezado.
        // Convertimos el array a ListaEnlazada para usar los métodos que trabajan con listas
        ListaEnlazada<Estudiante> listaEstudiantes = ListaEnlazada.convertirArrayALista(estudiantes);
        // Llama al método estático para ordenar la lista (devuelve ListaEnlazada ordenada)
        ListaEnlazada<Estudiante> listaOrdenada = Universidad.ordenarEstudiantesPorApellido(listaEstudiantes);
        // Imprimimos los estudiantes ordenados iterando la lista
        for (Estudiante e : listaOrdenada) { //Itera sobre la lista ordenada.
            System.out.println(e.getApellido() + ", " + e.getNombre()); //Imprime el apellido y nombre ordenados.
        }

        //--- BÚSQUEDA BINARIA ---
        System.out.println("\n--- Búsqueda Binaria por Apellido ---"); //Imprime un encabezado.
        String apellidoBuscado = "Pereira"; //Define el valor a buscar.
        // Llamamos a la búsqueda binaria que recibe la lista ordenada
        int indiceEncontrado = Universidad.busquedaBinariaEstudiantes(listaOrdenada, apellidoBuscado); //Busca el apellido en la lista ordenada (internamente convierte a array).

        if (indiceEncontrado != -1) { //Verifica si el índice es diferente de -1 (encontrado).
            // Convertimos la lista ordenada a array para acceder por índice y mostrar el nombre
            Estudiante[] arrOrden = listaOrdenada.convertirAArray(Estudiante.class);
            System.out.println("Estudiante encontrado en el índice " + indiceEncontrado + ": " + arrOrden[indiceEncontrado].getNombre()); //Imprime la ubicación y el nombre del estudiante.
        } else {
            System.out.println("Estudiante con apellido " + apellidoBuscado + " no encontrado."); //Imprime el mensaje de no encontrado.
        }

        //Listar todos los miembros 
        System.out.println("\n---Todos los miembros de la universidad:---");
        universidad.listarTodosLosMiembros(); //Llama al método de Universidad para listar toda la información de los miembros.
        // Buscar por rol
        universidad.listarMiembrosPorRol("Estudiante"); //Llama al método para listar solo los miembros con rol "Estudiante".
        universidad.listarMiembrosPorRol("Profesor"); //Llama al método para listar solo los miembros con rol "Profesor".
        universidad.listarMiembrosPorRol("Personal"); //Llama al método para listar solo los miembros con rol "Personal".

        //Recorremos el arreglo e imprimimos nombre y promedio
        System.out.println("\n---Promedios de estudiantes:---\n");
        for (int i = 0; i < estudiantes.length; i++) { //Inicia un bucle 'for' para recorrer el array de estudiantes.
            System.out.println(estudiantes[i].getNombre() + ": " + estudiantes[i].getPromedio()); //Imprime el nombre y el promedio de cada estudiante.
        }

        // Agregamos estudiantes a la carrera
        carrera.agregarEstudiante(e1); //Llama al método de Carrera para añadir a Lucía y así con los démas.
        carrera.agregarEstudiante(e2);
        carrera.agregarEstudiante(e3);

        // Mostramos todos los estudiantes de la carrera
        System.out.println("\n---Estudiantes en la carrera:---\n");
        carrera.listarEstudiantes(); //Llama al método de Carrera para imprimir la lista de nombres y apellidos de los estudiantes.

        // Mostramos materias de todos los estudiantes
        System.out.println("\n---Materias de todos los estudiantes:---");
        carrera.mostrarMateriasDeTodos(); //Llama al método de Carrera para listar las materias de cada estudiante.

        for (MiembroUniversidad miembro : universidad.getMiembros()) { //Inicia un bucle para iterar sobre todos los miembros usando la interfaz.
            System.out.println("\nTipo de miembro: " + miembro.obtenerRol()); //Llama al método 'obtenerRol'.
            System.out.println("Información completa: " + miembro.obtenerInformacionCompleta()); // Llama al método 'obtenerInformacionCompleta'.
        }
    

    System.out.println("\n--- Demostración de Polimorfismo ---");
    
        // Procesamos todos los miembros de la universidad sin importar su tipo concreto
        for (MiembroUniversidad miembro : universidad.getMiembros()) {  //Itera nuevamente sobre la lista de la interfaz MiembroUniversidad.
            System.out.println("\nTipo de miembro: " + miembro.obtenerRol()); //El método llamado se resuelve en tiempo de ejecución para cada tipo (Profesor, Estudiante, Personal).
            System.out.println("Información completa: " + miembro.obtenerInformacionCompleta()); 
        }

    }
}
