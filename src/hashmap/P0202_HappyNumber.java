package hashmap;

import java.util.HashSet;
//快乐数
public class P0202_HappyNumber {

    public int nextNum(int n) {
        int next = 0;
        while(n > 0) {
            next += (n % 10) * (n % 10);
            n = n / 10;
        }
        return next;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = nextNum(n);
        }
        return n == 1;
    }
}


/**
 * public boolean isHappy(int n) {
 * //        Map<Integer, Integer> map = new HashMap<>();
 * //        while (n != 1) {
 * //            int temp = 0;
 * //            while (n > 0) {
 * //                temp += Math.pow(n % 10, 2);
 * //                n = n / 10;
 * //            }
 * //            if (map.containsKey(temp)) {
 * //                return false;
 * //            } else {
 * //                map.put(temp, 1);
 * //            }
 * //            n = temp;
 * //        }
 * //        return true;
 * //    }
 */