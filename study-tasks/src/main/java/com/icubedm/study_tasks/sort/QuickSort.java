package com.icubedm.study_tasks.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println(Arrays.toString(arr));

        sort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }


    private static void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of the smaller element
        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
