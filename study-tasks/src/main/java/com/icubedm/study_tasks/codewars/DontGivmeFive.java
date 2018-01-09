package com.icubedm.study_tasks.codewars;

public class DontGivmeFive {

    public static void main(String[] args) {
        System.out.println(dontGiveMeFive(1, 26)); // 23
        System.out.println(dontGiveMeFive(-12012,-100));
    }

    public static int dontGiveMeFive(int start, int end) {

        int result = 0;

        for1: for(int i = start; i <= end; i++ ) {

            int number = i < 0 ? i * -1 : i;

            while (number > 0) {
                int temp = number % 10;

                if(temp==5) {
                    continue for1;
                }

                number = number / 10;
            }

            result++;
        }

        return result;
    }
}
