package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HashMapProductoTest {

    private HashMapProducto<ProductoTaco> hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapProducto<>();
    }

    @Test
    void testGuardarYBuscar() {

        ProductoTaco producto =
                new ProductoTaco("Taco Pastor", "Carne",
                        LocalDate.of(2026, 3, 10));

        hashMap.guardarValor(producto);

        boolean encontrado = hashMap.buscarObjeto(producto);

        assertTrue(encontrado);
    }

    @Test
    void testBuscarInexistente() {

        ProductoTaco producto =
                new ProductoTaco("Taco Pastor", "Carne",
                        LocalDate.of(2026, 3, 10));

        boolean encontrado = hashMap.buscarObjeto(producto);

        assertFalse(encontrado);
    }

    @Test
    void testEliminar() {

        ProductoTaco producto =
                new ProductoTaco("Taco Pastor", "Carne",
                        LocalDate.of(2026, 3, 10));

        hashMap.guardarValor(producto);

        boolean eliminado = hashMap.eliminarObjeto(producto);

        assertTrue(eliminado);
        assertFalse(hashMap.buscarObjeto(producto));
    }

    @Test
    void testColision() {

       
        ProductoTaco p1 =
                new ProductoTaco("Taco1", "Pollo",
                        LocalDate.of(2026, 3, 10));

        ProductoTaco p2 =
                new ProductoTaco("Taco2", "Pollo",
                        LocalDate.of(2026, 3, 10));

        hashMap.guardarValor(p1);
        hashMap.guardarValor(p2);

        assertTrue(hashMap.buscarObjeto(p1));
        assertTrue(hashMap.buscarObjeto(p2));
    }
}
