import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;

/**
 * *********email me your github link before 1 PM CDT*********
 *  *
 *  * solve with stream api
 *  *  // homework: there are few questions: find the first non-repeated character in a string
 *  *         // top K frequency words
 *  *         // Sum of unique elements
 */
public class Day3 {
    // find the first non-repeated character in a string
    public char nonRepeatingChar(String str) {
       return str.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
    }

    // top K frequency words
    public List<String> topKFrequentWords(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int freqCompare = b.getValue().compareTo(a.getValue());
                    return freqCompare != 0 ? freqCompare : a.getKey().compareTo(b.getKey());
                })
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Sum of unique elements
    public static int sumOfUniqueElements(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }


}
