package backtracking;

import java.util.ArrayList;
import java.util.List;

public class P0131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        dfs(s,0, new ArrayList<String>(), list);
        return list;
    }

    private void dfs(String s, int start, ArrayList<String> path, List<List<String>> list) {
        if (start == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String s1 = s.substring(start, i + 1);
            if (!isPalindrome(s1)) {
                continue;
            }
            path.add(s1);
            dfs(s,i + 1, path, list);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}


/*
public List<List<String>> partition(String s) {
        // 先弄一个dp[i][j]  表示[i,j]是属于回文串的为true，否则为false,其中i <=j
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[cs.length][cs.length];
        for(int i=0;i<cs.length;i++) {
            dp[i][i] = true; // 表示第一个数字，第二个数字单独的都是回文串
        }
        for(int j=1;j<cs.length;j++) {
            for(int i=0;i<j;i++) {
                dp[i][j] = (cs[i] == cs[j]) && ((j-i <=2) || (dp[i+1][j-1]));
            }
        }
        // 现在统计出来的每一个范畴的回文串是如何,开始遍历
        List<List<String>> ans = new ArrayList<>();
        dfs(s, dp, ans, 0, cs.length, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, boolean[][] dp, List<List<String>> ans, int index, int length, List<String> tmp) {
        if (index >= length) {
            ans.add(new ArrayList<>(tmp));
            return ;
        }
        boolean[] dpp = dp[index];
        for(int k = index; k < length;k++) {
            if (dpp[k]) {
                tmp.add(s.substring(index, k+1));
                // 这一段是回文，那么下一个开始的位置就是k+1
                dfs(s, dp, ans, k+1, length, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    */