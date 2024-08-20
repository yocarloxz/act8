public class Cuadrado implements Operacion {
    private double lado;
    private boolean esArea;

    public Cuadrado(double lado, boolean esArea) {
        this.lado = lado;
        this.esArea = esArea;
    }

    @Override
    public double calcular() {
        if (esArea) {
            return Math.pow(lado, 2);
        } else {
            return 4 * lado;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("%s del Cuadrado: %.2f", esArea ? "Área" : "Perímetro", calcular());
    }
}
