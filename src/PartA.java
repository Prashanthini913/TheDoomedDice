public class PartA {

    public static void main(String[] args) {
        // Question 1
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};

        int totalCombinations = dieA.length * dieB.length;
        System.out.println("Total no. of combinations: " + totalCombinations);

        // Question 2
        int[][] distributionMatrix = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                distributionMatrix[i][j] = dieA[i] + dieB[j];
            }
        }

        System.out.println("Distribution Matrix:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(distributionMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Question 3
        int[] sumCounts = new int[12 + 1];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                sumCounts[i + j]++;
            }
        }
        // sumCounts = [0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]

        double[] probabilities = new double[12 + 1];

        System.out.println("\nProbability of Sums:");
        for (int sumVal = 2; sumVal <= 12; sumVal++) {
            double probability = (double) sumCounts[sumVal] / totalCombinations;
            probabilities[sumVal] = probability;
            System.out.println("P(Sum = " + sumVal + "): " + String.format("%.4f", probability));
        }
    }
}

