package com.icubedm.study_tasks.hackerrank;

/**
 * @link https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class TwoDArrayHourglassSum {

    static int[][] arr = new int[][]{
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
    };

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 16; i++) {
            int col = i%4;
            int row = i/4;

            int sum = 0;

            for (int c = 0; c < 3; c++) {
                for (int r = 0; r < 3; r++) {

                    if(r == 1 && c != 1) continue;

                    sum+=arr[row+r][col+c];
                }
            }

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {


        int x = hourglassSum(arr);
        System.out.println(x); // should be 19

        int result = hourglassSum(arr);
    }
}
