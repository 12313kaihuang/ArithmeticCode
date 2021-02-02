package Leetcode.code;

/**
 * 424. 替换后的最长重复字符
 * <p>
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
 * 总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过104。
 * <p>
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * <p>
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution424_1 {

    /**
     * 滑动窗口 详见
     * https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/tong-guo-ci-ti-liao-jie-yi-xia-shi-yao-shi-hua-don/
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] map = new int[26];
        int max = 0;
        int left = 0, right = 0;
        for (right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            map[index]++;
            max = Math.max(max, map[index]);
            if (right - left + 1 > max + k) {
                //最多的字符串加上k之后仍不能装满窗口则滑动窗口
                map[s.charAt(left) - 'A']--;  //减去被滑走的那个字符统计
                left++;
            }
            //扩大窗口
        }
        return s.length() - left;  //窗口的大小
    }

}
