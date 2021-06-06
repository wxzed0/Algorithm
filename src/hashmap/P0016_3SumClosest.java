package hashmap;

import java.util.Arrays;
//最接近的三数之和
public class P0016_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeestNum = nums[0] + nums[1] +nums[2];

        for (int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;

            while (l < r){
                int threeNum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeNum - target) < Math.abs(closeestNum - target))
                    closeestNum = threeNum;

                if (threeNum < target) l++;
                else if (threeNum > target) r--;
                else return target;
            }
        }
        return closeestNum;
    }

}
