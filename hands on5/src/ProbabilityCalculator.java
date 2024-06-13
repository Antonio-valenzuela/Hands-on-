public class ProbabilityCalculator {
    private Permutation datasetPermutation;
    private DataSetProbability datasetProbability;

    public ProbabilityCalculator(Permutation datasetPermutation, DataSetProbability datasetProbability) {
        this.datasetPermutation = datasetPermutation;
        this.datasetProbability = datasetProbability;
    }

    public double getMarginalProbability(String event) {
        String[] elements = datasetPermutation.getElements();
        int count = 0;
        for (String s : elements) {
            if (s.equals(event)) {
                count++;
            }
        }
        return (double) count / elements.length;
    }

    public double getJointProbability(String event1, String event2) {
        int[][] probabilities = datasetProbability.getProbabilities();
        int total = 0;

        for (int[] row : probabilities) {
            for (int value : row) {
                total += value;
            }
        }

        // Asumiendo que event1 y event2 están en posiciones fijas (simplificación)
        int count = probabilities[0][1]; // Cambiar según la lógica de las posiciones de event1 y event2

        return (double) count / total;
    }

    public double getConditionalProbability(String event1, String event2) {
        double jointProb = getJointProbability(event1, event2);
        double marginalProb = getMarginalProbability(event2);
        if (marginalProb == 0) return 0;
        return jointProb / marginalProb;
    }
}
