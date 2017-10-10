package com.icubedm.study_tasks.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatedChar {

    public static void main(String[] args) {
        String input = "efficient"; // expected 'c'
        System.out.println(solution(input));
    }

    private static Optional<Character> solution(String input) {

        if (input == null || input.isEmpty())
            return null;

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            int value = map.getOrDefault(c, 0);
            map.put(c, value + 1);
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
