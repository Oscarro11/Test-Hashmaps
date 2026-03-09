package main;

public class NodoSimple<T> {
    private T objeto;
    private NodoSimple<T> siguiente;

    public NodoSimple(T objeto, NodoSimple<T> siguiente){
        this.objeto = objeto;
        this.siguiente = siguiente;
    }

    public NodoSimple<T> getSiguiente(){
        return siguiente;
    }

    public T getObjeto(){
        return objeto;
    }

    public void setSiguiente(NodoSimple<T> siguiente){
        this.siguiente = siguiente;
    }
}
