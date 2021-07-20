package Leetcode.code;

/**
 * 1877. 数组中最大数对和的最小值
 * <p>
 * 一个数对(a,b)的 数对和等于a + b。最大数对和是一个数对数组中最大的数对和。
 * <p>
 * 比方说，如果我们有数对(1,5)，(2,3)和(4,4)，最大数对和为max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8。
 * 给你一个长度为 偶数n的数组nums，请你将 nums中的元素分成 n / 2个数对，使得：
 * nums中每个元素恰好在 一个数对中，且最大数对和的值 最小。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和。
 * <p>
 * 示例 1：
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,5,4,2,4,6]
 * 输出：8
 * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 * <p>
 * 提示：
 * n == nums.length
 * 2 <= n <= 10^5
 * n是 偶数。
 * 1 <= nums[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1877_1 {

    //题意感觉没发觉完，先按第一印象来，先排序试试
    public int minPairSum(int[] nums) {
//        Arrays.sort(nums);
        int sum = 0, l = 0, r = nums.length - 1;
        quickSort(nums, l, r);
        while (l < r) sum = Math.max(sum, nums[l++] + nums[r--]); //这是一种贪心策略？
        return sum;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int prev = nums[(start + end) / 2];
        int l = start, r = end;
        while (l <= r) {
            while (l <= r && nums[l] < prev) l++;
            while (l <= r && nums[r] > prev) r--;
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

    public static void main(String[] args) {
        System.out.println(new Solution1877_1().minPairSum(new int[]{3, 5, 2, 3}));
//        System.out.println(new Solution1877_1().minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }
}
