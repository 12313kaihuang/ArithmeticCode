package Leetcode.code;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution14_1 {

    //自己匹配
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        boolean finish = false;
        while (!finish) {
            char c = 'A';
            for (String str : strs) {
                if (i >= str.length()) finish = true;
                else if (c < 'a') c = str.charAt(i);
                else if (c != str.charAt(i)) finish = true;
                if (finish) break;
            }
            if (!finish) i++;
        }
        return strs[0].substring(0, i);
    }

    //另一种解法
    public String longestCommonPrefix2(String[] strs) {
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            while (index < ans.length()
                    && index < strs[i].length()
                    && ans.charAt(index) == strs[i].charAt(index)) index++;
            ans = ans.substring(0, index);
            if (ans.equals("")) return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("a".substring(0, 1));
        System.out.println("a".substring(0, 0));
    }
}
