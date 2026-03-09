package main;

public class ListaEncadenada<T> {
    private NodoSimple<T> cabeza;

    public ListaEncadenada(){
        this.cabeza = null;
    }

    public void agregarNodo(T objeto){
        NodoSimple<T> nodoNuevo = new NodoSimple<T>(objeto, cabeza);
        cabeza = nodoNuevo;
    }

public boolean buscar(T objeto) {

    NodoSimple<T> actual = cabeza;

    while (actual != null) {
        if (actual.objeto.equals(objeto)) {
            return true;
        }
        actual = actual.siguiente;
    }

    return false;
}
}
