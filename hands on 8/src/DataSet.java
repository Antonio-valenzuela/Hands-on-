import java.util.Arrays;

public class DataSet {
    private int[][] data;
    private int total;

    public DataSet(int[][] data) {
        this.data = data;
        this.total = Arrays.stream(data).flatMapToInt(Arrays::stream).sum();
    }

    public int[][] getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }
}
