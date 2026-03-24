package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence{

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
    
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1) && !visited.contains(num)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    visited.add(num+length);
                    length++;
                }
                longest = Math.max(longest, length);
                visited.add(num);
            }
        }
        return longest;
    }
}
