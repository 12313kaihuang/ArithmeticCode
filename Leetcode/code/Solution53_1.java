package Leetcode.code;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution53_1 {

    //动态规划
    public int maxSubArray(int[] nums) {
        int cur = 0, max = nums[0];
        for (int num : nums) {
            cur = Math.max(cur + num, num);
            max = Math.max(cur, max);
        }
        return max;
    }
}
