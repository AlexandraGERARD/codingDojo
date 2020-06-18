package anagram;

import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

    public static String getAnagram(String input) {
        if (null != input) {
            StringBuilder result = new StringBuilder();

            if (!input.isBlank()) {
                Stream.of(input.split("")).collect(Collectors.toCollection(ArrayDeque::new))
                        .descendingIterator().forEachRemaining(result::append);
            }

            return result.toString();
        }

        return null;
    }
}