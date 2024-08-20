import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraGeometrica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultados = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            try {
                // Mostrar el menú principal
                int opcionFigura = mostrarMenuFiguras(scanner);

                if (opcionFigura == 7) {
                    mostrarResultados(resultados);
                    continue;
                }

                if (opcionFigura == 8) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                Operacion operacion = null;

                if (opcionFigura == 6) {
                    double base = pedirNumero(scanner, "Ingrese la base:");
                    int exponente = (int) pedirNumero(scanner, "Ingrese el exponente:");
                    operacion = new Potencia(base, exponente);
                } else {
                    int opcionOperacion = mostrarMenuOperaciones(scanner);
                    switch (opcionFigura) {
                        case 1:
                            double radio = pedirNumero(scanner, "Ingrese el radio del círculo: ");
                            operacion = new Circulo(radio, opcionOperacion == 1);
                            break;
                        case 2:
                            double ladoCuadrado = pedirNumero(scanner, "Ingrese el lado del cuadrado: ");
                            operacion = new Cuadrado(ladoCuadrado, opcionOperacion == 1);
                            break;
                        case 3:
                            if (opcionOperacion == 1) {
                                double baseTriangulo = pedirNumero(scanner, "Ingrese la base del triángulo: ");
                                double altura = pedirNumero(scanner, "Ingrese la altura del triángulo: ");
                                operacion = new Triangulo(baseTriangulo, altura);
                            } else {
                                double lado1 = pedirNumero(scanner, "Ingrese el lado 1 del triángulo: ");
                                double lado2 = pedirNumero(scanner, "Ingrese el lado 2 del triángulo: ");
                                double lado3 = pedirNumero(scanner, "Ingrese el lado 3 del triángulo: ");
                                operacion = new Triangulo(lado1, lado2, lado3);
                            }
                            break;
                        case 4:
                            double largo = pedirNumero(scanner, "Ingrese el largo del rectángulo: ");
                            double ancho = pedirNumero(scanner, "Ingrese el ancho del rectángulo: ");
                            operacion = new Rectangulo(largo, ancho, opcionOperacion == 1);
                            break;
                        case 5:
                            double ladoPentagono = pedirNumero(scanner, "Ingrese el lado del pentágono: ");
                            double apotema = pedirNumero(scanner, "Ingrese la apotema del pentágono: ");
                            operacion = new Pentagono(ladoPentagono, apotema, opcionOperacion == 1);
                            break;
                        default:
                            System.out.println("Opción no válida. Intente nuevamente.");
                            continue;
                    }
                }

                if (operacion != null) {
                    resultados.add(operacion.obtenerDescripcion());
                    System.out.println(operacion.obtenerDescripcion());
                }

                continuar = preguntarContinuar(scanner);
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, intente nuevamente.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        }

        scanner.close();
    }

    private static int mostrarMenuFiguras(Scanner scanner) {
        System.out.println("\nSeleccione la figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.println("6. Calcular Potencia");
        System.out.println("7. Ver Resultados");
        System.out.println("8. Salir");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    private static int mostrarMenuOperaciones(Scanner scanner) {
        int opcionOperacion = 0;
        while (opcionOperacion < 1 || opcionOperacion > 2) {
            System.out.println("\n¿Qué operación desea realizar?");
            System.out.println("1. Calcular Área");
            System.out.println("2. Calcular Perímetro");
            System.out.print("Opción: ");
            opcionOperacion = scanner.nextInt();
            if (opcionOperacion < 1 || opcionOperacion > 2) {
                System.out.println("Por favor, seleccione una opción válida (1 o 2).");
            }
        }
        return opcionOperacion;
    }

    private static double pedirNumero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    private static boolean preguntarContinuar(Scanner scanner) {
        System.out.print("¿Desea realizar otra operación? (s/n): ");
        char respuesta = scanner.next().toLowerCase().charAt(0);
        return respuesta == 's';
    }

    private static void mostrarResultados(ArrayList<String> resultados) {
        System.out.println("\nResultados guardados:");
        if (resultados.isEmpty()) {
            System.out.println("No hay resultados para mostrar.");
        } else {
            for (String resultado : resultados) {
                System.out.println(resultado);
            }
        }
    }
}
