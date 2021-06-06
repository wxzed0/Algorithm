package simulation;

import java.util.ArrayList;

//移动零
public class P0283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

        //将vec中所有非0元素放入nonZeroElement中
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != 0)
                nonZeroElements.add(nums[i]);

        //将nonZeroElements中的所有元素依次放入到nums开始的位置
        for (int i = 0; i < nonZeroElements.size(); i++)
            nums[i] = nonZeroElements.get(i);

        //将nums剩余位置放置为0
        for (int i = nonZeroElements.size(); i < nums.length; i ++)
            nums[i] = 0;

    }

}
