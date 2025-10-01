public class Estudiante { //Definimos una clase pública llamada Estudiante.
    // Atributos privados para aplicar encapsulamiento
    private String nombre; //Variable de instancia privada para el nombre del estudiante.
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;

    // Array de materias (máximo 10 por estudiante)
    private Materia[] materias = new Materia[10]; //Declaramos un array privado de objetos Materia, limitado a 10.
    private int cantidadMaterias = 0; // Contador para el número actual de materias inscritas (inicializado a 0).

    // Constructor sin parámetros
    public Estudiante() {

    } 

    // Constructor con parámetros usando this
    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio) { //Se define un constructor que inicializa todos los atributos principales.
        setNombre(nombre); //Llama al setter con validación para asignar el nombre.
        setApellido(apellido);
        setEdad(edad);
        this.carrera = carrera; //Asigna directamente el valor a la variable de instancia. No tiene ninguna lógica de validación dentro de su método setter.
        setPromedio(promedio);
    }

    // Getters y Setters con validaciones
    public String getNombre() { //Método getter para obtener el nombre.
        return nombre; 
    }
    public void setNombre(String nombre) { //Método setter para establecer el nombre.
        if (nombre != null && !nombre.isEmpty()) this.nombre = nombre; //Asigna el nombre solo si no es nulo y no está vacío.
    }

    public String getApellido() { //Método getter para obtener el apellido.
        return apellido; 
    }
    public void setApellido(String apellido) { //Método setter para establecer el apellido.
        if (apellido != null && !apellido.isEmpty()) this.apellido = apellido; //Asigna el apellido solo si no es nulo y no está vacío.
    }

    public int getEdad() { 
        return edad; 
    }
    public void setEdad(int edad) { //Método setter para establecer la edad.
        if (edad > 16) this.edad = edad; //Asigna la edad solo si es mayor que 16 (validación de edad mínima).
    }

    public String getCarrera() { 
        return carrera; 
    }
    public void setCarrera(String carrera) { 
        this.carrera = carrera; 
    }

    public double getPromedio() { 
        return promedio; 
    }
    public void setPromedio(double promedio) { //Método setter para establecer el promedio.
        if (promedio >= 0 && promedio <= 10) this.promedio = promedio; //Asigna el promedio solo si está en el rango de 0 a 10.
    }

    // Método para agregar una materia
    public void agregarMateria(Materia materia) { //Definimos un método para añadir una Materia al array.
        if (cantidadMaterias < materias.length) { //Comprueba si el array de materias no ha alcanzado su capacidad máxima (10).
            materias[cantidadMaterias++] = materia; //Añade el objeto Materia al siguiente espacio disponible y luego incrementa el contador de materias.
        }
    }

    // Método para calcular el promedio de calificaciones
    public double calcularPromedio() { //Definimos un método que calcula el promedio de las calificaciones.
        if (cantidadMaterias == 0) return 0.0; //Si no hay materias, devuelve 0.0 para evitar división por cero.
        double suma = 0; //Inicializa una variable para acumular la suma de las calificaciones.
        for (int i = 0; i < cantidadMaterias; i++) { //Itera sobre todas las materias inscritas.
            suma += materias[i].getCalificacion(); //Suma la calificación de la materia actual a la variable 'suma'.
        }
        promedio = suma / cantidadMaterias;  //Calcula el promedio dividiendo la suma por la cantidad de materias y lo asigna al atributo 'promedio'.
        return promedio; //Devuelve el Resultado.
    }

    // Mostrar materias del estudiante
    public void mostrarMaterias() { //Definimos un método para imprimir las materias y sus calificaciones.
        for (int i = 0; i < cantidadMaterias; i++) {
            System.out.println("- " + materias[i].getNombre() + ": " + materias[i].getCalificacion()); //Imprime el nombre y la calificación de la materia actual.
        }
    }
}