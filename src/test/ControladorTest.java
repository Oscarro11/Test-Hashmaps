package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

import main.Controlador;

public class ControladorTest {

    @Test
    public void buscarNombreExiste(){
        Controlador controlador = new Controlador();

        controlador.agregarProducto("Ojos de vaca", "ojos", LocalDate.of(1990, 04, 10));
        controlador.agregarProducto("Ojos de cerdo", "ojos", LocalDate.of(1990, 04, 10));
        controlador.agregarProducto("Lechuga francesa", "vegetal", LocalDate.of(2013, 05, 01));

        String nombre = controlador.buscarNombreProducto("ojos", LocalDate.of(1990, 04, 10));
        Assertions.assertEquals("Ojos de cerdo", nombre);
    }

    @Test
    public void buscarNombreNoExiste(){
        Controlador controlador = new Controlador();

        controlador.agregarProducto("Lechuga francesa", "vegetal", LocalDate.of(2013, 05, 01));
        controlador.agregarProducto("Tomate cherry", "vegetal", LocalDate.of(2013, 05, 01));

        String nombre = controlador.buscarNombreProducto("lomo", LocalDate.of(1990, 04, 10));
        Assertions.assertEquals(null, nombre);
    }

    @Test
    public void nombreExisteYDespuesElimina(){
        Controlador controlador = new Controlador();

        controlador.agregarProducto("Lechuga francesa", "vegetal", LocalDate.of(2000, 11, 30));
        controlador.agregarProducto("Lechuga iceberg", "vegetal", LocalDate.of(2000, 11, 30));
    
        Assertions.assertEquals("Lechuga iceberg", controlador.buscarNombreProducto("vegetal", LocalDate.of(2000, 11, 30)));

        controlador.eliminarProducto("vegetal", LocalDate.of(2000, 11, 30));
        Assertions.assertEquals("Lechuga francesa", controlador.buscarNombreProducto("vegetal", LocalDate.of(2000, 11, 30)));
    }
}
