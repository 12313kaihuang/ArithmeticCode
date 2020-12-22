package Leetcode.code;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * 数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * <p>
 * 示例 2:
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * <p>
 * 注意：
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution746_1 {

    /**
     * 动态规划:
     * f(0) = 0
     * f(1) = cost[0]
     * f(n) = min(f(n-1),f(n-2)) + cost[n]
     * <p>
     * result = min(f(len-1),f(len-1));
     * 题感觉挺简单，但是转移方程感觉有点绕，花了点时间。
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = 1;
        int a = 0, b = cost[0];
        while (n < cost.length) {
            int temp = b;
            b = Math.min(a, b) + cost[n];
            a = temp;
            n++;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println(new Solution746_1().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new Solution746_1().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
