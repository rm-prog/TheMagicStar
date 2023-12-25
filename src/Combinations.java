import java.util.Arrays;
import java.util.Dictionary;

public class Combinations {

    public static int[][] FindCombinations(int[] active, int[] rest, int[][] results) {

        if (active.length == 0 && rest.length == 0) {
            return results;
        }

        if (rest.length == 0) {
            int[][] newArray = new int[results.length + 1][];
            System.arraycopy(results, 0, newArray, 0, results.length);
            newArray[newArray.length - 1] = active;
            results = newArray;
        } else {
            int[] active2 = new int[active.length + 1];
            System.arraycopy(active, 0, active2, 0, active.length);
            active2[active2.length - 1] = rest[0];

            int[] newRest = new int[rest.length - 1];
            System.arraycopy(rest, 1, newRest, 0, rest.length - 1);

            int[][] newResults = FindCombinations(active2, newRest, results);
            int[][] newResults1 = FindCombinations(active, newRest, results);

            int[][] newArray = new int[newResults.length + newResults1.length + results.length][];
            System.arraycopy(results, 0, newArray, 0, results.length);
            System.arraycopy(newResults, 0, newArray, results.length, newResults.length);
            System.arraycopy(newResults1, 0, newArray, results.length + newResults.length, newResults1.length);
            results = newArray;
        }

        return results;

    }

    public static int[][] CombinationsOfLength(int[][] combinations, int length) {

        int[][] results = new int[][]{};

        for (int[] combination : combinations) {
            if (combination.length == length) {
                int[][] newArray = new int[results.length + 1][];
                System.arraycopy(results, 0, newArray, 0, results.length);
                newArray[newArray.length - 1] = combination;
                results = newArray;
            }
        }

        return results;

    }

    public static int[][] CombinationsOfSum(int[][] combinations, int sum) {

        int[][] results = new int[][]{};

        for (int[] combination : combinations) {

            int sumOfCombination = 0;
            for (int number : combination) {
                sumOfCombination += number;
            }

            if (sumOfCombination == sum) {
                int[][] newArray = new int[results.length + 1][];
                System.arraycopy(results, 0, newArray, 0, results.length);
                newArray[newArray.length - 1] = combination;
                results = newArray;
            }

        }

        return results;

    }

    public static int[][] CombinationsThatContain(int[][] combinations, int[] numbers, int amount) {

        int[][] result = new int[][]{};

        for (int[] combination : combinations) {
            int numbersContained = 0;
            for (int number : numbers) {
                if (Arrays.binarySearch(combination, number) >= 0) numbersContained++;
            }
            if (numbersContained == amount) {
                int[][] newArray = new int[result.length + 1][];
                System.arraycopy(result, 0, newArray, 0, result.length);
                newArray[newArray.length - 1] = combination;
                result = newArray;
            }
        }

        return result;
    }

}
