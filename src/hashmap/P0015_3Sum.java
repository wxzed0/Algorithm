package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//三数之和
public class P0015_3Sum {

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i ++){
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]){   //   这一步不是很懂

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r){
                    if (nums[l] + nums[r] == sum){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l + 1] == nums[l]) l ++;
                        while (l < r && nums[r - 1] == nums[r]) r --;
                        l ++;
                        r --;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l + 1] == nums[l]) l ++;
                        l++;
                    }
                    else {
                        while (l < r && nums[r - 1] == nums[r]) r--;
                        r--;
                    }
                }
            }
        }
        return res;
    }

}
