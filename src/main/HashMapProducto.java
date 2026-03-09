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

        if (posicion < 0 || posicion >= TAMANIO) {
            throw new IllegalArgumentException(
                """
                Este HashMap unicamente puede almacenar llaves de 0 a 19, y\
                el valor hash del objeto " + objeto.toString() + " da un valor distinto al rango permitido
                """);
        }

        arregloListas[posicion].agregarNodo(objeto);
    }
   
    public T buscarObjeto(T objeto) {
        int posicion = objeto.generarHash();

        if (posicion < 0 || posicion >= TAMANIO) {
            throw new IllegalArgumentException(
                """
                Este HashMap unicamente puede almacenar llaves de 0 a 19, y\
                el valor hash del objeto " + objeto.toString() + " da un valor distinto al rango permitido
                """);
        }

        return arregloListas[posicion].buscar(objeto);
    }

    public boolean eliminarObjeto(T objeto) {
        int posicion = objeto.generarHash();

        if (posicion < 0 || posicion >= TAMANIO) {
            throw new IllegalArgumentException(
                """
                Este HashMap unicamente puede almacenar llaves de 0 a 19, y\
                el valor hash del objeto " + objeto.toString() + " da un valor distinto al rango permitido
                """);
        }


        return arregloListas[posicion].eliminar(objeto);
    }

    
    public void mostrarTabla() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.println("Posicion " + i + ":");
            NodoSimple<T> actual = arregloListas[i].getCabeza();

            while (actual != null) {
                System.out.println("   -> " + actual.getObjeto().toString());
                actual = actual.getSiguiente();
            }
        }
    }
}