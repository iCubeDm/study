package com.icubedm.study_tasks.codewars;


/**
 * Your friend won't stop texting his girlfriend. It's all he does. All day. Seriously. The texts are so mushy too! The whole situation just makes you feel ill. Being the wonderful friend that you are, you hatch an evil plot. While he's sleeping, you take his phone and change the autocorrect options so that every time he types "you" or "u" it gets changed to "your sister."
 * <p>
 * Write a function called autocorrect that takes a string and replaces all instances of "you" or "u" (not case sensitive) with "your sister" (always lower case).
 * <p>
 * Return the resulting string.
 * <p>
 * Here's the slightly tricky part: These are text messages, so there are different forms of "you" and "u".
 * <p>
 * For the purposes of this kata, here's what you need to support:
 * <p>
 * "youuuuu" with any number of u characters tacked onto the end
 * "u" at the beginning, middle, or end of a string, but NOT part of a word
 * "you" but NOT as part of another word like youtube or bayou
 */
public class Autocorrect {

    public static void main(String[] args) {
        testApply();
    }

    public static String autocorrect(String input) {
        // your code here
        return input.replaceAll("(?i)\\by+o+u+\\b|\\bu+\\b", "your sister"); // "corrected" input
    }

    public static void testApply() {
        String[] inputs = new String[]{
                "u",
                "you",
                "You",
                "yOu",
                "Youuuuu",
                "uuuuuuu",
                "yyyyou",
                "yoooou",
                "yyoooouu",
                "youtube",
                "You u youville utube you youyouyou uuu raiyou united youuuu u you"
        };



        for (String input : inputs) {
            System.out.println(autocorrect(input));
        }
    }
}
