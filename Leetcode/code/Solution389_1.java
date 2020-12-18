package Leetcode.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 389. 找不同
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution389_1 {

    //构建哈希表 key为char，value为次数
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            if (count == 0) return c;
            map.put(c, count - 1);
        }
        throw new IllegalArgumentException("Parameter is wrong");
    }

    /**
     * 用数组存
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 31.35% 的用户
     */
    public char findTheDifference2(String s, String t) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for (char c : s.toCharArray()) counts[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (counts[c - 'a'] == 0) return c;
            counts[c - 'a']--;
        }
        throw new IllegalArgumentException("Parameter is wrong");
    }

    public static void main(String[] args) {
        System.out.println(new Solution389_1().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution389_1().findTheDifference("", "y"));
        System.out.println(new Solution389_1().findTheDifference("a", "aa"));
        System.out.println(new Solution389_1().findTheDifference("ae", "aea"));
    }
}
