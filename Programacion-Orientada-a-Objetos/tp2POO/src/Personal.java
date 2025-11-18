public class Personal extends Persona implements MiembroUniversidad{//Definimos la clase Personal, que HEREDA de Persona y CUMPLE el contrato de MiembroUniversidad.
    private String departamento; //Departamento donde trabaja
    private String puestos; //Puesto o cargo específico
    private String fechaIngreso; //Fecha en la que el personal comenzó a trabajar en la universidad.

 //Constructor que recibe todos los atributos (heredados y propios).
 public Personal ( String nombre, String apellido, int edad, String documento , String departamento , String puestos , String fechaIngreso){
    //Llama al constructor de la clase base Persona para inicializar los atributos heredados.
    super(nombre,apellido,edad,documento);
    //Inicializa los atributos propios, usando los setters.
    setDepartamento(departamento);
    setPuestos(puestos);
    setFechaIngreso(fechaIngreso);
 }   

 //GETTERS Y SETTERS
public String getDepartamento(){
    return departamento;
}

public void setDepartamento(String departamento){
    this.departamento = departamento;
}

public String getPuestos(){
    return puestos;
}

public void setPuestos(String puestos){
    this.puestos = puestos;
}

public String getFechaIngreso(){
    return fechaIngreso;
}

public void setFechaIngreso(String fechaIngreso){
    this.fechaIngreso = fechaIngreso;
}

    //Implementación de los métodos de la interfaz MiembroUniversidad
    //Método requerido por la interfaz: define el rol del miembro.
    @Override
    public String obtenerRol() {
        return "Personal"; //Devuelve el rol específico.
    }

    //Método requerido por la interfaz: devuelve toda la información.
    @Override
    public String obtenerInformacionCompleta() {
        //Llama al método toString() para generar la cadena de información completa.
        return this.toString();
    }

    //Método toString, Muestra la información de los objetos de manera legible.
    //Concatena la información heredada de Persona (usando getters) y los atributos propios.
    public String toString() {
        return "Nombre: " + getNombre() + ", " +
           "Apellido: " + getApellido() + ", " +
           "Edad: " + getEdad() + ", " +
           "Documento: " + getDocumento() + ", " +
           "Departamento: " + departamento + ", " +
           "Puesto: " + puestos + ", " +
           "Fecha Ingreso: " + fechaIngreso;
    }

}