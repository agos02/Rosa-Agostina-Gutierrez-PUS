public class GestorInscripciones {
    // Implementa la gestión de solicitudes en orden de llegada con FIFO
    private Cola<SolicitudInscripcion> solicitudesPendientes = new Cola<>(); //Declara un atributo privado que es una instancia de Cola. Esta Cola almacenará objetos de tipo SolicitudInscripcion.
    
    public void agregarSolicitud(SolicitudInscripcion solicitud) { //Se define el método público para agregar una nueva solicitud (Enqueue).
        System.out.println("-> Nueva solicitud de inscripción agregada: " + solicitud.getEstudiante().getNombre()); //Imprime un mensaje indicando qué estudiante agregó la solicitud.
        solicitudesPendientes.insertar(solicitud); //Llama al método 'insertar' (enqueue) de la Cola, agregando la solicitud al final de la cola (FIFO).
    }
    
    // Procesa la solicitud más antigua (DEQUEUE)
    public SolicitudInscripcion procesarSiguienteSolicitud() { //Define el método público para procesar y quitar la solicitud más antigua (Dequeue).
        if (solicitudesPendientes.estaVacia()) { //Comprueba si la Cola está vacía.
            System.out.println("No hay solicitudes pendientes para procesar."); //Si está vacía, imprime un mensaje indicando que no hay solicitudes pendientes.
            return null; //Devuelve null para indicar que no hay solicitudes para procesar.
        }
        SolicitudInscripcion solicitud = solicitudesPendientes.quitar(); //Llama al método 'quitar' (dequeue) de la Cola, eliminando y obteniendo la solicitud más antigua.
        solicitud.setEstado("Aprobada"); //Actualiza el estado de la solicitud a "Aprobada".
        System.out.println("<- Procesada (FIFO): " + solicitud.getEstudiante().getNombre() + " para " + solicitud.getMateria().getNombre()); //Imprime un mensaje indicando qué solicitud fue procesada.
        return solicitud; //Retorna la solicitud que fue procesada.
    }
    
    // Muestra el próximo a procesar (PEEK)
    public SolicitudInscripcion verSiguienteSolicitud() { //Define el método público para ver el próximo elemento sin quitarlo (Peek).
        if (solicitudesPendientes.estaVacia()) { //Comprueba si la Cola está vacía.
            return null; //Devuelve null si no hay solicitudes pendientes.
        }
        return solicitudesPendientes.ver(); //Llama al método 'ver' (peek) de la Cola para obtener el primer elemento sin modificar la Cola.
    }
    
    // Usa el método recursivo de Cola
    public void procesarRecursivamente() { //Define el método público para iniciar el procesamiento recursivo de toda la Cola.
        solicitudesPendientes.procesarRecursivamente(); //Llama al método recursivo 'procesarRecursivamente' de la Cola para procesar todas las solicitudes pendientes.
    }
}