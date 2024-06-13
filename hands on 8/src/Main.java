public class Main {
    public static void main(String[] args) {
        // Generando permutaciones
        char[] characters = {'A', 'B', 'C'};
        DiscreteMaths.Permutations permutations = new DiscreteMaths.Permutations(characters);
        System.out.println("Generando permutaciones :");
        permutations.generatePermutations();

        // Realizando cálculos de probabilidad
        int[][] dataSetArray = {
                {7, 2}, // Nublado y llueve, Nublado y no llueve
                {3, 6}  // No nublado y llueve, No nublado y no llueve
        };
        DataSet dataSet = new DataSet(dataSetArray);
        Probability probability = new Probability(dataSet);
        System.out.println("\nRealizando cálculos de probabilidad:");
        probability.calculateProbabilities();
    }
}
