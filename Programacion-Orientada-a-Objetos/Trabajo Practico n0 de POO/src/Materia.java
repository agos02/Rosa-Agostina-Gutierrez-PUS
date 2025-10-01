public class Materia {
    private String nombre; //Variable de instancia privada para almacenar el nombre de la materia.
    private String codigo;
    private int creditos;
    private double calificacion; //Variable de instancia privada para almacenar la calificación obtenida en la materia.

    public Materia(String nombre, String codigo, int creditos, double calificacion) { //Define el constructor de la clase Materia que recibe cuatro parámetros.
        this.nombre = nombre; //Asigna el valor del parámetro 'nombre' a la variable de instancia 'nombre'.
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
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
}