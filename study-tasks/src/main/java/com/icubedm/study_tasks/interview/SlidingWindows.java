package com.icubedm.study_tasks.interview;

public class SlidingWindows {

    public static void main(String[] args) {

        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        System.out.println(maxSum(arr, k));
    }

    static int maxSum(int arr[], int k) {

        int n = arr.length;

        // k must be greater
        if (n < k) {
            return -1;
        }

        // Compute sum of first window of size k
        int resultMaxSum = 0;

        for (int i = 0; i < k; i++)
            resultMaxSum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int windowsSum = resultMaxSum;

        for (int i = k; i < n; i++) {
            windowsSum += arr[i] - arr[i - k];
            resultMaxSum = Integer.max(resultMaxSum, windowsSum);
        }

        return resultMaxSum;
    }
}
