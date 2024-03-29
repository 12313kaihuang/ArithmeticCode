package Leetcode.code;

/**
 * 686. 重复叠加字符串匹配
 * <p>
 * 给定两个字符串a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，
 * 如果不存在则返回 -1。
 * 注意：字符串 "abc"重复叠加 0 次是 ""，重复叠加 1 次是"abc"，重复叠加 2 次是"abcabc"。
 * <p>
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * <p>
 * 示例 2：
 * 输入：a = "a", b = "aa"
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：a = "a", b = "a"
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= a.length <= 10^4
 * 1 <= b.length <= 10^4
 * a 和 b 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution686_1 {
    /**
     * 朴素解法，没太理解原理 = =
     * <p>
     * 还有KMP算法也没看
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/repeated-string-match/solution/gong-shui-san-xie-yi-ti-san-jie-qia-chan-3hbr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);  //下界
        sb.append(a); //到达上界
        int idx = sb.indexOf(b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }
}
