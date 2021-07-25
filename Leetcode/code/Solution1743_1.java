package Leetcode.code;

import java.util.*;

/**
 * 1743. 从相邻元素对还原数组
 * <p>
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。
 * 好在你还记得 nums 中的每一对相邻元素。给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，
 * 其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * <p>
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，
 * 存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。
 * 这些相邻元素对可以 按任意顺序 出现。
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * <p>
 * 示例 1：
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * <p>
 * 示例 2：
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * <p>
 * 示例 3：
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 * <p>
 * 提示：
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 10^5
 * -10^5 <= nums[i], ui, vi <= 10^5
 * 题目数据保证存在一些以adjacentPairs 作为元素对的数组 nums
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1743_1 {

    /**
     * adjacentPairs = [[2,1],[3,4],[3,2]]
     * <p>
     * 因为无重复数字，所以开头和结尾的数只会出现1次，其余数仅出现2次
     * 根据题目要求，若a开头b结尾，那么将数组翻转返回同样可以满足要求，
     * 即a b开头均可以，那么先找出任意一个开头的元素，然后根绝存储的与之相邻的元素
     * 挨个取出即可。
     * <p>
     * 可以参考官方题解:
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/solution/cong-xiang-lin-yuan-su-dui-huan-yuan-shu-v55t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        int size = map.size();
        int[] res = new int[size];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[0] = entry.getKey();
                break;
            }
        }

        for (int i = 0; i < size - 1; i++) {
            List<Integer> list = map.get(res[i]);
            System.out.println(res[i] + "," + list);
            if (list.size() == 1) res[i + 1] = list.get(0);
            else if (list.get(0) == res[i - 1]) res[i + 1] = list.get(1);
            else res[i + 1] = list.get(0);
        }
        return res;
    }
}
