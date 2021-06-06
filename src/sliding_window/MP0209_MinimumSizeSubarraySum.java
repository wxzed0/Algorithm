package sliding_window;
//长度最小的子数组    MMM
public class MP0209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0 , r = -1; // sliding window: nums[l...r]
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length){

            if(r + 1 < nums.length && sum < s){
                sum += nums[++ r];
            } else{
                sum -= nums[l ++];
            }
            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }

        return res == nums.length + 1 ? 0 : res;
    }


}
/**
   public int minSubArrayLen(int s, int[] nums) {

        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }
*/


/**
 *    public int minSubArrayLen(int s, int[] nums) {
 *
 *         int res = nums.length + 1;
 *         for(int l = 0 ; l < nums.length ; l ++) {
 *             int sum = 0;
 *             for (int r = l; r < nums.length; r++){
 *                 sum += nums[r];
 *                 if(sum >= s){
 *                     res = Math.min(res, r - l + 1);
 *                     break;
 *                 }
 *             }
 *         }
 *
 *         return res == nums.length + 1 ? 0 : res;
 *     }
 */