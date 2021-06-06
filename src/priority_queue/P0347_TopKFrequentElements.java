package priority_queue;

import java.util.*;

/// Priority Queue contains n - k elements
public class P0347_TopKFrequentElements {

    private class Pair implements Comparable<Pair> {
        public int num, freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair another) {
            return another.freq - this.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        if (k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            if (freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);

        if (k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Integer num : freq.keySet()) {
            int numFreq = freq.get(num);
            if (freq.size() - k > 0 && pq.size() == freq.size() - k && numFreq < pq.peek().freq) pq.poll();
            if (freq.size() - k > 0 && pq.size() < freq.size() - k) pq.add(new Pair(num, numFreq));
        }

        HashSet<Integer> notContains = new HashSet<>();
        while (!pq.isEmpty())
            notContains.add(pq.poll().num);

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (Integer key : freq.keySet())
            if (!notContains.contains(key)) res.add(key);

        return res;
    }
}
