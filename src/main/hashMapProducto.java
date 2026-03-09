package main; 

public class HashMapProducto<T extends IFuncionHash> {

    private static final int TAMANIO = 20;
    private ListaEncadenada<T>[] arregloListas;

    @SuppressWarnings("unchecked")
    public HashMapProducto() {
        arregloListas = new ListaEncadenada[TAMANIO];

        for (int i = 0; i < TAMANIO; i++) {
            arregloListas[i] = new ListaEncadenada<>();
        }
    }

    public void guardarValor(T objeto) {
        int posicion = objeto.generarHash();

        arregloListas[posicion].agregarNodo(objeto);
    }
   
    public boolean buscarObjeto(T objeto) {
        int posicion = objeto.generarHash();

        return arregloListas[posicion].buscar(objeto);
    }

     public boolean eliminarObjeto(T objeto) {
        int posicion = objeto.generarHash();

        return arregloListas[posicion].eliminar(objeto);
    }

    
    public void mostrarTabla() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.println("Posicion " + i + ":");
            NodoSimple<T> actual = arregloListas[i].getCabeza();

            while (actual != null) {
                System.out.println("   -> " + actual.getObjeto());
                actual = actual.getSiguiente();
            }
        }
    }
}