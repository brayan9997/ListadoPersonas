import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        var salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e ) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

        private static void mostrarMenu(){
            System.out.print("""
                    ***Listado Personas App***
                    1.Agregar
                    2.Listar
                    3.Salir
                    """);

            System.out.print("Proporciona la opción: ");
        }

        private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
            var opcion = Integer.parseInt(consola.nextLine());
            var salir = false;

            switch (opcion) {
                case 1 -> {
                    System.out.print("Proporciona el nombre: ");
                    var nombre = consola.nextLine();
                    System.out.print("Proporciona el telefono: ");
                    var telefono = consola.nextLine();
                    System.out.print("Proporciona el email: ");
                    var email = consola.nextLine();

                    var persona = new Persona(nombre, telefono, email);
                    personas.add(persona);
                    System.out.println("La lista tiene " + personas.size() + "personas.");
                }
                case 2 -> {
                    System.out.println("Listado de personas: ");
                    personas.forEach(System.out::println); //metodo de referencia
                    /*por cada objeto de tipo persona que tengamos en nuestra lista,
                    se infiere que queremos acceder a cada uno de esos objetos,
                    y pasarlos como parametro al metodo println,
                    por lo tanto println va a imprimir cada objeto que tenga en la lista*/
                }
                case 3 -> {
                    System.out.println("Hasta Pronto...");
                    salir = true;
                }
                default -> {
                    System.out.println("Opcion erronea " + opcion);
                }
            }
            return salir;

        }
}