package Leetcode.code;

/**
 * 387. 字符串中的第一个唯一字符
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution387_1 {

    /**
     * 想到了用哈希表计数，但是卡在了怎么获得第一个，
     * = . =
     */
    public int firstUniqChar(String s) {
        int[] nums = new int[26];
        char[] chars = s.toCharArray();
        for (Character c : chars) nums[c - 'a']++;
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
