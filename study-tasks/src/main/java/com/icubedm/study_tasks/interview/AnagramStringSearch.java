package com.icubedm.study_tasks.interview;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AnagramStringSearch {

    public static void main(String[] args) throws IOException {

        String source = "-abc-codpajdhf-abc-jdfkas-bac-asfjjd-cab-cab";
        String prefix = "abc";
        Set<String> permutations = new HashSet<>(); // aka all possible anagrams
        permutation(prefix, "", permutations);
        int count = permutations.parallelStream().mapToInt(permutation -> findOccurrences(source, permutation)).sum();

        System.out.println(count);
    }


    private static void permutation(String str, String prefix, Set<String> permutations) {
        if (str.length() == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i), permutations);
            }
        }
    }

    private static int findOccurrences(String source, String substr) {
        int count = 0;
        int idx = 0;
        while ((idx = source.indexOf(substr, idx)) != -1) {
            count++;
            idx += substr.length();
        }
        return count;
    }
}
