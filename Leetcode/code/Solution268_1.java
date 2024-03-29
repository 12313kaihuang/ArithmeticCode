package Leetcode.code;

import java.util.Arrays;

/**
 * 268. 丢失的数字
 * <p>
 * 给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 * <p>
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution268_1 {


    //排序
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    public int missingNumber(int[] nums) {
        //也可通过hash表实现
        int[] rets = new int[nums.length + 1];
        Arrays.fill(rets, 0);
        for (int num : nums) rets[num]++;
        System.out.println(Arrays.toString(rets));
        for (int i = 0; i < rets.length; i++) {
            if (rets[i] == 0) return i;
        }
        return -1;
    }

    /**
     * 数学计算！！
     * 0-n的和是可以算出来的，然后减去nums中所有值就知道少了哪个
     */
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int sum = (1 + n) * n / 2;
        for (int num : nums) sum -= num;
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Solution268_1().missingNumber(new int[]{3, 0, 1}));
    }
}
