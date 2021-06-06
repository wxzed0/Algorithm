package dp;
//爬楼梯
public class P0070_ClimbingStairs {

    // dp[i] = dp[i-1] + dp[i-2]
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for(int i=3;i<=n;i++){
            int temp = i1+i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

}
/*
*这个代码其实就和用手算是一个思路。斐波那契的一般思路是从后往前看，
* 比如想求n=7时的解，根据楼下“狗蛋儿”说的这个公式
* dp[i] = dp[i-1] + dp[i-2]很容易就想到
* n=7时等于n=6时+n=5时，n=6和5又有n=5 + n=4和n=4 + n=3，
* 这么一步步下去就是递归了。 但"Javie"的做法是从前往后看的，
* 第一位 i1=1，第二位 i2=2，那第三位呢，就是temp = i1+i2，
* 然后让i2变成新的i1，就把i2赋值给i1，i2自己则变成下一位即temp，
* 这样一步一步往后移，用while循环控制移动几次，最后输出结果就可以了。
* */