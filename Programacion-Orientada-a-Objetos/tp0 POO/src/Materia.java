public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;

    public Materia(String nombre, String codigo, int creditos, double calificacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
    }

    public String getNombre() { 
        return nombre; 
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

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
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
