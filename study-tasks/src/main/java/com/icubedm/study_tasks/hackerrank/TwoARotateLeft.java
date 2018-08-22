package com.icubedm.study_tasks.hackerrank;

import java.util.Arrays;

public class TwoARotateLeft {


    static int[] arr = new int[]{1, 2, 3, 4, 5, 10, -20, 40};

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] hold = new int[d];

        // save d first in the hold array
        for (int i = 0; i < d; i++) {
            hold[i] = a[i];
        }

        // move the rest of the array d positions to the left
        for (int i = d; i < a.length; i++) {
            a[i - d] = a[i];
        }

        // replace last d positions with saved in hold values respecting order
        for (int i = hold.length - 1; i >= 0; i--) {
            a[a.length - d + i] = hold[i];
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = rotLeft(arr, 2);

        System.out.println(Arrays.toString(a));
    }
}
