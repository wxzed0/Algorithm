package backtracking;

import java.util.ArrayList;
import java.util.List;

public class P0093_RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        // IPV4:点分十进制 1、4段 2、0 - 255 3、前缀不能为0
        if (s == null || s.length() < 4) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backTracking(s, 0, res, new ArrayList<>());
        return res;
    }

    private void backTracking(String s, int index, List<String> res, List<String> ip) {
        if (index == s.length() && ip.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String num : ip) {
                sb.append(num + ".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }

        // 剪枝
        // 每段最多3个字符
        if (s.length() - index > 3 * (4 - ip.size())) {
            return;
        }
        // 每段最少1个字符
        if (s.length() - index < 4 - ip.size()) {
            return;
        }

        int num = 0;
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num < 0 || num > 255) {
                return;
            }
            // 前缀0
            if (i > index && s.charAt(index) == '0') {
                return;
            }
            ip.add(s.substring(index, i + 1));
            backTracking(s, i + 1, res, ip);
            ip.remove(ip.size() - 1);
        }
    }

}
