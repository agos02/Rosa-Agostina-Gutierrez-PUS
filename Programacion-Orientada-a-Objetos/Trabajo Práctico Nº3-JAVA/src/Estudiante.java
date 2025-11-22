public class Estudiante extends Persona implements MiembroUniversidad { //Definimos una clase pública llamada Estudiante, HEREDA de Persona (atributos básicos), IMPLEMENTA la interfaz MiembroUniversidad (contrato de rol y obtener información).
    // Atributos privados para aplicar encapsulamiento
    private String carrera;
    private double promedio;

    // Antes era un array, ahora usamos una lista enlazada 
    private ListaEnlazada<Materia> materias = new ListaEnlazada<>();

    // Constructor sin parámetros
    public Estudiante() {
       super(null, null, 0, null); //Llama al constructor de la clase Persona inicializando los atributos heredados con valores nulos/cero.
    } 

    // Constructor con parámetros usando this
    public Estudiante(String nombre, String apellido, int edad, String documento , String carrera, double promedio) { //Se define un constructor que inicializa todos los atributos principales.
        super (nombre , apellido , edad , documento); //Llama al constructor de la clase base (Persona) para inicializar los atributos heredados.
        // Atributos propios de Estudiante
        this.carrera = carrera; //Asigna directamente el valor a la variable de instancia. No tiene ninguna lógica de validación dentro de su método setter.
        setPromedio(promedio); //Usa el setter para aplicar la validación de rango (0 a 10) al promedio.
    }

    // Getters y Setters con validaciones
    
    public String getCarrera() { 
        return carrera; 
    }
    public void setCarrera(String carrera) { 
        this.carrera = carrera; 
    }
    public double getPromedio() { 
        return promedio; 
    }
    //Setter con validación para asegurar que el promedio esté en un rango válido.
    public void setPromedio(double promedio) { //Método setter para establecer el promedio.
        if (promedio >= 0 && promedio <= 10) this.promedio = promedio; //Asigna el promedio solo si está en el rango de 0 a 10.
    }

     // Agregamos una materia a la lista enlazada del estudiante
    public void agregarMateria(Materia materia) {
        if (materia != null) {
            materias.agregar(materia);
        }
    }

     // Cálculo del promedio de manera iterativa (más fácil)
    public double calcularPromedio() {
        if (materias.size() == 0) return 0.0;

        double suma = 0.0;
        int contador = 0;
        Nodo<Materia> actual = materias.getPrimero();

        while (actual != null) {
            Materia m = actual.dato;
            suma += m.getCalificacion();
            contador++;
            actual = actual.siguiente;
        }

        promedio = (contador == 0) ? 0.0 : suma / contador;
        return promedio;
    }

     // Método que usa recursión 
    public double calcularPromedioRecursivo() {
        return calcularPromedioRecursivo(materias.getPrimero(), 0, 0.0);
    }

    // Acá sí usamos los nodos para recorrer recursivamente
    public double calcularPromedioRecursivo(Nodo<Materia> actual, int contador, double suma) {
        // Caso base: llegamos al final
        if (actual == null) {
            return contador == 0 ? 0.0 : suma / contador;
        }

        Materia m = actual.dato;

        // Llamada recursiva: avanzar al siguiente nodo
        return calcularPromedioRecursivo(
                actual.siguiente,
                contador + 1,
                suma + m.getCalificacion()
        );
    }


    // Muestra todas las materias usando foreach (Iterable)
    public void mostrarMaterias() {
        for (Materia m : materias) {
            System.out.println("- " + m.getNombre() + ": " + m.getCalificacion());
        }
    }

    //Método toString, Muestra la información de los objetos de manera legible.
    //Concatena la información heredada (Persona) y la propia (Carrera, Promedio).
    public String toString() {
        return "Nombre: " + getNombre() + ", " +
               "Apellido: " + getApellido() + ", " +
               "Edad: " + getEdad() + ", " +
               "Documento: " + getDocumento() + ", " +
               "Carrera: " + carrera + ", " +
               "Promedio: " + promedio;
    }

    //Implementacion de metodos de la interfaz MiembroUniversidad
    //Método para devolver el rol del miembro en la universidad.
    @Override
    public String obtenerRol() {
        return "Estudiante"; //Devuelve el rol específico de esta clase.
    }

    //Método para devolver toda la información del miembro.
    @Override
    public String obtenerInformacionCompleta() {
        // Reutilizamos el método toString() para la información completa
        return this.toString();
    }
}
