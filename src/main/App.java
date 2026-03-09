package main;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static Scanner teclado = new Scanner(System.in);
    public static Controlador controlador = new Controlador();

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        boolean continuar = true;

        escribir("Bienvenido al sistema de registro para ingredientes de tacos\n");
        while (continuar) {
            escribir("""
                    Elija una de las opciones del menu:
                    1. Agregar ingrediente al inventario
                    2. Buscar ingrediente en inventario
                    3. Eliminar ingrediente en inventario
                    4. Salir
                    """);
            
            opcion = teclado.nextInt();
            teclado.nextLine();

            String nombre = "";
            String tipo = "";
            LocalDate fechaVenc = null;

            switch (opcion) {
                case 1:
                    escribir("Ingrese el nombre del ingrediente");
                    nombre = teclado.nextLine();
                    
                    escribir("\nIngrese el tipo o categoria a la que pertenece el ingrediente");
                    tipo = teclado.nextLine().strip().toLowerCase();

                    escribir("\nIngrese la fecha de caducidad del ingrediente (formato yyyy-MM-dd)");
                    fechaVenc = LocalDate.parse(teclado.nextLine().strip());

                    controlador.agregarProducto(nombre, tipo, fechaVenc);
                    escribir("\nEl ingrediente se ha guardado exitosamente\n");
                    break;
            
                case 2:
                    escribir("\nIngrese el tipo o categoria a la que pertenece el ingrediente");
                    tipo = teclado.nextLine().strip().toLowerCase();

                    escribir("\nIngrese la fecha de caducidad del ingrediente (formato yyyy-MM--dd");
                    fechaVenc = LocalDate.parse(teclado.nextLine().strip());

                    String nombreRespuesta = controlador.buscarNombreProducto(tipo, fechaVenc);
                    if (nombreRespuesta != null) {
                        escribir("\nEl primer ingrediente encontrado con las caracteristicas de busqueda es: '" + nombreRespuesta + "'\n");
                    }
                    else{
                        escribir("\nNo se encontro ningun ingrediente con las caracteristicas ingresadas\n");
                    }
                    break;

                case 3:
                    escribir("\nIngrese el tipo o categoria a la que pertenece el ingrediente");
                    tipo = teclado.nextLine().strip().toLowerCase();

                    escribir("\nIngrese la fecha de caducidad del ingrediente (formato yyyy-MM--dd");
                    fechaVenc = LocalDate.parse(teclado.nextLine().strip());

                    boolean ingredienteEliminado = controlador.eliminarProducto(tipo, fechaVenc);
                    if (ingredienteEliminado) {
                        escribir("\nSe ha eliminado un ingrediente con las caracteristicas requeridas\n");
                    }
                    else{
                        escribir("\nNo se encontro ningun ingrediente con las caracteristicas ingresadas, por lo que no se elimino ningun ingrediente\n");
                    }
                    break;

                case 4:
                    escribir("Gracias por usar el programa, esperamos volver a verlo pronto");
                    continuar = false;
                    break;

                default:
                    escribir("La opcion ingresada no corresponde con ninguna del menu, intentelo de nuevo\n");
                    break;
            }
        }
    }

    public static void escribir(String texto){
        System.out.println(texto);
    }
}
