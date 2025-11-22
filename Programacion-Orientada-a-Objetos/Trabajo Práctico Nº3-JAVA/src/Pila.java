import java.util.NoSuchElementException; //Importa la excepción necesaria para manejar errores cuando se intenta quitar o ver un elemento de una pila vacía.

public class Pila<T> { //Define la clase genérica Pila, que puede manejar cualquier tipo de dato (T).
    private ListaEnlazada<T> lista = new ListaEnlazada<>(); //Crea una instancia privada de ListaEnlazada para almacenar los elementos de la pila.

    //Insertar (push), agrega un elemento a la "cima" (final de la lista).
    public void insertar(T dato) { //Define el método 'push' (insertar) que recibe el dato a agregar.
        lista.agregar(dato); //Agrega el dato al final de la lista enlazada, que representa la cima de la pila.
    }

    //Quitar (pop), elimina y devuelve el elemento de la "cima" (el último).
    public T quitar() { //Define el método 'pop' (quitar), que elimina y devuelve el elemento superior.
        if (estaVacia()) { //Verifica si la pila está vacía antes de intentar quitar un elemento.
            throw new NoSuchElementException("La pila está vacía."); //Lanza una excepción si la pila está vacía.
        }
        return lista.quitarUltimo(); //Elimina y devuelve el último elemento de la lista, que es la cima de la pila.
    }

    //Ver (peek), devuelve, pero no elimina el elemento de la "cima".
    public T ver() { //Define el método 'peek' (ver), que permite inspeccionar el elemento superior sin removerlo.
        if (estaVacia()) { //Verifica si la pila está vacía antes de intentar ver el elemento superior.
            throw new NoSuchElementException("La pila está vacía."); //Lanza una excepción si la pila está vacía.
        }
        return lista.get(lista.size() - 1); //Retorna el elemento en la última posición de la lista (cima de la pila) utilizando el índice (size - 1).
    }

    public boolean estaVacia() { //Define el método para verificar si la pila está vacía.
        return lista.size() == 0; //Retorna true si el tamaño de la lista es 0, indicando que la pila está vacía.
    }
    
    //Método recursivo solicitado (Implementación 1)
    public void vaciarRecursivamente() { //Define un método para vaciar la pila utilizando recursión.
        if (estaVacia()) { //Caso base de la recursión: si la pila está vacía, la función termina.
            System.out.println("Pila vacía."); //Indica que la pila ya está vacía.
            return; //Finaliza la ejecución del método.
        }
        T dato = quitar(); //Acción recursiva, remueve (pop) el elemento de la cima.
        System.out.println("Desapilando: " + dato.toString()); //Imprime el elemento que acaba de ser desapilado.
        vaciarRecursivamente(); //Llama al mismo método para continuar desapilando hasta que la pila esté vacía.
    }
}