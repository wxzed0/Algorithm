package simulation;
//移除元素
public class P0027_RemoveElement {

    public int removeElement(int[] nums, int val) {

        int res = 0;
        for(int i = 0; i < nums.length; i ++){

            if (nums[i] != val){
                nums[res] = nums[i];
                res ++;
            }
        }
        return res;
    }

}
