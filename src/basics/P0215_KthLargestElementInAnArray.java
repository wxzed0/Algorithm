package basics;

import java.util.PriorityQueue;
import java.util.Queue;

//数组中的第K个最大元素
//小顶堆
public class P0215_KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if(pq.size() < k){
                pq.add(num);
            }
            else if(pq.peek() < num){
                pq.remove();
                pq.add(num);
            }
        }
        return pq.peek();
    }

}
