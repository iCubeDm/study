package com.icubedm.study_tasks.interview;

import java.util.stream.IntStream;

import static java.lang.String.valueOf;

public class ShortestFizzBuzz {

    public static void main(String[] args) {

//        solutionBasic();
        solutionStreams();
    }

    static void solutionBasic() {
        // 92 characters without spaces
        for (int i = 1; i < 101; i++)
            System.out.println(i % 15 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : valueOf(i));
    }

    static void solutionStreams() {
        IntStream.range(1, 101).forEach(i ->
            System.out.println(i % 15 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : valueOf(i)));
    }
}
