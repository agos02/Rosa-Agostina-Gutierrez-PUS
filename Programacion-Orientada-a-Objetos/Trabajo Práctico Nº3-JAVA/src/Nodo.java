//Nodo.java
//Declaración de la clase, haciéndola genérica con <T> para que pueda almacenar cualquier tipo de dato (Integer, String, Objeto, etc.)
public class Nodo<T> {
    public T dato; //Atributo público que almacena el valor real del nodo. El tipo es T.
    public Nodo<T> siguiente; //Atributo público que almacena una referencia (puntero) al siguiente nodo en la secuencia de la lista enlazada.
    //Es del mismo tipo genérico, Nodo<T>.

    public Nodo(T dato) { //Constructor de la clase Nodo. Se llama cuando se crea una nueva instancia (un nuevo nodo).
        this.dato = dato; //Inicializa el atributo dato con el valor proporcionado al constructor.
        this.siguiente = null; //Inicializa el atributo siguiente como null, indicando que no hay un nodo siguiente aún.
    }
}
