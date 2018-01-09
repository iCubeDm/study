package com.icubedm.study_tasks.interview;

/*
Zalando task
 */
class WinterSummerAnton {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{5, -2, 3, 8, 6}));// 3
        System.out.println(solution(new int[]{-5, -5, -5, -42, 6, 12}));// 4
        System.out.println(solution(new int[]{-100, 100}));// 1
        System.out.println(solution(new int[]{-3, 5, 10, -4, 6, 18, 19, 13}));// 5
    }

    public static int solution(int[] arr) {

        if(arr == null || arr.length < 2) {
            return -1;
        }

        int maxWinterInd = 0;
        int maxWinterValue = arr[0];
        int possibleMaxWinterValue = arr[0];

        for(int i = 0; i < arr.length; i++) {

            int currentValue = arr[i];

            if(possibleMaxWinterValue < currentValue) {
                possibleMaxWinterValue = currentValue;
            }

            if(currentValue <= maxWinterValue) {
                maxWinterInd = i;
                maxWinterValue = possibleMaxWinterValue;
            }
        }

        return maxWinterInd + 1;
    }
}
