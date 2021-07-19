package Leetcode.code;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * <p>
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * <p>
 * 示例 3：
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1838_1 {

    /**
     * 排序 + 滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/solution/zui-gao-pin-yuan-su-de-pin-shu-by-leetco-q5g9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);  //使用long应该是害怕数据溢出
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    //失败
    public int maxFrequencyError(int[] nums, int k) {
        Arrays.sort(nums);
        //动态规划？
        //cost当前花费的操作数 count当前最大频数
        int res = 1;
        int start = 0, cost = 0, count = 1, max = nums[0];
        for (int i = 1; i < nums.length && cost <= k; ) {
            //全部变为nums[i]需要花费的步数
            int expect = (nums[i] - max) * (i - start);
            if (cost + expect <= k) {
                cost += expect;
                count++;
                max = nums[i++];
//                System.out.println("res = max(" + res + ", " + count + ")");
                res = Math.max(res, count);
            } else {
//                System.out.println("res = max(" + res + ", " + count + ")");
                res = Math.max(res, count);
                max = nums[i];
                cost -= (nums[i - 1] - nums[start]);
                start++;
                count--;
            }
        }
//        System.out.println("max is " + max);
        return res;
    }

    //对比maxFrequencyError 对比官方题解，其实就是滑动窗口
    public int maxFrequency2(int[] nums, int k) {
        Arrays.sort(nums);
        //cost当前花费的操作数 count当前最大频数
        int res = 1;
        int start = 0, cost = 0;/*, count = 1 count其实就是i-start+1, max = nums[0] max其实就是nums[i - 1]*/
        for (int i = 1; i < nums.length && cost <= k; ) {
            //全部变为nums[i]需要花费的步数
            int expect = (nums[i] - nums[i - 1]) * (i - start);
            if (cost + expect <= k) {
                cost += expect;
                res = Math.max(res, i - start + 1);
                ++i;
            } else {
                cost -= (nums[i - 1] - nums[start]);
                start++;
            }
        }
        return res;
    }

    //maxFrequency2再精简
    public int maxFrequency3(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, len = nums.length;
        int start = 0, cost = 0; //cost当前花费的操作数
        for (int i = 1; i < len; i++) {
            //全部变为nums[i]需要花费的步数
            cost += (nums[i] - nums[i - 1]) * (i - start);
            while (cost > k) cost -= nums[i] - nums[start++]; //这里细节需要注意
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1838_1().maxFrequency(new int[]{1, 2, 4}, 5));
//        System.out.println(new Solution1838_1().maxFrequency(new int[]{3, 9, 6}, 2));
//        System.out.println(new Solution1838_1().maxFrequency(new int[]{1, 4, 8, 13}, 5));
//        System.out.println(new Solution1838_1().maxFrequency(new int[]{1, 2, 3, 14, 3}, 1));
        System.out.println(new Solution1838_1().maxFrequency(new int[]{1, 5, 6, 7, 9}, 3));
    }
}
