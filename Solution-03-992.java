import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                int value = nums[left];

                map.put(value, map.get(value) - 1);

                if (map.get(value) == 0) {
                    map.remove(value);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
