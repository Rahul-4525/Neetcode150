package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    }

    // same length
    // same characters
    // same frequency
    // order does not matter
    // equal upon sorting
    public static List<List<String>> groupAnagrams(String[] ar) {
        Map<String, List<String>> hMap = new HashMap<>();
        for (String s : ar) {
            char[] freq = s.toCharArray();
            Arrays.sort(freq);
            hMap.computeIfAbsent(Arrays.toString(freq), newF -> new ArrayList<>())
                    .add(s);
        }

        return new ArrayList<>(hMap.values());
    }
}
