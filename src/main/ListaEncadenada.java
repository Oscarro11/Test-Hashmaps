package main;

public class ListaEncadenada<T> {
    private NodoSimple<T> cabeza;

    ListaEncadenada(){
        this.cabeza = null;
    }

    public void agregarNodo(T objeto){
        NodoSimple<T> nodoNuevo = new NodoSimple<T>(objeto, cabeza);
        cabeza = nodoNuevo;
    }

    public T buscar(T objeto){
        NodoSimple<T> nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.equals(objeto)) {
                return nodoActual.getObjeto();
            }
            nodoActual = nodoActual.getSiguiente();
        }

        return null;
    }
}
