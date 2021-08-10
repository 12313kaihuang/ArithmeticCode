package Leetcode.code;

/**
 * 413. 等差数列划分
 * <p>
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution413_1 {

    /**
     * 滑动窗口
     * <p>
     * 注意细节
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int len = nums.length;
        int left = 0, right, diff, sum = 0;
        while (left < len - 2) {
            if (nums[left + 2] - nums[left + 1] != nums[left + 1] - nums[left]) {
                left++;
                continue;
            }
            right = left + 2;
            diff = nums[left + 1] - nums[left];
            while (right < len - 1 && nums[right + 1] - nums[right] == diff) right++;
//            System.out.println(String.format("left:%d right:%d", left, right));
            sum += (right - left) * (right - left - 1) / 2; //calculateCount(left, right);
            left = right; //这里不+1是因为本数组末可能会成为下一个子数组的头
        }
        return sum;
    }

    /**
     * 取x=right - left，则有
     * f(2) = 1
     * f(3) = 1 + 2 = 3
     * f(4) = 1 + 2 + 3 = 6
     * f(5) = 1 + 2 + 3 + 4 = 10
     * ...
     * f(x) = 1 + 2 + ... + (x - 1) = x * (x - 1)/2
     */
    private int calculateCount(int left, int right) {
        if (right - left == 2) return 1;//长度为3
        return (right - left) * (right - left - 1) / 2;
    }

    /**
     * 官方题解
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/arithmetic-slices/solution/deng-chai-shu-lie-hua-fen-by-leetcode-so-g7os/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution413_1().numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
//        System.out.println(new Solution413_1().numberOfArithmeticSlices(new int[]{2, 1, 3, 4, 2, 3}));
        System.out.println(new Solution413_1().numberOfArithmeticSlices(new int[]{1, 2, 3, 5, 7}));
    }
}
