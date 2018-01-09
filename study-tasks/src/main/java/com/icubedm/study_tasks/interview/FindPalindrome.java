package com.icubedm.study_tasks.interview;

public class FindPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome("otto"));
        System.out.println(isPalindrome("foo"));
        System.out.println(isPalindrome("ofo"));
    }

    static boolean isPalindrome(String str) {

        int i = 0, j = str.length() - 1;

        while (i < j)
            if (str.charAt(i++) != str.charAt(j--))
                return false;

        return true;
    }
}
