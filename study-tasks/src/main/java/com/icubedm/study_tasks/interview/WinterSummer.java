package com.icubedm.study_tasks.interview;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Zalando task
 */
class WinterSummer {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{5, -2, 3, 8, 6}));// 3
        System.out.println(solution(new int[]{-5, -5, -5, -42, 6, 12}));// 4
        System.out.println(solution(new int[]{-100, 100}));// 1
        System.out.println(solution(new int[]{-3, 5, 10, -4, 6, 18, 19, 13}));// 5
    }

    public static int solution(int[] T) {
        // write your code in Java SE 8

        if(T == null || T.length < 2)
            throw new RuntimeException("Wrong input");

        int maxWinterIdx = 0;
        int maxWinterTemp = T[0];
        int potentialMaxWinterTemp = T[0];

        for (int i = 0; i < T.length; i++) {
            int currentTemp = T[i];
            potentialMaxWinterTemp = potentialMaxWinterTemp < currentTemp
                    ? currentTemp
                    : potentialMaxWinterTemp;
            if (currentTemp <= maxWinterTemp) {
                maxWinterIdx = i;
                maxWinterTemp = potentialMaxWinterTemp;
            }
        }

        return maxWinterIdx + 1;
    }
}
