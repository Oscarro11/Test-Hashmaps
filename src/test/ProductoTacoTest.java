package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

import main.ProductoTaco;

public class ProductoTacoTest{
    
    @Test
    public void producto1(){
        LocalDate date = LocalDate.of(1908, 10, 25);
        ProductoTaco productoTaco = new ProductoTaco("Ojos de cerdo", "ojos", date);

        int resultado = 0;
        char[] arregloTipo = "ojos".toCharArray();

        for (int i = 0; i < arregloTipo.length; i++) {
            resultado += Math.pow((int) arregloTipo[i], i+1);
        };

        resultado = (resultado + 25) * 10 - 1908;

        Assertions.assertEquals(productoTaco.generarHash(), resultado % 20);
    }

    @Test
    public void producto2(){
        LocalDate date = LocalDate.of(2000, 2, 14);
        ProductoTaco productoTaco = new ProductoTaco("Panceta", "carne", date);

        int resultado = 0;
        char[] arregloTipo = "carne".toCharArray();

        for (int i = 0; i < arregloTipo.length; i++) {
            resultado += Math.pow((int) arregloTipo[i], i+1);
        };

        resultado = (resultado + 14) * 2 - 2000;

        Assertions.assertEquals(productoTaco.generarHash(), resultado % 20);
    }
}