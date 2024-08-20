public class Triangulo implements Operacion {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;
    private boolean esArea;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.esArea = true;
    }

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.esArea = false;
    }

    @Override
    public double calcular() {
        if (esArea) {
            return (base * altura) / 2;
        } else {
            return lado1 + lado2 + lado3;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("%s del Triángulo: %.2f", esArea ? "Área" : "Perímetro", calcular());
    }
}
