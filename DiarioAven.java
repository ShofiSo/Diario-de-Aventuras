import java.util.Stack;
import java.util.Scanner;

class DiarioAventurero {
    private Stack<String> misiones;

    public DiarioAventurero() {
        this.misiones = new Stack<>();
    }

    public void registrarMision(String mision) {
        misiones.push(mision);
        System.out.println("Misión registrada: " + mision);
    }

    public void eliminarUltimaMisionFallida() {
        if (!misiones.isEmpty()) {
            String misionRemovida = misiones.pop();
            System.out.println("Misión eliminada: " + misionRemovida);
        } else {
            System.out.println("No hay misiones para eliminar.");
        }
    }

    public void mostrarMisiones() {
        if (misiones.isEmpty()) {
            System.out.println("No hay misiones registradas.");
        } else {
            System.out.println("Misiones completadas:");
            for (int i = misiones.size() - 1; i >= 0; i--) {
                System.out.println("- " + misiones.get(i));
            }
        }
    }

    public boolean buscarMision(String mision) {
        return misiones.contains(mision);
    }
}

public class DiarioAven {
    public static void main(String[] args) {
        DiarioAventurero diario = new DiarioAventurero();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- Diario de Aventuras ---");
            System.out.println("1. Registrar nueva misión");
            System.out.println("2. Eliminar última misión fallida");
            System.out.println("3. Mostrar todas las misiones");
            System.out.println("4. Buscar una misión");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre de la misión: ");
                    String mision = scanner.nextLine();
                    diario.registrarMision(mision);
                    break;
                case 2:
                    diario.eliminarUltimaMisionFallida();
                    break;
                case 3:
                    diario.mostrarMisiones();
                    break;
                case 4:
                    System.out.print("Introduce el nombre de la misión a buscar: ");
                    String buscar = scanner.nextLine();
                    boolean encontrada = diario.buscarMision(buscar);
                    System.out.println(encontrada ? "Misión encontrada." : "Misión no encontrada.");
                    break;
                case 5:
                    System.out.println("Saliendo del Diario de Aventuras, regresa pronto...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo por favor.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
