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

    public T buscar(T objeto) {
        NodoSimple<T> actual = cabeza;

        while (actual != null) {
            if (actual.getObjeto().equals(objeto)) {
                return actual.getObjeto();
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean eliminar(T objeto) {
        NodoSimple<T> previo = null;
        NodoSimple<T> actual = cabeza;

        while (actual != null){
            if (actual.getObjeto().equals(objeto)) {
                if (previo != null) {
                    previo.setSiguiente(actual.getSiguiente());    
                }
                else{
                    cabeza = actual.getSiguiente();
                }

                return true;
            }
            previo = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    public NodoSimple<T> getCabeza(){
        return cabeza;
    }
}
