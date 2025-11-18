import java.util.Objects; //Importa la clase Objects, necesaria para simplificar la implementación de equals y hashCode.
public class Materia {
    private String nombre; //Variable de instancia privada para almacenar el nombre de la materia.
    private String codigo;
    private int creditos;
    private double calificacion; //Variable de instancia privada para almacenar la calificación obtenida en la materia.
    private Profesor profesor;

    public Materia(String nombre, String codigo, int creditos, double calificacion) { //Define el constructor de la clase Materia que recibe cuatro parámetros.
        this.nombre = nombre; //Asigna el valor del parámetro 'nombre' a la variable de instancia 'nombre'.
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
        //El atributo 'profesor' no se inicializa acá, se asigna después con el setter.
    }

    public String getNombre() { //Definimos el método getter público para obtener el nombre.
        return nombre; //Devuelve el valor de la variable de instancia 'nombre'.
    }
    public String getCodigo() { 
        return codigo; 
    }
    public int getCreditos() { 
        return creditos; 
    }
    public double getCalificacion() { 
        return calificacion; 
    }

    public void setNombre(String nombre) { //Definimos el método setter público para establecer el nombre.
        this.nombre = nombre; //Asigna el valor del parámetro a la variable de instancia 'nombre'.
    }
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }
    public void setCreditos(int creditos) { 
        this.creditos = creditos; 
    }
    public void setCalificacion(double calificacion) { 
        this.calificacion = calificacion; 
    }

    public Profesor getProfesor(){
        return profesor;
    }

    public void setProfesor(Profesor profesor){ //Setter para asignar el objeto Profesor a la materia.
        this.profesor = profesor;
    }

    //Método toString, genera una representación legible del objeto.
    public String toString(){
        //Incluye todos los atributos, incluyendo la referencia al Profesor.
        return super.toString() + "Nombre: " + nombre + ", Código: " + codigo + "Créditos: " + creditos + ", Calificación: " + calificacion + ", Profesor: " + profesor;
    }

@Override  //Método equals, define cuándo dos objetos Materia son considerados iguales.
    public boolean equals(Object o) {
        if (this == o) return true; //Si son el mismo objeto en memoria, son iguales.
        if (o == null || getClass() != o.getClass()) return false; //Si 'o' es null o de otra clase, no son iguales.
        
        Materia materia = (Materia) o; //Se convierte el objeto genérico 'o' a tipo Materia.
        
        // Comparamos el atributo único 'codigo'
        return Objects.equals(codigo, materia.codigo);
    }

    @Override // Método hashCode, genera un código hash consistente con equals.
    public int hashCode() {
        // Genera el código hash basado solo en el atributo 'codigo', asegurando que dos materias con el mismo código tengan el mismo hash.
        return Objects.hash(codigo);
    }
}