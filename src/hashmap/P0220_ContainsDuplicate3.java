package hashmap;

import java.util.TreeSet;

//存在重复元素3
public class P0220_ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0)
            return false;

        TreeSet<Long> record = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {

            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
                return true;

            record.add((long) nums[i]);

            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }

        return false;
    }

}


/**
 * // Based on Buckets
 * // each time, all we need to check is the bucket that x belongs to and its two adjacent buckets
 * //
 * // One thing worth mentioning is the difference from bucket sort –
 * // Each of our buckets contains at most one element at any time,
 * // because two elements in a bucket means "almost duplicate" and we can return early from the function.
 * // Therefore, a HashMap with an element associated with a bucket label is enough for our purpose.
 * //
 * // Time Complexity: O(n)
 * // Space Complexity: O(k)
 * public class Solution2 {
 *
 *     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
 *
 *         if (t < 0)
 *             return false;
 *
 *         HashMap<Long, Long> buckets = new HashMap<Long, Long>();
 *         long w = (long) t + (long) 1;
 *         for (int i = 0; i < nums.length; i++) {
 *
 *             long num = (long) nums[i];
 *             long id = getID(num, w);
 *
 *             // check if bucket id is empty, each bucket may contain at most one element
 *             if (buckets.containsKey(id))
 *                 return true;
 *
 *             // check the neighbor buckets for almost duplicate
 *             if (buckets.containsKey(id - 1) &&
 *                     buckets.get(id - 1) >= num - (long) t)
 *                 return true;
 *
 *             if (buckets.containsKey(id + 1) &&
 *                     buckets.get(id + 1) <= num + (long) t)
 *                 return true;
 *
 *             // now bucket id is empty and no almost duplicate in neighbor buckets
 *             buckets.put(id, num);
 *
 *             if (buckets.size() == k + 1)
 *                 buckets.remove(getID((long) nums[i - k], w));
 *         }
 *
 *         return false;
 *     }
 *     private long getID(long x, long w){
 *         return x < 0 ? (x + 1) / w - 1 : x / w;
 *     }
 *
 *     private static void printBool(boolean b){
 *         System.out.println(b ? "True" : "False");
 *     }
 * }
 */