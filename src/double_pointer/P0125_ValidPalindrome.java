package double_pointer;
//验证回文串
public class P0125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()){
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'))
                str.append(c);
        }

        // return str.toString().equals(str.reverse().toString());
        str.toString();
        for (int i = 0; i < str.length() / 2; i ++){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        return true;
    }

}
