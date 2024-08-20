public class Circulo implements Operacion {
    private double radio;
    private boolean esArea;

    public Circulo(double radio, boolean esArea) {
        this.radio = radio;
        this.esArea = esArea;
    }

    @Override
    public double calcular() {
        if (esArea) {
            return Math.PI * Math.pow(radio, 2);
        } else {
            return 2 * Math.PI * radio;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("%s del Círculo: %.2f", esArea ? "Área" : "Perímetro", calcular());
    }
}
