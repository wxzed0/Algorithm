package hashmap;

import java.util.HashSet;
//存在重复元素2
public class P0219_ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length <= 1)
            return false;

        if (k <= 0)
            return false;

        HashSet<Integer> record = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i]))
                return true;

            record.add(nums[i]);
            if (record.size() == k + 1)
                record.remove(nums[i - k]);
        }

        return false;
    }
}

/**
 * public boolean containsNearbyDuplicate(int[] nums, int k) {
 *
 *         if (nums == null || nums.length <= 1)
 *             return false;
 *
 *         if (k <= 0)
 *             return false;
 *
 *         HashMap<Integer, Integer> record = new HashMap<>();
 *         record.put(nums[0], 0);
 *         for (int i = 1; i < nums.length; i++) {
 *             if (record.containsKey(nums[i]) && i - record.get(nums[i]) <= k)
 *                 return true;
 *
 *             record.put(nums[i], i);
 *         }
 *
 *         return false;
 *     }
 *
 *     private static void printBool(boolean b) {
 *         System.out.println(b ? "True" : "False");
 *     }
 */