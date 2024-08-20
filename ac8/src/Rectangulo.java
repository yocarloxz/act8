public class Rectangulo implements Operacion {
    private double largo;
    private double ancho;
    private boolean esArea;

    public Rectangulo(double largo, double ancho, boolean esArea) {
        this.largo = largo;
        this.ancho = ancho;
        this.esArea = esArea;
    }

    @Override
    public double calcular() {
        if (esArea) {
            return largo * ancho;
        } else {
            return 2 * (largo + ancho);
        }
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("%s del Rectángulo: %.2f", esArea ? "Área" : "Perímetro", calcular());
    }
}
