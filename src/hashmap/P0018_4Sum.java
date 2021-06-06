package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//四数之和
public class P0018_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        int len=nums.length;
        if(len<4)
            return lists;
        Arrays.sort(nums);
        for(int i=0;i<len-3;i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)
                break;
            for(int j=i+1;j<len-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1])
                    continue;
                int left=j+1;
                int right=len-1;
                for(;left<len-1;left ++){
                    if(left!=j+1&&nums[left]==nums[left-1])
                        continue;
                    while(left<right&&nums[i]+nums[j]+nums[left]+nums[right]>target)
                        right--;
                    if(left>=right)
                        break;
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

}
