package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//两个数组的交集2
public class P0350_IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int num : nums1){
            if (!record.containsKey(num))
                record.put(num, 1);
            else
                record.put(num, record.get(num) + 1);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int num : nums2){
            if (record.containsKey(num) && record.get(num) > 0){
                result.add(num);
                record.put(num, record.get(num) - 1);
            }
        }
        int[] ret = new int[result.size()];
        int index = 0;
        for (int num : result)
            ret[index ++] = num;

        return ret;
    }

}
