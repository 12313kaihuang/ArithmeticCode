package Leetcode.code;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * <p>
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 10^4
 * s1 和 s2 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution567_1 {

    /**
     * 滑动窗口
     * <p>
     * 由于排列不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，
     * 一个字符串才是另一个字符串的排列。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (n < m) return false;
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (int i = 0; i < m; i++) {
            ++chars1[s1.charAt(i) - 'a'];
            ++chars2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(chars1, chars2)) return true;
        //开始滑动窗口 窗口大小固定
        for (int right = m; right < n; right++) {
            //每次滑动减去出去的字符加上新进的字符，减少计算
            ++chars2[s2.charAt(right) - 'a'];
            --chars2[s2.charAt(right - m) - 'a'];
            if (Arrays.equals(chars1, chars2)) return true;
        }
        return false;
    }
}
