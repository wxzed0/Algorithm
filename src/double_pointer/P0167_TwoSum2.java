package double_pointer;
//两数之和 II - 输入有序数组
public class P0167_TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {

        assert (numbers.length >= 2);
        int l = 0,r = numbers.length - 1;
        while (l < r){

            if (numbers[l] + numbers[r] == target){
                int[] res = {l + 1, r + 1};
                return res;
            }
            else if (numbers[l] + numbers[r] < target)
                l ++;
            else
                r --;
        }
        throw new IllegalArgumentException("The input has no solution");
    }
}
/**
    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2)
            throw new IllegalArgumentException("Illegal argument numbers");

        for (int i = 0; i < numbers.length;i ++)
            for (int j = i + 1; j < numbers.length; j ++){
                if (numbers[i] + numbers[j] == target){
                    int res[] = {i + 1, j + 1};
                    return res;
                }
            }
        throw new IllegalArgumentException("The Input has no solution");

    }
*/
