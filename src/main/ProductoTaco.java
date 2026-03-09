package main;

import java.time.LocalDate;

public class ProductoTaco implements IFuncionHash{
    private String nombre;
    private String tipo;
    private LocalDate fechaVenc;

    public ProductoTaco(String nombre, String tipo, LocalDate fechaVenc){
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaVenc = fechaVenc;
    }

    public ProductoTaco(String tipo, LocalDate fechaVenc){
        this.tipo = tipo;
        this.fechaVenc = fechaVenc;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public LocalDate getFechaVenc(){
        return fechaVenc;
    }

    @Override
    public int generarHash(){
        char[] arregloTipo = tipo.toCharArray();
        int valor = 0;

        for (int i = 0; i < tipo.length(); i++) {
            valor += Math.pow((int) arregloTipo[i], i+1);
        };

        valor = (valor + fechaVenc.getDayOfMonth()) * fechaVenc.getMonthValue() - fechaVenc.getYear();
        return valor % 20;
    }

    @Override
    public String toString(){
        return nombre + " / " + tipo + " / " + fechaVenc;
    }

    //This method should be replaced with one from a dedicated interface, that looks for similarities in 1 - 2 attributes between objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ProductoTaco other = (ProductoTaco) obj;

        return tipo.equals(other.tipo) &&
            fechaVenc.equals(other.fechaVenc);
    }
}
