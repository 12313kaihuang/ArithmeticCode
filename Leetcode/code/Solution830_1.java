package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 * <p>
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
 * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 * 示例1：
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * <p>
 * 示例 2：
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * <p>
 * 示例 3：
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * <p>
 * 示例 4：
 * 输入：s = "aba"
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution830_1 {

    /**
     * 思路比较简单，遍历数组，start为重复字符开始下标，
     * end为结束下标，当start值发生变化时，判定上一个区间是否满足条件
     * 若满足则加入result中。
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了70.11%的用户
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[start]) {
                end = i;
            } else {
                if (end - start >= 2) addResult(result, start, end);
                start = i;
            }
        }
        if (end - start >= 2) addResult(result, start, end);
        return result;
    }

    private void addResult(List<List<Integer>> result, int start, int end) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        result.add(list);
    }

    public static void main(String[] args) {
        System.out.println(new Solution830_1().largeGroupPositions("abbxxxxzzy"));
        System.out.println(new Solution830_1().largeGroupPositions("abc"));
        System.out.println(new Solution830_1().largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(new Solution830_1().largeGroupPositions("aba"));
    }
}
