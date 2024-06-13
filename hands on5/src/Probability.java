public class Probability {
    private DataSetProbability datasetProbability;

    public Probability(DataSetProbability datasetProbability) {
        this.datasetProbability = datasetProbability;
    }

    public double getMarginalProbability(String event) {
        String[] elements = datasetProbability.getElements();
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
        int index1 = indexOf(event1);
        int index2 = indexOf(event2);

        if (index1 == -1 || index2 == -1) {
            return 0;
        }

        int count = probabilities[index1][index2];

        return (double) count / total;
    }

    public double getConditionalProbability(String event1, String event2) {
        double jointProb = getJointProbability(event1, event2);
        double marginalProb = getMarginalProbability(event2);
        if (marginalProb == 0) return 0;
        return jointProb / marginalProb;
    }

    private int indexOf(String event) {
        String[] elements = datasetProbability.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(event)) {
                return i;
            }
        }
        return -1;
    }
}
