package com.icubedm.study_tasks.interview;

/*
Zalando task
 */
class WinterSummerAnton {

    public static void main(String[] args) {
//        int[] arr = {-5, -5, -5, -42, 6, 12}; // 3
//        int[] arr = {-3, 5, 10, -4, 6, 18, 19, 13}; // 7
//        int[] arr = {1, 4, 2, 3, 5, 6}; // 3
        int[] arr = {-100, 100}; // 1

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {

        if(arr == null || arr.length < 2) {
            return -1;
        }

        int maxWinterInd = 0;
        int maxWinterValue = arr[0];

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] > maxWinterValue) {
                maxWinterValue = arr[i];
            } else {
                maxWinterInd = i;
            }
        }

        return maxWinterInd;
    }
}
