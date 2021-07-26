package Leetcode.code;

@SuppressWarnings("unused")
public class Solution5_2 {

    /**
     * 动态规划 O(n^2)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) dp[i][i] = true;

        char[] chars = s.toCharArray();
        // 递推开始 先枚举子串长度
        for (int length = 2; length <= len; length++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int l = 0; l < len; l++) {
                // 由 length 和 l 可以确定右边界，即 r - l + 1 = length 得
                int r = length + l - 1;
                // 如果右边界越界，就可以退出当前循环
                if (r >= len) break;

                //状态转移方程
                if (chars[l] != chars[r]) {
                    dp[l][r] = false;
                } else {
//                    dp[l][r] = r - l < 3 ? true :dp[l + 1][r - 1];
                    dp[l][r] = r - l < 3 || dp[l + 1][r - 1];
                }

                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 中心扩展 O(n^2)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
