package Leetcode.code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * <p>
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1047_1 {

    /**
     * 位置好找，删除之后重组字符串暂时没有找到什么好的方法
     * 所以直接使用一个哈希表记录一下需要删除的字符位置
     * <p>
     * 循环结束条件和指针移动是关键
     */
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int cur = 0, next = 1, len = chars.length;
        Set<Integer> rvSet = new HashSet<>();
        while (cur < len - 1 && next < len) {
            //System.out.println(cur + "," + next);
            if (chars[cur] == chars[next]) {
                rvSet.add(cur);
                rvSet.add(next);
                int temp = cur;
                while (temp >= 0) { //往前找第一个没被删除的数
                    if (!rvSet.contains(temp)) break;
                    temp--;
                }
                if (temp >= 0) { //找到了
                    cur = temp;
                    next++;
                } else { //没找到说明前面的数都被删除了，都往后移
                    cur = next + 1;
                    next += 2;
                }
            } else {
                cur = next++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (!rvSet.contains(i)) {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1047_1().removeDuplicates("aabc"));
        System.out.println(new Solution1047_1().removeDuplicates("abbaca"));
        System.out.println(new Solution1047_1().removeDuplicates("acbbcacca"));
        System.out.println(new Solution1047_1().removeDuplicates("ibfjcaffccadidiaidchakchchcahabhibdcejkdkfbaeeaecdjhajbkfebebfea"));
    }
}
