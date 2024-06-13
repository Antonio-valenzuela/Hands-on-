import java.util.Arrays;

public class DiscreteMaths {

    // Clase de Permutaciones
    public static class Permutations {
        private char[] elements;

        public Permutations(char[] elements) {
            this.elements = elements;
        }

        public void generatePermutations() {
            permute(elements, 0, elements.length - 1);
        }

        private void permute(char[] array, int l, int r) {
            if (l == r) {
                System.out.println("Permutación: " + Arrays.toString(array));
            } else {
                for (int i = l; i <= r; i++) {
                    swap(array, l, i);
                    permute(array, l + 1, r);
                    swap(array, l, i);
                }
            }
        }

        private void swap(char[] array, int i, int j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
