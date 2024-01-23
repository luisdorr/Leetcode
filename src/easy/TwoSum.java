//Link: https://leetcode.com/problems/two-sum/description/
package easy;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numToIndex.containsKey(diff)) {
                return new int[]{numToIndex.get(diff), i};
            }
            numToIndex.put(nums[i], i);
        }

        return null;
    }
}