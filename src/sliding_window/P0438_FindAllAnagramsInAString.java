package sliding_window;

import java.util.ArrayList;
import java.util.List;

//找到字符串中所有字母异位词
public class P0438_FindAllAnagramsInAString {

    public static List<Integer> isTX(String s, String p){
        List<Integer> array = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if(slen < plen) return array;
        char[] ch_s = s.toCharArray();
        char[] ch_p = p.toCharArray();
        int[] count = new int[26];
        for(int i = 0; i < plen; i++){
            count[ch_p[i] - 97] ++;
        }
        int invalidTime = 0;
        for(int j = 0; j < plen; j++){
            if(count[ch_s[j] - 97] -- <= 0){
                invalidTime ++;
            }
        }
        int i = 0;
        for(; i < slen - plen; i ++){
            if(invalidTime == 0)  array.add(i);
            if(count[ch_s[i] - 97] ++  < 0) invalidTime--;
            if(count[ch_s[i+plen] - 97] -- <=0) invalidTime ++;
        }
        if(invalidTime == 0)  array.add(i);
        return array;
    }
}

