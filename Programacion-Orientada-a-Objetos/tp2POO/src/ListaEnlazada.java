// ListaEnlazada.java
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements Iterable<T> {
    private Nodo<T> primero;
    private int size = 0;

    public ListaEnlazada() {
        this.primero = null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public int size() {
        return size;
    }

    // Agrega al final
    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
        size++;
    }

    // Inserta manteniendo orden por apellido (asume que dato es Persona o subclase)
    public void agregarEnOrdenPorApellido(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        try {
            String apellidoNuevo = ((Persona) dato).getApellido();
            if (primero == null) {
                primero = nuevo;
            } else {
                Nodo<T> actual = primero;
                Nodo<T> anterior = null;
                while (actual != null) {
                    String apellidoActual = ((Persona) actual.dato).getApellido();
                    if (apellidoActual == null) apellidoActual = "";
                    if (apellidoNuevo == null) apellidoNuevo = "";
                    if (apellidoNuevo.compareToIgnoreCase(apellidoActual) <= 0) {
                        break;
                    }
                    anterior = actual;
                    actual = actual.siguiente;
                }
                if (anterior == null) {
                    nuevo.siguiente = primero;
                    primero = nuevo;
                } else {
                    nuevo.siguiente = anterior.siguiente;
                    anterior.siguiente = nuevo;
                }
            }
            size++;
        } catch (ClassCastException ex) {
            // si no es Persona, lo agregamos al final
            agregar(dato);
        }
    }

    // Convierte la lista a un array de Objects (retorna T[])
    @SuppressWarnings("unchecked")
    public T[] convertirAArray(Class<T> clazz) {
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        Nodo<T> actual = primero;
        int i = 0;
        while (actual != null) {
            arr[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return arr;
    }

    // Construye una lista desde un array
    public static <T> ListaEnlazada<T> convertirArrayALista(T[] array) {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        if (array == null) return lista;
        for (T o : array) lista.agregar(o);
        return lista;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = primero;
            @Override public boolean hasNext() { return actual != null; }
            @Override public T next() {
                if (actual == null) throw new NoSuchElementException();
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Nodo<T> actual = primero;
        for (int i = 0; i < index; i++) actual = actual.siguiente;
        return actual.dato;
    }
}
