import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] chars = {"a", "b", "c", "d", "e", "f"};
        Permutation datasetPermutation = new Permutation(chars);
        DataSetProbability datasetProbability = new DataSetProbability(chars, new int[][]{{60, 43}, {25, 18}});
        ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator(datasetPermutation, datasetProbability);

        datasetPermutation.displayData();
        datasetProbability.displayData();

        System.out.println("\nProbabilidades:");

        System.out.println("P(A): " + probabilityCalculator.getMarginalProbability("a"));
        System.out.println("P(B): " + probabilityCalculator.getMarginalProbability("b"));
        System.out.println("P(C): " + probabilityCalculator.getMarginalProbability("c"));

        System.out.println("P(A, B): " + probabilityCalculator.getJointProbability("a", "b"));
        System.out.println("P(B, C): " + probabilityCalculator.getJointProbability("b", "c"));

        System.out.println("P(A|B): " + probabilityCalculator.getConditionalProbability("a", "b"));
        System.out.println("P(B|C): " + probabilityCalculator.getConditionalProbability("b", "c"));
    }
}
