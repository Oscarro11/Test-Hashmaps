package main; 
@SuppressWarnings("unchecked")

public class HashMapProducto<T extends IFuncionHash> {

    private static final int TAMANIO = 20;
    private ListaEncadenada<T>[] arregloListas;

    public HashMapProducto() {
        arregloListas = new ListaEncadenada[TAMANIO];

        for (int i = 0; i < TAMANIO; i++) {
            arregloListas[i] = new ListaEncadenada<>();
        }
    }

    public boolean guardarValor(T objeto) {

        int posicion = objeto.generarHash();

        if (posicion < 0 || posicion >= TAMANIO) {
            return false; 
        }

        arregloListas[posicion].agregarNodo(objeto);
        return true;
    }

   
    public boolean buscarObjeto(T objeto) {

        int posicion = objeto.generarHash();

        if (posicion < 0 || posicion >= TAMANIO) {
            return false;
        }

        return arregloListas[posicion].buscar(objeto);
    }

   
    public boolean eliminarObjeto(T objeto) {

        int posicion = objeto.generarHash();

        if (posicion < 0 || posicion >= TAMANIO) {
            return false;
        }

        return arregloListas[posicion].eliminar(objeto);
    }

    public void mostrarTabla() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.println("Posición " + i + ":");
            NodoSimple<T> actual = arregloListas[i].getCabeza();

            while (actual != null) {
                System.out.println("   -> " + actual.objeto);
                actual = actual.siguiente;
            }
        }
    }
}