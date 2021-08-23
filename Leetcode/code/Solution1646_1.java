package Leetcode.code;

import java.util.Arrays;

/**
 * 1646. 获取生成数组中的最大值
 * <p>
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 * 示例 1：
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 * <p>
 * 示例 3：
 * 输入：n = 3
 * 输出：2
 * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 * <p>
 * 提示：
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1646_1 {

    static int[] sNums = new int[101];

    static {
        sNums[0] = 0;
        sNums[1] = 1;
        for (int n = 2; n < 101; n++) {
            int i = n >> 1;
            if ((n & 1) == 0) sNums[n] = sNums[i];
            else sNums[n] = sNums[i] + sNums[i + 1];
        }
    }

    /**
     * 是求最大值，所以应该是需要全部算一边才行,
     * 利用映射表实现
     */
    public int getMaximumGenerated(int n) {
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, sNums[i]);
        }
        return max;
    }

    //两种情况可以合并为一个表达式
    public int getMaximumGenerated2(int n) {
        if (n <= 1) return n;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i >> 1] + nums[i % 2] * nums[(i >> 1) + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
