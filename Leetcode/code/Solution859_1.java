package Leetcode.code;

/**
 * 859. 亲密字符串
 * <p>
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回true；
 * 否则返回 false 。交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，
 * 接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * 示例 1：
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * <p>
 * 示例 2：
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * <p>
 * 示例 3：
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * <p>
 * 示例 4：
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution859_1 {

    //todo 示例3过不了
    public boolean buddyStrings(String s, String goal) {
        int a = -1, b = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (a < 0) a = i;
                else if (b < 0) b = i;
                else return false;
            }
        }
        return a != b;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/buddy-strings/solution/qin-mi-zi-fu-chuan-by-leetcode-solution-yyis/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean buddyStrings2(String s, String goal) {
        //  长度要一致
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            //如果两个字符串相同，若有重复的字符，则可以实现交换变成goal
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }
            //找到不一样的位置还需要满足s[i]=g[j],s[j]=g[i]才行
            return (second != -1 && s.charAt(first) == goal.charAt(second) &&
                    s.charAt(second) == goal.charAt(first));
        }
    }


    /**
     * 简洁版,算是另一种思路
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/buddy-strings/solution/gong-shui-san-xie-jian-dan-zi-fu-chuan-m-q056/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean buddyStrings3(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (n != m) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++;
            cnt2[b]++;
            if (a != b) sum++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
            if (cnt1[i] > 1) ok = true;
        }
        return sum == 2 || (sum == 0 && ok);
    }

}
