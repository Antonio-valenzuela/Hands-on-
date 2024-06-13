public class Discrete {

    public static int calcularNumeroDeClases(int n) {
        if (n <= 1) {
            // Si el número de datos es 1 o menos, solo hay 1 clase.
            return 1;
        }
        // La fórmula de Sturges para calcular el número de clases es:
        // 1 + 3.322 * log10(n)
        return (int) Math.ceil(1 + 3.322 * Math.log10(n));
    }

    public static double calcularAmplitudIntervalo(double rango, int numeroDeClases) {
        if (numeroDeClases <= 0) {
            throw new IllegalArgumentException("El número de clases debe ser mayor que cero.");
        }
        return rango / numeroDeClases;
    }
}
