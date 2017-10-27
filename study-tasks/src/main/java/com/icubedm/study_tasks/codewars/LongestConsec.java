package com.icubedm.study_tasks.codewars;

/**
 * You are given an array strarr of strings and an integer k. Your task is to return the first longest string consisting of k consecutive strings taken in the array.
 * <p>
 * #Example: longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
 * <p>
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 */
public class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        if (strarr == null || k <= 0 || strarr.length == 0 || strarr.length < k) return "";
        String result = "";
        for (int i = 0; i <= strarr.length - k; i++) {
            StringBuilder concat = new StringBuilder("");
            for (int j = i; j < i + k; j++) concat.append(strarr[j]);
            if (result.length() < concat.length()) result = concat.toString();
        }

        return result;
    }


    public static void main(String[] args) {
        test();
    }

    private static void testing(String actual, String expected) {
        if (expected.equals(actual)) System.out.println("true! [" + actual + "]");
        else System.out.println("false! expected: [" + expected + "] actual: [" + actual + "]");
    }


    public static void test() {
        System.out.println("longestConsec Fixed Tests");
        testing(LongestConsec.longestConsec(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        testing(LongestConsec.longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
        testing(LongestConsec.longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
        testing(LongestConsec.longestConsec(new String[]{}, 3), "");
        testing(LongestConsec.longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2), "wlwsasphmxxowiaxujylentrklctozmymu");
        testing(LongestConsec.longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
        testing(LongestConsec.longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3), "ixoyx3452zzzzzzzzzzzz");
        testing(LongestConsec.longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
        testing(LongestConsec.longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
    }
}
