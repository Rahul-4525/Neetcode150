package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> tm = new HashMap<>();

        for (int num : nums) {
            tm.put(num, tm.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        tm.entrySet().forEach(e -> {
            if (buckets[e.getValue()] == null) {
                buckets[e.getValue()] = new ArrayList<>();
                buckets[e.getValue()].add(e.getKey());
            } else {
                buckets[e.getValue()].add(e.getKey());
            }
        });

        int[] result = new int[k];
        int j = 0;

        for (int i = buckets.length - 1; i >= 0 && j < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    if (j >= k) {
                        break;
                    }
                    result[j++] = num;
                    if (j == k)
                        break;
                }
            }
        }
        return result;
    }
}
