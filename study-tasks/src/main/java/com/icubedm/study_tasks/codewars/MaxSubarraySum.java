package com.icubedm.study_tasks.codewars;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 * <p>
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
 * <p>
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class MaxSubarraySum {

    public static void main(String[] args) {
        System.out.println(String.format("Expected %s, Actual %s", 0, sequence(new int[]{})));
        System.out.println(String.format("Expected %s, Actual %s", 6, sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
    }

    public static int sequence(int[] arr) {
        boolean allNegative = true;

        for (int i : arr) {
            if (i > 0) allNegative = false;
        }

        if (arr.length == 0 || allNegative) return 0;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;

            if (maxEndingHere < 0) maxEndingHere = 0;
        }
        return maxSoFar;
    }
}
