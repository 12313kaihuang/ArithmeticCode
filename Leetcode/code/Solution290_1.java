package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution290_1 {

    //利用map存储键值对
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] split = s.split(" ");
        if (pattern.length() != split.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!split[i].equals(map.get(c))) return false;
            } else {
                if (map.containsValue(split[i])) return false; //value也不能重复，见示例4
                map.put(c, split[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution290_1().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution290_1().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution290_1().wordPattern("abba", "dog dog dog dog"));
    }
}
