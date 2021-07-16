package Leetcode.code;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * <p>
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，要求该子串中的每一字符出现次数都不少于 k 。
 * 返回这一子串的长度。
 * <p>
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * <p>
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文字母组成
 * 1 <= k <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution395_1 {

    /**
     * 分治法，若chars[i]次数小于k，那么包含chars[i]的子串就一定不满足要求，
     * 所以就可以从这里把串分两部分
     */
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        return dfs(chars, 0, chars.length - 1, k);
    }

    /**
     * 官方题解
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/zhi-shao-you-kge-zhong-fu-zi-fu-de-zui-c-o6ww/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private int dfs(char[] chars, int l, int r, int k) {
//        System.out.println(l + "," + r + ", " + k);
        int[] counts = new int[26];
        for (int i = l; i <= r; i++) counts[chars[i] - 'a']++; //统计字符个数

        int notReady = -1;  //不满足条件的字符ASCII码
        for (int i = 0; i < 26; i++) {  //遍历counts而不是数组因为26次远小于数组长度
            if (counts[i] > 0 && counts[i] < k) {
                notReady = i + 'a';
                break;
            }
        }
        if (notReady < 'a') return r - l + 1; //所以字符出现次数均大于等于k

        //到了这里就说明当前l-r的字符串不满足条件
        int res = 0;
        int pos = l;
        while (pos <= r) {
            while (pos <= r && chars[pos] == notReady) pos++; //第一个满足条件的字符位置
            if (pos > r) break;
            int start = pos;
            while (pos <= r && chars[pos] != notReady) pos++; //找第一个不满足的字符位置
            /*counts[chars[pos]] >= k*/
            int left = dfs(chars, start, pos - 1, k);
            res = Math.max(res, left);
        }
        return res;
    }

    //注意是子串中每个字符的出现次数不小于k，所以这个解法不满足要求
    public int longestSubstringError(String s, int k) {
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        for (char c : chars) counts[c - 'a']++;

        int l = 0, len = chars.length;
        while (l < len && counts[chars[l] - 'a'] < k) l++; //找到第一个满足出现次数为k的位置
        if (l >= len) return 0;

        int max = 0, r = l + 1;
        while (l < len) {
            while (r < len && counts[chars[r] - 'a'] >= k) r++;
            max = Math.max(max, r - l);
            //此时chars[r]是不满足条件到
            l = r + 1;
            r = l + 1;
            if (max > len - l) break; //剩下的串即使全部满足也达不到最大了
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution395_1().longestSubstring("aaabb", 3));
//        System.out.println(new Solution395_1().longestSubstring("ababbc", 2));
        System.out.println(new Solution395_1().longestSubstring("ababacb", 3));
    }
}
