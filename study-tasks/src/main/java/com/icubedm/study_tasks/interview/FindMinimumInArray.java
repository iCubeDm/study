package com.icubedm.study_tasks.interview;

/*

Find positive integer minimum from 1 to 10000000


For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

 */
public class FindMinimumInArray {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{2, 1, 1}));
        System.out.println(solution(new int[]{3, 1, 4}));
        System.out.println(solution(new int[]{-3, -6, 4}));
    }

    static int solution(int[] A) {

        int arr[] = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int val = A[i];

            if (val - 1 < arr.length && val - 1 >= 0) {
                arr[val - 1] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                return i + 1;
            }
        }

        return arr.length + 1;
    }
}
