import java.util.Arrays;

public class DataSetProbability extends DataSet {
    private int[][] probabilities;

    public DataSetProbability(String[] elements, int[][] probabilities) {
        super(elements);
        this.probabilities = probabilities;
    }

    public int[][] getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(int[][] probabilities) {
        this.probabilities = probabilities;
    }

    @Override
    public void displayData() {
        System.out.println("DataSet de las Probabilidades:");
        for (int[] row : probabilities) {
            System.out.println(Arrays.toString(row));
        }
    }
}
