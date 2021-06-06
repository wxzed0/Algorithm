package hashmap;

import java.util.HashMap;
import java.util.Map;

//四数相加 II
public class P0454_4Sum2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                map.put(a + b , map.getOrDefault(a + b, 0) + 1);
            }
        }
        int sum = 0;
        for(int a : C){
            for(int b : D){
                if(map.containsKey(0 - a - b)){
                    sum += map.get(0 -a - b);
                }
            }
        }
        return sum;
    }

}
