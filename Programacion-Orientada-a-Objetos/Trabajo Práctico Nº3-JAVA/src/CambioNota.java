public class CambioNota {
    private String estudianteDocumento; //Atributo privado para almacenar el identificador único del estudiante afectado.
    private String materiaCodigo; //Atributo privado para almacenar el código de la materia relacionada con el cambio de nota.
    private double notaAnterior; //Atributo privado para almacenar la nota anterior antes del cambio.
    private double notaNueva; //Atributo privado para almacenar la nueva nota después del cambio.
    private String fecha; //Atributo privado para almacenar la fecha en que se realizó el cambio de nota.

    //Define el constructor que recibe todos los atributos necesarios para crear un objeto CambioNota.
    public CambioNota(String estudianteDocumento, String materiaCodigo, double notaAnterior, double notaNueva, String fecha) {
        this.estudianteDocumento = estudianteDocumento; //Inicializa el identificador del estudiante con el valor pasado al constructor.
        this.materiaCodigo = materiaCodigo; //Inicializa el código de la materia con el valor pasado al constructor.
        this.notaAnterior = notaAnterior; //Inicializa la nota anterior con el valor pasado al constructor.
        this.notaNueva = notaNueva; //Inicializa la nueva nota con el valor pasado al constructor.
        this.fecha = fecha; //Inicializa la fecha con el valor pasado al constructor.
    }

    // Getters
    public String getEstudianteDocumento() { 
        return estudianteDocumento; 
    }
    
    public String getMateriaCodigo() { 
        return materiaCodigo; 
    }
    
    //Getter para la nota anterior (necesario para la lógica de deshacer)
    public double getNotaAnterior() { 
        return notaAnterior; 
    }

    //Getter para la nota nueva
    public double getNotaNueva() { 
        return notaNueva; 
    }

    //Getter para la fecha del cambio
    public String getFecha() { 
        return fecha; 
    }

    @Override
    public String toString() { //Sobrescribe el método estándar toString() para proporcionar una representación legible del objeto.
        return "Cambio - Estudiante(ID): " + estudianteDocumento + //Concatena la etiqueta y el documento del estudiante.
               ", Materia(Cod): " + materiaCodigo + //Concatena la etiqueta y el código de la materia.
               ", De: " + notaAnterior + " a " + notaNueva + //Concatena la etiqueta y las notas anterior y nueva.
               ", Fecha: " + fecha; //Concatena la etiqueta y la fecha del cambio.
    }
}
