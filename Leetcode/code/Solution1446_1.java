package Leetcode.code;

/**
 * 1446. 连续字符
 * <p>
 * 给你一个字符串s，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 * <p>
 * 示例 1：
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * <p>
 * 示例 2：
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * <p>
 * 示例 3：
 * 输入：s = "triplepillooooow"
 * 输出：5
 * <p>
 * 示例 4：
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * <p>
 * 示例 5：
 * 输入：s = "tourist"
 * 输出：1
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * s只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/consecutive-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1446_1 {

    public int maxPower(String s) {
        int max = 1, count = 1, len = s.length();
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public int maxPower2(String s) {
        int max = 1, count = 1, len = s.length();
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                //这样只用写一次
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }

    /**
     * 双指针扫描
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/consecutive-characters/solution/gong-shui-san-xie-jian-dan-shuang-zhi-zh-xtv6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxPower3(String s) {
        int n = s.length(), ans = 1;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }


}
