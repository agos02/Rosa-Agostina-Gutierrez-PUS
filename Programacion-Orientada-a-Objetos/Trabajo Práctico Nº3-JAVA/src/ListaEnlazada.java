// ListaEnlazada.java
import java.util.Iterator; //Importa la interfaz Iterator, necesaria para recorrer la lista.
import java.util.NoSuchElementException; //Importa la excepción NoSuchElementException, usada por el Iterator cuando no hay más elementos.

public class ListaEnlazada<T> implements Iterable<T> { //Declaración de la clase ListaEnlazada. Es genérica (<T>) y se hace iterable (implements Iterable<T>) para poder usar el bucle for-each de Java.
    private Nodo<T> primero; //Referencia al primer nodo de la lista (la "cabeza"). Si es null, la lista está vacía.
    private int size = 0; //Atributo para llevar la cuenta del número de elementos en la lista.

    public ListaEnlazada() { //Constructor por defecto de la lista.
        this.primero = null; //Inicializa la referencia 'primero' a null, indicando una lista vacía.
    }

    public Nodo<T> getPrimero() { //Método getter para obtener la referencia al primer nodo.
        return primero; //Retorna la referencia.
    }

    public int size() { //Método para obtener el tamaño de la lista.
        return size; //Retorna el número de elementos en la lista.
    }

