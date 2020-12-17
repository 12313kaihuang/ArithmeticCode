package Leetcode.code;

/**
 * 714. 买卖股票的最佳时机含手续费
 * <p>
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution714_1 {

    /**
     * 一般的动态规划题目思路三步走：
     * 1. 定义状态转移方程
     * 2. 给定转移方程初始值
     * 3. 写代码递推实现转移方程
     */

    /**
     * 有手续费，所以不能用贪心，不太理解 = =
     * 使用动态规划，见
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/jian-dan-dpmiao-dong-gu-piao-mai-mai-by-tejdo/
     * 讲的很明白。
     * <p>
     * 设：
     * f(i)[0] = 第i天不持有股票的最大利润
     * f(i)[1] = 第i天持有股票的最大利润
     * <p>
     * 则有：
     * f(i)[0] = max(f(i-1)[0],f(i-1)[1] + prices[i] - fee)
     * f(i)[1] = max(f(i-1)[1],f(i-1)[0] - prices[i])
     * <p>
     * f(0)[0] = 0
     * f(0)[1] = -prices[0]
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] result = new int[prices.length][2];
        result[0][0] = 0;
        result[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] + prices[i] - fee);
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] - prices[i]);
        }
        return result[prices.length - 1][0]; //返回最后一天不持有股票的最大利润
    }


    public static void main(String[] args) {
        System.out.println(new Solution714_1().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}

