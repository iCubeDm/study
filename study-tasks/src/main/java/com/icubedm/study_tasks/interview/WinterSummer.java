package com.icubedm.study_tasks.interview;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class WinterSummer {

    public static void main(String[] args) {
//        int[] arr = {-5, -5, -5, -42, 6, 12};
        int[] arr = {-3, 5, 10, -4, 6, 18, 19, 13};

        WinterSummer sol = new WinterSummer();
        System.out.println(sol.solution(arr));
    }

    public int solution(int[] T) {
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
