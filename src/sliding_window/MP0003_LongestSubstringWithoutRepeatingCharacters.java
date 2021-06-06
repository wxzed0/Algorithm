package sliding_window;
//无重复字符的最长子串 MMM
public class MP0003_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1; // sliding window: s[l...r]
        int res = 0;

        while( r + 1 < s.length() ){

            if( r + 1 < s.length() && freq[s.charAt(r+1)] == 0 )
                freq[s.charAt(++r)] ++;
            else    //freq[s[r+1]] == 1
                freq[s.charAt(l++)] --;

            res = Math.max(res, r-l+1);
        }

        return res;
    }

}


/**
 *  public int lengthOfLongestSubstring(String s) {
 *
 *         int[] last = new int[256];
 *         Arrays.fill(last, -1);
 *
 *         int l = 0, r = -1; // sliding window: s[l...r]
 *         int res = 0;
 *         while(r + 1 < s.length()){
 *
 *             r ++;
 *             if(last[s.charAt(r)] != -1)
 *                 l = Math.max(l, last[s.charAt(r)] + 1);
 *
 *             res = Math.max(res, r - l + 1);
 *             last[s.charAt(r)] = r;
 *         }
 *
 *         return res;
 *     }
 */