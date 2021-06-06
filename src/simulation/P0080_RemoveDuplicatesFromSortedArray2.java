package simulation;
//删除有序数组中的重复项 II
public class P0080_RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int index = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[index-2])
                nums[index++] = nums[i];
        }

        return index;
    }

}
