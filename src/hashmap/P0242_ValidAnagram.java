package hashmap;

import java.util.HashMap;
//有效的字母异位词
public class P0242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()){

            Integer count = map.get(ch);
            if (count == null)
                return false;
            else if (count > 1)
                map.put(ch, count - 1);
            else
                map.remove(ch);
        }
        return map.isEmpty();
    }

}

/**
 * //    public boolean isAnagram1(String s, String t) {
 * //        char[] sChars = s.toCharArray();
 * //        char[] tChars = t.toCharArray();
 * //        Arrays.sort(sChars);
 * //        Arrays.sort(tChars);
 * //        return Arrays.equals(sChars, tChars);
 * //    }
 * //
 * //    public boolean isAnagram2(String s, String t) {
 * //        Map<Character, Integer> map = new HashMap<>();
 * //        for (char ch : s.toCharArray()) {
 * //            map.put(ch, map.getOrDefault(ch, 0) + 1);
 * //        }
 * //        for (char ch : t.toCharArray()) {
 * //            Integer count = map.get(ch);
 * //            if (count == null) {
 * //                return false;
 * //            } else if (count > 1) {
 * //                map.put(ch, count - 1);
 * //            } else {
 * //                map.remove(ch);
 * //            }
 * //        }
 * //        return map.isEmpty();
 * //    }
 * //}
 */