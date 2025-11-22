public class HistorialCambios { //Define la clase pública HistorialCambios, que gestiona un registro de modificaciones.
    //Implementa la funcionalidad de "deshacer" con LIFO
    private Pila<CambioNota> historial = new Pila<>(); //Atributo privado que es una instancia de Pila. Esta Pila almacena objetos de tipo CambioNota.
    
    public void registrarCambio(CambioNota cambio) { //Define el método público para registrar una nueva modificación (PUSH).
        System.out.println("-> Registrando cambio: " + cambio); //Imprime un mensaje indicando que se está registrando un cambio, mostrando los detalles del cambio.
        historial.insertar(cambio); //Llama al método 'insertar' (push) de la Pila, agregando el objeto CambioNota a la "cima" (LIFO).
    }
    
    //Deshace el último cambio registrado (POP)
    public CambioNota deshacerUltimoCambio() { //Define el método público para revertir el último cambio (POP).
        if (historial.estaVacia()) { //Comprueba si la Pila (historial) está vacía.
            System.out.println("No hay cambios para deshacer."); //Si está vacía, imprime un mensaje indicando que no hay cambios para deshacer.
            return null; //Devuelve null, ya que no hay cambios que revertir.
        }
        CambioNota cambioDeshecho = historial.quitar(); //Llama al método 'quitar' (pop) de la Pila, eliminando y obteniendo el elemento de la cima (el último registrado).
        System.out.println("<- Deshecho (LIFO): " + cambioDeshecho.getEstudianteDocumento()); //Imprime un mensaje indicando que se ha deshecho un cambio, mostrando el documento del estudiante asociado al cambio.
        return cambioDeshecho; //Retorna el objeto CambioNota que fue deshecho (este objeto contendría la 'notaAnterior' que se usaría para reestablecer la calificación).
    }

    //Usa el método recursivo de Pila
    public void vaciarRecursivamente() { //Define un método público para vaciar completamente el historial usando recursión.
        historial.vaciarRecursivamente(); //Delega la llamada al método recursivo implementado dentro de la clase Pila.
    }
}