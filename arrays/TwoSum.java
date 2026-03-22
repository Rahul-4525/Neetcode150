package arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] sum_found = new int[2];

        HashMap<Integer, Integer> hMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int rem = target - nums[i];
            if (hMap.containsKey(rem)) {
                return new int[]{i, hMap.get(rem)};
            }
            hMap.put(nums[i], i);
        }
        return sum_found;
    }
}
