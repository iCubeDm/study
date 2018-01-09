package com.icubedm.study_tasks.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.Arrays.asList;

/**

Диман, [Oct 30, 2017, 9:50:46 PM]:
дана строка, заменить все слова из 3,4 букв на апперкейс

потом добавить правило, что заменяем также слова содержащие "е"

как будешь расширять что-то подобное

 */
public class WordReplacer {
    public static void main(String[] args) {

        System.out.println(replaceWords("Red fox catches 10vish cats"));
        System.out.println(replaceWords("Some man do it 201 nightes in a rows"));
    }

    static String replaceWords(String input) {

        if(input == null)  {
            return null;
        }

        final String[] words = input.split("\\s");

        final StringBuilder result = new StringBuilder();

        asList(words).forEach(word -> {
            result.append(changeWord(word)).append(" ");
        });

        return result.toString();
    }

    static String changeWord(String word) {

        return rulesMap.entrySet()
                .stream()
                .filter(es -> word.matches(es.getKey()))
                .findFirst()
                .map(es -> es.getValue().apply(word))
                .orElse(word);
    }

    // RULES

    static Map<String, Function<String, String>> rulesMap = new HashMap<>();

    static {
        rulesMap.put("\\w{4}", String::toUpperCase);
        rulesMap.put("\\w*[Ee]+\\w*", String::toUpperCase);
        rulesMap.put("\\w*[\\d]+\\w*", (str) -> {

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                sb.append(ch);

                if(Character.isDigit(ch)) {
                    sb.append('.');
                }
            }

            return sb.toString();
        });
    }
}
