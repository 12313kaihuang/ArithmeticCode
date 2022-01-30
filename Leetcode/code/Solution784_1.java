package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * <p>
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回所有可能得到的字符串集合。
 * <p>
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345"
 * 输出：["12345"]
 * <p>
 * 提示：
 * S的长度不超过12。
 * S仅由数字和字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution784_1 {

    /**
     * 递归
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation/solution/zi-mu-da-xiao-xie-quan-pai-lie-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder()); //注意这里提前放了一个
        for (char c : s.toCharArray()) {
            int n = ans.size();
            //如果下一个字符 c 是字母，将当前已遍历过的字符串全排列复制两份，
            // 在第一份的每个字符串末尾添加 lowercase(c)，在第二份的每个字符串末尾添加 uppercase(c)。
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                //如果下一个字符 c 是数字，将 c 直接添加到每个字符串的末尾。
                for (StringBuilder an : ans) an.append(c);
            }
        }
        List<String> finalans = new ArrayList<>();
        for (StringBuilder sb : ans) finalans.add(sb.toString());
        return finalans;
    }

    /**
     * 二分掩码
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation/solution/zi-mu-da-xiao-xie-quan-pai-lie-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<String> letterCasePermutation2(String S) {
        int B = 0;
        for (char c : S.toCharArray())
            if (Character.isLetter(c))
                B++;

        List<String> ans = new ArrayList<>();
        for (int bits = 0; bits < 1 << B; bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter : S.toCharArray()) {
                if (Character.isLetter(letter)) {
                    if (((bits >> b++) & 1) == 1)
                        word.append(Character.toLowerCase(letter));
                    else
                        word.append(Character.toUpperCase(letter));
                } else {
                    word.append(letter);
                }
            }
            ans.add(word.toString());
        }
        return ans;
    }

}
