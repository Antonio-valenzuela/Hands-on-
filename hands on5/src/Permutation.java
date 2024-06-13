import java.util.ArrayList;
import java.util.List;

public class Permutation extends DataSet {

    public Permutation(String[] elements) {
        super(elements);
    }

    public List<String> getPermutations() {
        List<String> result = new ArrayList<>();
        permute(result, new StringBuilder(), new boolean[getElements().length]);
        return result;
    }

    private void permute(List<String> result, StringBuilder current, boolean[] used) {
        if (current.length() == getElements().length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < getElements().length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.append(getElements()[i]);
            permute(result, current, used);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    @Override
    public void displayData() {
        System.out.println("Permutaciones:");
        for (String perm : getPermutations()) {
            System.out.println(perm);
        }
    }
}
