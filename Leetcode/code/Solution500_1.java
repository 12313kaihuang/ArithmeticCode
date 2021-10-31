package Leetcode.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 500. 键盘行
 * <p>
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution500_1 {

    static Set<Character>[] sets = new Set[3];
    static String row1 = "qwertyuiop";
    static String row2 = "asdfghjkl";
    static String row3 = "zxcvbnm";

    static {
        sets[0] = new HashSet<>();
        for (char c : row1.toCharArray()) sets[0].add(c);
        sets[1] = new HashSet<>();
        for (char c : row2.toCharArray()) sets[1].add(c);
        sets[2] = new HashSet<>();
        for (char c : row3.toCharArray()) sets[2].add(c);
    }

    /**
     * 简单信息检索
     */
    public String[] findWords(String[] words) {
        List<String> ret = new ArrayList<>();
        for (String s : words) {
            char[] s1 = s.toLowerCase().toCharArray();
            for (Set<Character> set : sets) {
                if (set.contains(s1[0])) {
                    boolean find = true;
                    for (int j = 1; j < s1.length; j++) {
                        if (!set.contains(s1[j])) {
                            find = false;
                            break;
                        }
                    }
                    if (find) ret.add(s);
                }
            }
        }
        return ret.toArray(new String[0]);
    }

    static int[] ROW_IDS = new int[]{
            1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2
    };

    /**
     * 换个思路，直接存储每个字母所在的行数，然后进行匹配
     */
    public String[] findWords2(String[] words) {
        List<String> ret = new ArrayList<>();
        for (String s : words) {
            char[] chars = s.toLowerCase().toCharArray();
            int row = ROW_IDS[chars[0] - 'a'];
            boolean format = true;
            for (int i = 1; i < chars.length; i++) {
                format = row == ROW_IDS[chars[i] - 'a'];
                if (!format) break;
            }
            if (format) ret.add(s);
        }
        return ret.toArray(new String[0]);
    }
}
