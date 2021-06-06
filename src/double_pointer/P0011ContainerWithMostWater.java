package double_pointer;
//盛最多水的容器
public class P0011ContainerWithMostWater {

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) return 0;

        int l = 0;
        int r = len - 1;

        int res = 0;
        while (l < r){
            int minHeight = Math.min(height[l] , height[r]);
            res = Math.max(res , minHeight * (r - l));

            if (height[l] < height[r]) l ++;
            else r --;
        }
        return res;
    }

}
