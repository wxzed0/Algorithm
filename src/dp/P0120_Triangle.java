package dp;

import java.util.List;

//三角形最小路径和
public class P0120_Triangle {
//解法1 二维数组进行求解
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        // 加1可以不用初始化最后一层
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];

        for (int i = triangle.size()-1; i>=0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0 ; j< curTr.size(); j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }

}


    /**
     * 解法2 一维数组进行求解
     * @param triangle
     * @return
     */
 /**   public int minimumTotal(List<List<Integer>> triangle) {
  if (triangle == null || triangle.size() == 0){
  return 0;
  }
  // 只需要记录每一层的最小值即可
  int[] dp = new int[triangle.size()+1];

  for (int i = triangle.size() - 1; i >= 0; i--) {
  List<Integer> curTr = triangle.get(i);
  for (int j = 0; j < curTr.size(); j++) {
  //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
  dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
  }
  }
  return dp[0];
  }
  */