package Leetcode.code;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * <p>
 * 示例 3：
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -100 <= nums[i] <= 100
 * 1 <= k <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1005_1 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int minusNums = (int) Arrays.stream(nums).filter(num -> num < 0).count();
        System.out.println("minusNum = " + minusNums);
        Arrays.sort(nums);
        if (minusNums >= k) {
            //负数个数大于k，则把最小的k个数取反
            for (int i = 0; i < k; i++) {
                nums[i] = -nums[i];
            }
        } else {
            //负数个数小于k，先将所有负数取反
            for (int i = 0; i < minusNums; i++) {
                nums[i] = -nums[i];
            }
            Arrays.sort(nums); //重新排序
            int last = (k - minusNums) % 2;  //剩余需要取反次数
            if (last == 1) nums[0] = -nums[0];
        }
        return Arrays.stream(nums).sum();
    }


    //逻辑优化
    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        int minusNums = (int) Arrays.stream(nums).filter(num -> num < 0).count();
        int n = Math.min(minusNums, k);
        //先尽可能把所有负数取反
        for (int i = 0; i < n; i++) nums[i] = -nums[i];
        n = (k - minusNums) % 2; //这里注意一定是k-minus
        if (n == 1) {
            //此时nums一定全为正数，所以取反一个最小数即可
            //而最小数一定再nums[minusNums]附近
            if (minusNums == 0) {
                n = minusNums;
            } else if (minusNums == nums.length) {
                n = minusNums - 1;
            } else {
                n = nums[minusNums] > nums[minusNums - 1] ? minusNums - 1 : minusNums;
            }
            nums[n] = -nums[n];
        }
        return Arrays.stream(nums).sum();
    }

    public int largestSumAfterKNegations3(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //尽可能把所有负数取反
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        if (k % 2 == 1) {
            //取反最小数
            sum -= (2 * min);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(-1 % 2);
    }
}
