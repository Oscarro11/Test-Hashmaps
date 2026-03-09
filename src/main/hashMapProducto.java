package main; 
import java.time.LocalDate;

public class HashMapProducto implements IFuncionHash {

    private int valorHash;
    private int[] arregloLlaves;
    private ListaEncadenada<ProductoTaco>[] arregloListas;

    @SuppressWarnings ("unchecked")
    public HashMapProducto() {
        arregloLlaves = new int[20];
        arregloListas = new ListaEncadenada[20];

        for (int i = 0; i < 20; i++) {
            arregloListas[i] = new ListaEncadenada<>();
        }
    }

    
    @Override
    public int generarHash(String tipo, LocalDate fechaVenc) {

        int sumaAscii = 0;

        for (int i = 0; i < tipo.length(); i++) {
            int ascii = (int) tipo.charAt(i);
            sumaAscii += Math.pow(ascii, i + 1);
        }

        int resultado = (sumaAscii + fechaVenc.getDayOfMonth());
        resultado = resultado * fechaVenc.getMonthValue();
        resultado = resultado - fechaVenc.getYear();

        return Math.abs(resultado % 20);
    }

    public boolean guardarValor(ProductoTaco producto) {

        int posicion = generarHash(producto.getTipo(), producto.getFechaVenc());

        arregloListas[posicion].agregarNodo(producto);
        arregloLlaves[posicion] = posicion;

        return true;
    }

    
    public ProductoTaco buscarObjeto(String tipo, LocalDate fechaVenc) {

        int posicion = generarHash(tipo, fechaVenc);

        NodoSimple<ProductoTaco> actual = arregloListas[posicion].getCabeza();

        while (actual != null) {
            if (actual.objeto.getTipo().equals(tipo)
                    && actual.objeto.getFechaVenc().equals(fechaVenc)) {
                return actual.objeto;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    public boolean eliminarObjeto(String tipo, LocalDate fechaVenc) {
        int posicion = generarHash(tipo, fechaVenc);

        NodoSimple<ProductoTaco> actual = arregloListas[posicion].getCabeza();

        while (actual != null) {
            if (actual.objeto.getTipo().equals(tipo)
                    && actual.objeto.getFechaVenc().equals(fechaVenc)) {
                return arregloListas[posicion].eliminar(actual.objeto);
            }
            actual = actual.siguiente;
        }
        return false;
    }
}