    //Método para agregar un nuevo elemento al final de la lista.
    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato); //Crea un nuevo nodo con el dato proporcionado.
        if (primero == null) { //Comprueba si la lista está vacía.
            primero = nuevo; //Si está vacía, el nuevo nodo se convierte en el primer nodo.
        } else { 
            Nodo<T> actual = primero; //Si no está vacía, recorre la lista hasta el último nodo.
            while (actual.siguiente != null) actual = actual.siguiente; //Avanza hasta el último nodo.
            actual.siguiente = nuevo; //Enlaza el nuevo nodo al final.
        }
        size++; //Incrementa el tamaño de la lista.
    }

    //Método para insertar un nuevo elemento manteniendo un orden específico.
    //Inserta manteniendo orden por apellido (asume que dato es Persona o subclase)
    public void agregarEnOrdenPorApellido(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato); //Crea un nuevo nodo con el dato proporcionado.
        try { 
            String apellidoNuevo = ((Persona) dato).getApellido(); //Intenta convertir el dato a tipo Persona y obtiene el apellido para la comparación.
            if (primero == null) { //Si la lista está vacía, el nuevo nodo se convierte en el primer nodo.
                primero = nuevo; //Establece el nuevo nodo como el primero.
            } else {
                Nodo<T> actual = primero; //Si no está vacía, recorre la lista para encontrar la posición correcta.
                Nodo<T> anterior = null; //Referencia al nodo anterior durante la búsqueda de la posición.
                while (actual != null) { //Mientras no se alcance el final de la lista.
                    String apellidoActual = ((Persona) actual.dato).getApellido(); //Obtiene el apellido del nodo actual.
                    if (apellidoActual == null) apellidoActual = ""; //Manejo de apellidos nulos.
                    if (apellidoNuevo == null) apellidoNuevo = ""; //Manejo de apellidos nulos.
                    if (apellidoNuevo.compareToIgnoreCase(apellidoActual) <= 0) { //Compara los apellidos ignorando mayúsculas/minúsculas.
                        break;
                    }
                    anterior = actual; //Actualiza el nodo anterior.
                    actual = actual.siguiente; //Avanza al siguiente nodo.
                }
                if (anterior == null) { //Si no hay nodo anterior, el nuevo nodo se inserta al principio.
                    nuevo.siguiente = primero; //Enlaza el nuevo nodo al principio.
                    primero = nuevo; //Actualiza la referencia al primer nodo.
                } else {
                    nuevo.siguiente = anterior.siguiente; //Enlaza el nuevo nodo en la posición correcta.
                    anterior.siguiente = nuevo; //Actualiza el enlace del nodo anterior al nuevo nodo.
                }
            }
            size++; //Incrementa el tamaño de la lista.
        } catch (ClassCastException ex) { //Captura la excepción si el dato pasado no es de tipo Persona o no tiene getApellido().
            agregar(dato); //Agrega el dato al final de la lista sin orden específico.
        }
    }

    //Método para copiar el contenido de la lista enlazada a un array de tipo T[].
    //Convierte la lista a un array de Objects (retorna T[])
    //Suprime las advertencias del compilador sobre el casteo inseguro.
    @SuppressWarnings("unchecked")
    public T[] convertirAArray(Class<T> clazz) { //Recibe la clase del tipo genérico (Class<T>) como argumento para crear el array en tiempo de ejecución.
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(clazz, size); //Crea un array del tipo T con el tamaño de la lista usando reflexión.
        Nodo<T> actual = primero; //Comienza desde el primer nodo.
        int i = 0; //Índice para el array.
        while (actual != null) { //Recorre la lista hasta el final.
            arr[i++] = actual.dato; //Asigna el dato del nodo actual al array y avanza el índice.
            actual = actual.siguiente; //Avanza al siguiente nodo.
        }
        return arr; //Retorna el array lleno con los datos de la lista.
    }

    //Método estático para construir una lista enlazada a partir de un array.
    public static <T> ListaEnlazada<T> convertirArrayALista(T[] array) {
        ListaEnlazada<T> lista = new ListaEnlazada<>(); //Crea una nueva instancia de ListaEnlazada.
        if (array == null) return lista; //Si el array es null, retorna una lista vacía.
        for (T o : array) lista.agregar(o); //Agrega cada elemento del array a la lista.
        return lista; //Retorna la lista enlazada construida.
    }

    //Implementación del método 'iterator()' de la interfaz Iterable.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() { //Retorna una nueva instancia de la clase anónima Iterator<T>.
            private Nodo<T> actual = primero; //Atributo interno del Iterator que rastrea el nodo actual en el recorrido.
            @Override public boolean hasNext() { return actual != null; } //Implementación de hasNext(): retorna true si el nodo actual no es null.
            @Override public T next() { //Implementación de next(): retorna el dato del nodo actual y avanza al siguiente.
                if (actual == null) throw new NoSuchElementException(); //Si 'actual' es null, lanza una excepción (no hay más elementos).
                T dato = actual.dato; //Guarda el dato del nodo actual en una variable temporal.
                actual = actual.siguiente; //Avanza el puntero al siguiente nodo.
                return dato; //Retorna el dato que se guardó.
            }
        };
    }

    //Método para obtener el dato en una posición específica (índice) de la lista.
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(); //Verifica si el índice está fuera de los límites válidos (0 a size-1).
        Nodo<T> actual = primero; //Comienza el recorrido desde el primer nodo.
        for (int i = 0; i < index; i++) actual = actual.siguiente; //Bucle que avanza 'actual' hasta llegar al nodo en la posición 'index'.
        return actual.dato; //Retorna el dato contenido en el nodo encontrado.
    }

    //MÉTODO PARA LA EFICIENCIA 0(1) DE LA COLA.

    public T quitarPrimero() { //Método público que quita y retorna el dato del primer nodo.
        if (primero == null) { //Caso de lista vacía: Comprueba si la lista no tiene elementos (primero es null).
            throw new java.util.NoSuchElementException("La lista está vacía."); //Lanza una excepción para indicar que no hay elementos para quitar.
        }
        T dato = primero.dato; //Almacena el dato del primer nodo en una variable temporal. Este es el valor que se retornará.
        primero = primero.siguiente; //Mueve la referencia 'primero' al siguiente nodo, desvinculando el nodo original del inicio.
        size--; //Decrementa el contador de elementos de la lista, ya que se ha eliminado el elemento.
        return dato; //Retorna el dato que estaba en el nodo eliminado.
    }

    // AgregamoS este método para la Pila (Pop).
    
    public T quitarUltimo() { //Método público que quita y retorna el dato del último nodo.
        if (primero == null) { //Comprueba si la lista no tiene elementos (primero es null).
            throw new java.util.NoSuchElementException("La lista está vacía."); //Lanza una excepción para indicar que no hay elementos para quitar.
        }
        
        if (primero.siguiente == null) { //Caso de un solo elemento: Comprueba si 'primero' es el único nodo.
            T dato = primero.dato; //Almacena el dato del único nodo en una variable temporal.
            primero = null; //Establece 'primero' a null, vaciando la lista.
            size--; //Decrementa el contador de elementos de la lista.
            return dato; //Retorna el dato que estaba en el nodo eliminado.
        }

        //Caso de dos o más elementos: Busca el penúltimo nodo (O(n))
        Nodo<T> actual = primero; //Inicializa 'actual' en el primer nodo.
        Nodo<T> anterior = null; //Inicializa 'anterior' en null (se usará para referenciar al penúltimo).
        while (actual.siguiente != null) { //Bucle que recorre la lista hasta que 'actual' sea el último nodo.
            anterior = actual; //'anterior' siempre toma el valor actual antes de avanzar.
            actual = actual.siguiente; //'actual' avanza al siguiente nodo.
        }

        //Al salir del bucle, 'actual' es el último nodo y 'anterior' es el penúltimo.

        T dato = actual.dato; //Almacena el dato del último nodo en una variable temporal.
        anterior.siguiente = null; //Desvincula el último nodo estableciendo el siguiente del penúltimo a null.
        size--; //Decrementa el contador de elementos de la lista.
        return dato; //Retorna el dato que estaba en el nodo eliminado.
    }

}
