package dp;

import java.util.Arrays;
//完全平方数   MMM
public class P0279_PerfectSquares {

    public int numSquares(int n) {

        int[] mem = new int[n+1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;
        for(int i = 1; i <= n ; i ++)
            for(int j = 1 ; i - j * j >= 0 ; j ++)
                mem[i] = Math.min(mem[i], 1 + mem[i - j * j]);

        return mem[n];
    }

}
