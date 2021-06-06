package hashmap;

import java.util.HashSet;

//存在重复元素
public class P0217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.contains(nums[i])){
                return true;
            }else{
                hash.add(nums[i]);
            }
        }
        return false;
    }

}
/**
 * HashSet<Integer> n = new HashSet<Integer>();
 *         for(int i = 0;i<nums.length;i++){
 *         	if(!n.add(nums[i]))
 *         		return true;
 *         }
 * 		return false;
 */