package com.icubedm.study_tasks.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You have an array of numbers.
 * Your task is to sort ascending odd numbers but even numbers must be on their places.
 * <p>
 * Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.
 * <p>
 * Example
 * <p>
 * sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
 */
public class SortTheOdd {

    public static void main(String[] args) {

        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, sortArray(new int[]{5, 3, 2, 8, 1, 4}));
        assertArrayEquals(new int[]{1, 3, 5, 8, 0}, sortArray(new int[]{5, 3, 1, 8, 0}));
        assertArrayEquals(new int[]{}, sortArray(new int[]{}));
        assertArrayEquals(new int[]{1}, sortArray(new int[]{1}));
    }

    private static void assertArrayEquals(int[] arr1, int[] arr2) {
        System.out.println(String.format("Arrays equals %s: %s - %s ",
                Arrays.equals(arr1, arr2),
                Arrays.toString(arr1),
                Arrays.toString(arr2))
        );
    }

    public static int[] sortArray(int[] array) {

        List<Integer> oddIdxs = new ArrayList<>();
        List<Integer> oddValues = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i] % 2 != 0){
                oddIdxs.add(i);
                oddValues.add(array[i]);
            }
        }

        Collections.sort(oddValues);

        for (int i = 0; i < oddIdxs.size(); i++) {
            Integer oddIdx = oddIdxs.get(i);
            array[oddIdx] = oddValues.get(i);
        }

        return array;
    }
}
