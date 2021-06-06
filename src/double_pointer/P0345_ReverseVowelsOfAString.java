package double_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//反转字符串中的元音字母
public class P0345_ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s.length() <= 1) return s;
        int l = 0;
        int r = s.length() - 1;

        char[] arr = s.toCharArray();
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet(Arrays.asList(chars));

        while (l < r){
            while (l < r && !set.contains(arr[l])) {l ++;}
            while (l < r && !set.contains(arr[r])) {r --;}
            if (arr[l] != arr[r]){
                char temp = arr[l];
                arr[l] = arr [r];
                arr[r] = temp;
            }
            l ++;
            r --;
        }
        return new String(arr);
    }

}
