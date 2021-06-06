package hashmap;

import java.util.HashSet;
//两个数组的交集
public class P0349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> record = new HashSet();
        for (int num : nums1)
            record.add(num);

        HashSet<Integer> resultSet = new HashSet();
        for (int num : nums2){
            if (record.contains(num))
                resultSet.add(num);
        }

        int[] res = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet)
            res[index ++] = num;

        return res;
    }

}
