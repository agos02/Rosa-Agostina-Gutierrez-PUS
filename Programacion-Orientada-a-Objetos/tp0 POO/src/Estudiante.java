public class Estudiante {
    // Atributos privados para aplicar encapsulamiento
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;

    // Array de materias (máximo 10 por estudiante)
    private Materia[] materias = new Materia[10];
    private int cantidadMaterias = 0;

    // Constructor sin parámetros
    public Estudiante() {}

    // Constructor con parámetros usando this
    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        this.carrera = carrera;
        setPromedio(promedio);
    }

    // Getters y Setters con validaciones
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) this.nombre = nombre;
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        if (apellido != null && !apellido.isEmpty()) this.apellido = apellido;
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad > 16) this.edad = edad;
    }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) {
        if (promedio >= 0 && promedio <= 10) this.promedio = promedio;
    }

    // Método para agregar una materia
    public void agregarMateria(Materia materia) {
        if (cantidadMaterias < materias.length) {
            materias[cantidadMaterias++] = materia;
        }
    }

    // Método para calcular el promedio de calificaciones
    public double calcularPromedio() {
        if (cantidadMaterias == 0) return 0.0;
        double suma = 0;
        for (int i = 0; i < cantidadMaterias; i++) {
            suma += materias[i].getCalificacion();
        }
        promedio = suma / cantidadMaterias;
        return promedio;
    }

    // Mostrar materias del estudiante
    public void mostrarMaterias() {
        for (int i = 0; i < cantidadMaterias; i++) {
            System.out.println("- " + materias[i].getNombre() + ": " + materias[i].getCalificacion());
        }
    }
}
