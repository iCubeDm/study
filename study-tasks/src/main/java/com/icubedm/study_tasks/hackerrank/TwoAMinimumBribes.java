package com.icubedm.study_tasks.hackerrank;

import java.util.Scanner;

public class TwoAMinimumBribes {

//2
//5
//2 1 5 3 4
//5
//2 5 1 3 4

    // Complete the minimumBribes function below.
    // Do the bubble sort and calculate an amount of swaps. Every swap == bribe
    static void minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = 0; i < q.length; i++) {

            int currentNumber = q[i];

            if (currentNumber - i - 1 > 2) {
                System.out.println("Too chaotic");
                return;
            }

            int shift = currentNumber - 2;

            int maxShift = Math.max(0, shift);

            for (int j = maxShift; j < i; j++){

                int shiftedNumber = q[j];

                if (shiftedNumber > currentNumber) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        minimumBribes(new int[]{2, 1, 5, 3, 4}); // 3
        minimumBribes(new int[]{2, 5, 1, 3, 4}); // Too chaotic
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}); // 7


        /*int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();*/
    }
}
