public abstract class Area implements Operacion {
    protected double resultado;
    protected String descripcion;

    @Override
    public double calcular() {
        return resultado;
    }

    @Override
    public String obtenerDescripcion() {
        return descripcion;
    }
}
