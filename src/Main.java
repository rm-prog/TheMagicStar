import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int[][] combinations = FindCombinations(numbers, 26);

        System.out.println(Arrays.deepToString(combinations));
        System.out.println(combinations.length);

    }

    // find the combinations of the numbers in numbers, which sum up to sum (each number can only come once in a combination)
    static int[][] FindCombinations(int[] numbers, int sum) {

        if (numbers.length == 2) {
            if (numbers[0] == sum) return new int[][]{{numbers[0]}};
            else if (numbers[1] == sum) return new int[][]{{numbers[1]}};
            else if (numbers[0] + numbers[1] == sum) return new int[][]{{numbers[0], numbers[1]}};

            return new int[0][];
        }

        int[][] combinations = new int[0][];

        for (int i = 0; i < numbers.length; i++) {

            // find all combination with the number numbers[i] in it

            int[] numbersSubArray = new int[numbers.length - 1];

            System.arraycopy(numbers, i + 1, numbersSubArray, 0, numbers.length - i - 1);


            if (sum == numbers[i]) {
                // we just found a combination, whose last number is number[i]
                int[][] newArray = new int[combinations.length + 1][];
                System.arraycopy(combinations, 0, newArray, 0, combinations.length);
                newArray[combinations.length] = new int[]{numbers[i]};

                combinations = newArray;
            }
            // is another combination possible or not
            else if (numbersSubArray.length > 0 && sum - numbers[i] >= numbersSubArray[0]) {

                int[][] subCombinations = FindCombinations(numbersSubArray, sum - numbers[i]);

                for (int[] subCombination : subCombinations) {
                    int[][] newArray = new int[combinations.length + 1][];
                    System.arraycopy(combinations, 0, newArray, 0, combinations.length);
                    newArray[combinations.length] = new int[subCombination.length + 1];
                    newArray[combinations.length][0] = numbers[i];
                    System.arraycopy(subCombination, 0, newArray[combinations.length], 1, subCombination.length);

                    combinations = newArray;
                }

            }


        }

        return combinations;

    }

}