package Leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5. 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution5_1 {

    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.putIfAbsent(chars[i], new ArrayList<>());
            map.get(chars[i]).add(i);
        }
        for (int i = 0; i < chars.length; i++) {
            List<Integer> list = map.get(chars[i]);
            int next = 0, size = list.size();
            while (next < size && list.get(next) <= i) next++; //找到当前ch后相同字符的位置
            for (; next < size; next++) {
                int end = list.get(next);
                if ((end - i + 1) > res.length() && check(chars, i, end)) {
//                    System.out.println("s = " + s.substring(i, end + 1));
                    res = s.substring(i, end + 1);
                }
            }
        }
        return res;
    }

    private boolean check(char[] chars, int start, int end) {
//        System.out.println("check " + Arrays.toString(chars) + ", " + start + "," + end);
        if (start == end) return true;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
