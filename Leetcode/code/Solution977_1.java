package Leetcode.code;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按 非递减顺序 排序
 * <p>
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution977_1 {

    /**
     * 双指针+倒序插入
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    //双指针
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = 0; //nums[j] >= 0
        while (j < n && nums[j] < 0) ++j;
        int k = j - 1; //nums[k] < 0
        while (j < n && k >= 0) {
            int p;
            if (nums[j] + nums[k] > 0) {
                p = k--;
            } else {
                p = j++;
            }
            ans[i++] = nums[p] * nums[p];
        }
        for (; j < n; j++) ans[i++] = nums[j] * nums[j];
        for (; k >= 0; k--) ans[i++] = nums[k] * nums[k];
        return ans;
    }

    //优化？？
    public int[] sortedSquares2(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = 0; //nums[j] >= 0
        while (j < nums.length && nums[j] < 0) ++j;
        int k = j - 1; //nums[k] < 0
        while (j < nums.length && k >= 0) {
            if (nums[j] + nums[k] > 0) {
                ans[i++] = nums[k] * nums[k];
                --k;
            } else {
                ans[i++] = nums[j] * nums[j];
                ++j;
            }
        }
        for (; j < nums.length; j++) ans[i++] = nums[j] * nums[j];
        for (; k >= 0; k--) ans[i++] = nums[k] * nums[k];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution977_1().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new Solution977_1().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(new Solution977_1().sortedSquares(new int[]{-7, -3, 0, 2, 3, 11})));
    }
}
