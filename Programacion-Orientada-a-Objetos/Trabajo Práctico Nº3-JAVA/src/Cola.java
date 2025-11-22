import java.util.NoSuchElementException; //Importa la excepción necesaria para manejar errores cuando se intenta quitar o ver un elemento de una cola vacía.

public class Cola<T> { //Define la clase genérica Cola, que puede almacenar cualquier tipo de dato (T).
    private ListaEnlazada<T> lista = new ListaEnlazada<>(); //Atributo interno, la Cola usa una instancia de ListaEnlazada para gestionar sus elementos.

    //Insertar (enqueue), agrega un elemento al "final" de la cola.
    public void insertar(T dato) { //Define el método 'enqueue' (insertar) que recibe el dato a agregar.
        lista.agregar(dato); //Agrega el dato al final de la ListaEnlazada, que representa la parte trasera de la cola.
    }

    //Quitar (dequeue), elimina y devuelve el elemento del "frente" (el primero). O(1)
    public T quitar() { //Define el método 'dequeue' (quitar), que elimina y devuelve el elemento del frente de la cola.
        if (estaVacia()) { //Comprueba si la cola está vacía antes de intentar quitar.
            throw new NoSuchElementException("La cola está vacía."); //Lanza una excepción si la cola está vacía.
        }
        return lista.quitarPrimero(); //Llama al método 'quitarPrimero' de la ListaEnlazada para remover el elemento del frente (O(1)).
    }

    // Ver (peek), devuelve, pero no elimina, el elemento del "frente".
    public T ver() { //Define el método 'peek' (ver), que permite inspeccionar el elemento del frente sin removerlo.
        if (estaVacia()) { //Comprueba si la cola está vacía antes de intentar ver.
            throw new NoSuchElementException("La cola está vacía."); //Lanza una excepción si la cola está vacía.
        }
        return lista.getPrimero().dato; //Retorna el dato contenido en el primer nodo de la lista, sin llamar a 'quitar()'.
    }

    public boolean estaVacia() { //Define el método para verificar si la cola no contiene elementos.
        return lista.size() == 0; //Retorna true si el tamaño de la lista es 0, indicando que la cola está vacía.
    }
    
    //Método recursivo solicitado (Implementación 2)
    public void procesarRecursivamente() { //Define un método para procesar y vaciar toda la cola utilizando recursión.
        if (estaVacia()) { //Caso base de la recursión: si la cola está vacía, la función termina.
            System.out.println("Cola vacía, procesamiento finalizado."); //Indica que no hay más elementos para procesar.
            return; //Termina la ejecución del método.
        }
        T dato = quitar(); //Acción recursiva: Remueve (dequeue) el elemento del frente.
        System.out.println("Procesando solicitud: " + dato.toString()); //Imprime el elemento que acaba de ser procesado (quitado).
        procesarRecursivamente(); //Llama recursivamente a sí mismo para procesar el siguiente elemento en la cola.
    }
}