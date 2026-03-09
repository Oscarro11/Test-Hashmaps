package main;

import java.time.LocalDate;

public class Controlador {
    private HashMapProducto<ProductoTaco> hashMap;
    
    public Controlador(){
        this.hashMap = new HashMapProducto<ProductoTaco>();
    }

    public void agregarProducto(String nombre, String tipo, LocalDate fechaVenc){
        hashMap.guardarValor(new ProductoTaco(nombre, tipo, fechaVenc));
    }

    public boolean eliminarProducto(String tipo, LocalDate fechaVenc){
        return hashMap.eliminarObjeto(new ProductoTaco(tipo, fechaVenc));
    }

    public boolean buscarProducto(String tipo, LocalDate fechaVenc){
        return hashMap.buscarObjeto(new ProductoTaco(tipo, fechaVenc));
    }
}
