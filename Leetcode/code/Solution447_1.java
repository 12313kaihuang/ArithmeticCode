package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * <p>
 * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，
 * 其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution447_1 {

    /**
     * 官方题解 枚举+哈希
     * <p>
     * 题目所描述的回旋镖可以视作一个 V 型的折线。我们可以枚举每个 points[i]，将其当作 V 型的拐点。
     * 设 points 中有 mm 个点到 points[i] 的距离均相等，我们需要从这 m 点中选出 2 个点
     * 当作回旋镖的 2 个端点，由于题目要求考虑元组的顺序，因此方案数即为在 m 个元素中选出 2 个不同元素
     * 的排列数，即：A_m^2 =m⋅(m−1)
     * <p>
     * 据此，我们可以遍历 points，计算并统计所有点到 points[i] 的距离，将每个距离的出现次数记录在哈希表中，
     * 然后遍历哈希表，并用上述公式计算并累加回旋镖的个数。
     * 在代码实现时，我们可以直接保存距离的平方，避免复杂的开方运算。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/number-of-boomerangs/solution/hui-xuan-biao-de-shu-liang-by-leetcode-s-lft5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) { //以point作为拐点
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] p2 : points) {
                int dis = (p[0] - p2[0]) * (p[0] - p2[0]) + (p[1] - p2[1]) * (p[1] - p2[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int c = entry.getValue();
                //因为不会有重复的点，所以dis为0的情况只有1种，计算结果为0，所以加上也不影响结果
                ans += c * (c - 1);
            }
        }
        return ans;
    }
}
