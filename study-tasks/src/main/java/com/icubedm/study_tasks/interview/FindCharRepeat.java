package com.icubedm.study_tasks.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FindCharRepeat {

    public static void main(String[] args) {

        getFirstChar("aaи").ifPresent(System.out::println);
    }

    static Optional<Char> getFirstChar(String str) {

        Map<Char, Long> map = new LinkedHashMap<>();

        str.chars().forEach(c -> {
            Char key = new Char((char)c);

            map.putIfAbsent(key, 0L);
            map.computeIfPresent(key, (k, v) -> v + 1);
        });

        return map.entrySet().stream()
                .filter(en -> en.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey);
    }

    static class Char {
        char ch;

        public Char(char ch) {
            this.ch = ch;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Char aChar = (Char) o;

            return ch == aChar.ch;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return "Char{" +
                    "ch=" + ch +
                    '}';
        }
    }
}
