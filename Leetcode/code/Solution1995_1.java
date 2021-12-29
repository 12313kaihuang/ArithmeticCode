package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 1995. 统计特殊四元组
 * <p>
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 * <p>
 * 提示：
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1995_1 {

    /**
     * nums[a] + nums[b] + nums[c] == nums[d] ->
     * nums[a] + nums[b]  == nums[d] - nums[c]
     * 使用hash表存储nums[d] - nums[c]
     */
    public int countQuadruplets(int[] nums) {
        int ans = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                int key = nums[d] - nums[b + 1];
                map.put(key, map.getOrDefault(key, 0) + 1);  //这句有点难理解，跟着例子走一边又能理解
            }
            for (int a = 0; a < b; a++) {
                ans += map.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return ans;
    }
}
