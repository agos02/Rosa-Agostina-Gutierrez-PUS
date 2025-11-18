//DEFINICIÓN DE INTERFAZ
public interface MiembroUniversidad {
   //Una interfaz define un CONTRATO. Cualquier clase que 'implemente' (implements) esta interfaz debe obligatoriamente proporcionar una definición (cuerpo) para todos los métodos listados aquí.
   //Este contrato establece dos acciones obligatorias para cualquier persona u objeto que se considere parte de la institución.

   //Método abstracto: Obliga a la clase implementadora a definir cómo obtener su rol.
   //Permite que la clase Universidad trate a Estudiante, Profesor y Personal de forma genérica.
   String obtenerRol(); 

   //Método abstracto: Obliga a la clase implementadora a definir cómo obtener toda su información.
   //Es la clave para el Polimorfismo (la capacidad de que un mismo método haga cosas distintas según el objeto).
   String obtenerInformacionCompleta();
}