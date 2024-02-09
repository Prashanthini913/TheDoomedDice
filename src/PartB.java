import java.util.ArrayList;

public class PartB {

    public static ArrayList<int[]> diceA_combinations(int[] elements, int length, int[] current, ArrayList<int[]> all_combinations) {
        if (current.length == length) {
            all_combinations.add(current);
            return all_combinations;
        }
        for (int element : elements) {
            diceA_combinations(elements, length, appendToArray(current, element), all_combinations);
        }
        return all_combinations;
    }

    public static ArrayList<int[]> diceB_combinations(int[] elements, int length, int start, int[] current, ArrayList<int[]> all_combinations) {
        if (current.length == length) {
            all_combinations.add(current);
            return all_combinations;
        }
        for (int i = start; i < elements.length; i++) {
            diceB_combinations(elements, length, i + 1, appendToArray(current, elements[i]), all_combinations);
        }
        return all_combinations;
    }

    public static double[] prob_of_sum(int[] arr1, int[] arr2) {
        double[] psum1 = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i : arr1) {
            for (int j : arr2) {
                int k = i + j;
                psum1[k - 1] = psum1[k - 1] + 1;
            }
        }
        for (int i = 0; i < psum1.length; i++) {
            if (psum1[i] != 0) {
                psum1[i] = psum1[i] / 36;
            }
        }
        return psum1;
    }

    public static int[] appendToArray(int[] arr, int element) {
        int[] newArray = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        newArray[arr.length] = element;
        return newArray;
    }

    public static void transform(int[] die_a, int[] die_b) {
        int[] elements1 = {1, 2, 3, 4};
        int length = 6;
        int[] current = {};
        ArrayList<int[]> all_combinations = new ArrayList<>();
        int[] elements2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int start = 0;

        ArrayList<int[]> combo1 = diceA_combinations(elements1, length, current, all_combinations);
        ArrayList<int[]> combo2 = diceB_combinations(elements2, length, start, current, all_combinations);
        int flag = 0;
        double[] probability_of_sums = {0, 1 / 36.0, 2 / 36.0, 3 / 36.0, 4 / 36.0, 5 / 36.0, 6 / 36.0, 5 / 36.0, 4 / 36.0, 3 / 36.0, 2 / 36.0, 1 / 36.0};

        for (int[] i : combo1) {
            for (int[] j : combo2) {
                if (arrayEquals(prob_of_sum(i, j), probability_of_sums)) {
                    System.out.print("new die_a: ");
                    printArray(i);
                    System.out.print("new die_b: ");
                    printArray(j);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }

    public static boolean arrayEquals(double[] arr1, double[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] die_a = {1, 2, 3, 4, 5, 6};
        int[] die_b = {1, 2, 3, 4, 5, 6};
        transform(die_a, die_b);
    }
}
