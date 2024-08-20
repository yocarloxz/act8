public class Pentagono implements Operacion {
    private double lado;
    private double apotema;
    private boolean esArea;

    public Pentagono(double lado, double apotema, boolean esArea) {
        this.lado = lado;
        this.apotema = apotema;
        this.esArea = esArea;
    }

    @Override
    public double calcular() {
        if (esArea) {
            return (5 * lado * apotema) / 2;
        } else {
            return 5 * lado;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("%s del Pentágono: %.2f", esArea ? "Área" : "Perímetro", calcular());
    }
}
