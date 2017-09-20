package com.icubedm.study_tasks;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class ZTask2 {

    public static void main(String[] args) {
        int[] arr = {-1_000_000_000,1_000_000_001};
//        int[] arr = {-5, -5, -5, -42, 6, 12};

        ZTask2 sol = new ZTask2();
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
            potentialMaxWinterTemp = potentialMaxWinterTemp < T[i] ? T[i] : potentialMaxWinterTemp;
            if (T[i] <= maxWinterTemp) {
                maxWinterIdx = i;
                maxWinterTemp = potentialMaxWinterTemp;
            }
        }

        return maxWinterIdx + 1;
    }
}