package de.mf.algo.inversion;

import java.util.Arrays;

public class NumberInversion {

    /**
     * Count the number of inversion in a given array of distinct elements.
     *
     * @param numbers distinct array of integers.
     * @return number of inversions in the given array.
     */
    public static int countInversions(int[] numbers) {
        return countInversions(numbers, 0, numbers.length);
    }

    private static int countInversions(int[] numbers, int start, int end) {
        int middle = Math.floorDiv(start + end, 2);
        int inversions = 0;

        if (end - start > 2) {
            inversions += countInversions(numbers, start, middle);
            inversions += countInversions(numbers, middle, end);
        }

        int[] left = Arrays.copyOfRange(numbers, start, middle);
        int[] right = Arrays.copyOfRange(numbers, middle, end);

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = start; i < end; i++) {

            if (leftIndex >= left.length) {
                System.arraycopy(right, rightIndex, numbers, i, end - i);
                break;
            } else if (rightIndex >= right.length) {
                System.arraycopy(left, leftIndex, numbers, i, end - i);
                break;
            }

            int a = left[leftIndex];
            int b = right[rightIndex];

            if (a < b) {
                numbers[i] = a;
                leftIndex++;
            } else {
                numbers[i] = b;
                rightIndex++;
                inversions += left.length - leftIndex;
            }
        }

        return inversions;
    }


}