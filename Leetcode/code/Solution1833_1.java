package Leetcode.code;


/**
 * 1833. 雪糕的最大数量
 * <p>
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
 * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 * 示例 1：
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * <p>
 * 示例 2：
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * <p>
 * 示例 3：
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 * <p>
 * 提示：
 * costs.length == n
 * 1 <= n <= 10^5
 * 1 <= costs[i] <= 10^5
 * 1 <= coins <= 10^8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1833_1 {

    /**
     * 核心思路应该就是先排序再计算
     */
    public int maxIceCream(int[] costs, int coins) {
//        Arrays.sort(costs); method 1
//        bubbleSort(costs);
        quickSort(costs, 0, costs.length - 1);
        int count = 0;
        for (int cost : costs) {
            if ((coins -= cost) >= 0) count++;
            else break;
        }
        return count;
    }

    //排序效果不理想  暴力计数空间换时间
    public int maxIceCream2(int[] costs, int coins) {
        int[] counts = new int[10_0001];
        for (int cost : costs) counts[cost]++;
        int count = 0;
        for (int i = 1; i < counts.length && coins >= i; i++) {
            int c = Math.min(coins / i, counts[i]);
            coins -= i * c;
            count += c;
        }
        return count;
    }

    //超时了还？？
    private void bubbleSort(int[] costs) {
        int k = costs.length - 1, pos = 0;
        for (int i = 0; i < costs.length - 1; i++) {
            boolean noChange = false;
            for (int j = 0; j < k; j++) {
                if (costs[j] > costs[j + 1]) {
                    int temp = costs[j];
                    costs[j] = costs[j + 1];
                    costs[j + 1] = temp;
                    pos = j;
                    noChange = true;
                }
            }
            k = pos; //记录本次循环最后一次交换的数的位置，及本次循环后，pos之后的数都是排好序的了
            if (!noChange) return;
        }
    }

    //效果也不是很理想啊
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int l = start, r = end;
        int base = nums[(start + end) / 2];
        while (l <= r) {
            while (l <= r && nums[l] < base) l++;
            while (l <= r && nums[r] > base) r--;
            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        quickSort(nums, start, r);
        quickSort(nums, l, end);
    }

}
