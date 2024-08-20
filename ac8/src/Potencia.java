public class Potencia implements Operacion {
    private double base;
    private int exponente;

    public Potencia(double base, int exponente) {
        this.base = base;
        this.exponente = exponente;
    }

    @Override
    public double calcular() {
        return calcularPotencia(base, exponente);
    }

    private double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * calcularPotencia(base, exponente - 1);
        } else {
            return 1 / calcularPotencia(base, -exponente);
        }
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("Potencia: %.2f ^ %d = %.2f", base, exponente, calcular());
    }
}
