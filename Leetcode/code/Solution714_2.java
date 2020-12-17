package Leetcode.code;

public class Solution714_2 {

    /**
     * 其实实际用到的只有相邻两天的数据，
     * 二维数组有点浪费
     */
    public int maxProfit(int[] prices, int fee) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = result[0];
            result[0] = Math.max(result[0], result[1] + prices[i] - fee);
            result[1] = Math.max(result[1], temp - prices[i]);
        }
        return result[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution714_2().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
