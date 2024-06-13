public class Probability {
    private DataSet dataSet;

    public Probability(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public void calculateProbabilities() {
        double pA = calculateMarginal(0);
        double pAComplement = calculateMarginal(1);
        double pB = calculateMarginal(2);
        double pBComplement = calculateMarginal(3);
        double pAAndB = calculateJoint(0, 0);
        double pAComplementAndBComplement = calculateJoint(1, 1);
        double pBGivenA = calculateConditional(0, 0);
        double pBGivenAComplement = calculateConditional(1, 0);
        double pBComplementGivenA = calculateConditional(0, 1);
        double pBComplementGivenAComplement = calculateConditional(1, 1);
        double pAGivenB = calculateConditional(0, 2);
        double pAGivenBComplement = calculateConditional(1, 2);

        System.out.printf("PROBABILIDADES DE QUE?:%n");
        System.out.printf("esté nublado (P(A)): %.2f%n", pA);
        System.out.printf("no esté nublado (P(A')): %.2f%n", pAComplement);
        System.out.printf("llueva (P(B)): %.2f%n", pB);
        System.out.printf("no llueva (P(B')): %.2f%n", pBComplement);
        System.out.printf("esté nublado y llueva (P(A ∩ B)): %.2f%n", pAAndB);
        System.out.printf("no esté nublado y no llueva (P(A' ∩ B')): %.2f%n", pAComplementAndBComplement);
        System.out.printf("llueva dado que está nublado (P(B|A)): %.2f%n", pBGivenA);
        System.out.printf("llueva dado que no está nublado (P(B|A')): %.2f%n", pBGivenAComplement);
        System.out.printf("no llueva dado que está nublado (P(B'|A)): %.2f%n", pBComplementGivenA);
        System.out.printf("no llueva dado que no está nublado (P(B'|A')): %.2f%n", pBComplementGivenAComplement);
        System.out.printf("esté nublado dado que llueve (P(A|B)): %.2f%n", pAGivenB);
        System.out.printf("esté nublado dado que no llueve (P(A|B')): %.2f%n", pAGivenBComplement);
    }

    private double calculateMarginal(int index) {
        int[][] data = dataSet.getData();
        int total = dataSet.getTotal();
        int sum = 0;
        switch (index) {
            case 0: // P(A)
                sum = data[0][0] + data[0][1];
                break;
            case 1: // P(A')
                sum = data[1][0] + data[1][1];
                break;
            case 2: // P(B)
                sum = data[0][0] + data[1][0];
                break;
            case 3: // P(B')
                sum = data[0][1] + data[1][1];
                break;
        }
        return (double) sum / total;
    }

    private double calculateJoint(int index1, int index2) {
        int[][] data = dataSet.getData();
        int total = dataSet.getTotal();
        return (double) data[index1][index2] / total;
    }

    private double calculateConditional(int row, int col) {
        int[][] data = dataSet.getData();
        int sum = 0;
        if (col == 0 || col == 1) { // P(B|A) or P(B'|A)
            sum = data[row][0] + data[row][1];
        } else if (col == 2 || col == 3) { // P(A|B) or P(A|B')
            sum = data[0][row] + data[1][row];
        }
        return (double) data[row][col == 2 || col == 3 ? row : col] / sum;
    }
}
