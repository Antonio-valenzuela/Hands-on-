import java.util.ArrayList;
import java.util.Collections;

public class DataSet {

    private ArrayList<Double> datos;
    private double rango;
    private int numeroDeClases;
    private double amplitudIntervalo;

    public DataSet(ArrayList<Double> datos) {
        if (datos == null || datos.isEmpty()) {
            throw new IllegalArgumentException("La lista de datos no puede estar vacía.");
        }
        this.datos = new ArrayList<>(datos);
        Collections.sort(this.datos);
        calcularRango();
        calcularNumeroDeClases();
        calcularAmplitudIntervalo();
    }

    private void calcularRango() {
        double min = datos.get(0);
        double max = datos.get(datos.size() - 1);
        rango = max - min;
    }

    private void calcularNumeroDeClases() {
        numeroDeClases = Discrete.calcularNumeroDeClases(datos.size());
    }

    private void calcularAmplitudIntervalo() {
        amplitudIntervalo = Discrete.calcularAmplitudIntervalo(rango, numeroDeClases);
    }

    public void mostrarTablaDescriptiva() {
        double limiteInferior = datos.get(0);
        double limiteSuperior = limiteInferior + amplitudIntervalo;
        int frecuenciaAbsoluta;
        double puntoMedio;
        int frecuenciaAcumulada = 0;
        double frecuenciaRelativa;
        double frecuenciaRelativaAcumulada = 0;
        double porcentaje;

        System.out.printf("%-6s %-12s %-12s %-8s %-10s %-10s %-10s %-15s %-10s%n",
                "Clase", "LimiteInf", "LimiteSup", "FrecAbs", "PuntoMedio",
                "FrecAcum", "FrecRel", "FrecRelAcum", "Porcentaje");

        for (int i = 0; i < numeroDeClases; i++) {
            if (i == numeroDeClases - 1) {
                frecuenciaAbsoluta = calcularFrecuenciaAbsoluta(limiteInferior, limiteSuperior, true);
            } else {
                frecuenciaAbsoluta = calcularFrecuenciaAbsoluta(limiteInferior, limiteSuperior, false);
            }
            puntoMedio = (limiteInferior + limiteSuperior) / 2;
            frecuenciaAcumulada += frecuenciaAbsoluta;
            frecuenciaRelativa = (double) frecuenciaAbsoluta / datos.size();
            frecuenciaRelativaAcumulada += frecuenciaRelativa;
            porcentaje = frecuenciaRelativa * 100;

            System.out.printf("%-6d %-12.2f %-12.2f %-8d %-10.2f %-10d %-10.4f %-15.4f %-10.2f%%%n",
                    i + 1, limiteInferior, limiteSuperior, frecuenciaAbsoluta, puntoMedio, frecuenciaAcumulada,
                    frecuenciaRelativa, frecuenciaRelativaAcumulada, porcentaje);

            limiteInferior = limiteSuperior;
            limiteSuperior += amplitudIntervalo;
        }
    }

    private int calcularFrecuenciaAbsoluta(double limiteInferior, double limiteSuperior, boolean ultimoIntervalo) {
        int frecuencia = 0;
        for (Double dato : datos) {
            if (ultimoIntervalo) {
                if (dato >= limiteInferior && dato <= limiteSuperior) {
                    frecuencia++;
                }
            } else {
                if (dato >= limiteInferior && dato < limiteSuperior) {
                    frecuencia++;
                }
            }
        }
        return frecuencia;
    }
}
