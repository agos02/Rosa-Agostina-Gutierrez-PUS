public class Persona {
    //ATRIBUTOS PRIVADOS (Encapsulamiento)
    private String nombre;
    private String apellido;
    private int edad;
    private String documento; //Atributo único que se usará para identificar a la Persona.

    //Constructor con parámetros
    public Persona(String nombre, String apellido, int edad, String documento) {
        //Llama a los métodos setters en lugar de asignar directamente para aplicar las validaciones.
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setDocumento(documento);
    }

    //Getters y Setters
    //Getter para obtener el nombre.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        //Solo asigna el nombre si no es nulo y no está vacío.
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        //Solo asigna el apellido si no es nulo y no está vacío.
        if (apellido != null && !apellido.isEmpty()) {
            this.apellido = apellido;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        //Solo asigna la edad si es mayor a 16.
        if (edad > 16) {
            this.edad = edad;
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        //Asigna el documento solo si no es nulo ni una cadena vacía.
        if (documento != null && !documento.isEmpty()) {
            this.documento = documento;
        }
    }

    //Muestra la información de los objetos de manera legible.
    public String toString(){
        return super.toString() + "Nombre: " + nombre + ", Apellido: " + apellido + "Edad: " + edad + ", Documento: " + documento;
    }


@Override // Método equals: define cuándo dos objetos Persona son iguales (basado en el documento).
    public boolean equals(Object o) { 
        if (this == o) return true; //Si son el mismo objeto en memoria, devuelve true.
        if (o == null || getClass() != o.getClass()) return false; //Si 'o' es nulo o no es de la clase Persona, devuelve false.
        
        //Convierte el objeto genérico 'o' a tipo Persona.
        Persona persona = (Persona) o;
        //Compara el atributo único 'documento'. Dos personas son iguales si tienen el mismo documento.
        return java.util.Objects.equals(documento, persona.documento);
    }

@Override
    public int hashCode() {
        // Se utiliza Objects.hash para generar el código hash basado en 'documento', asegurando que objetos iguales (mismo documento) tengan el mismo hash.
        return java.util.Objects.hash(documento);
    }
}