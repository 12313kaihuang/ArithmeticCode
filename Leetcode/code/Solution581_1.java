package Leetcode.code;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * <p>
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution581_1 {

    /**
     * 官方题解1
     * <p>
     * 将数组分为A、B、C三部分，B为所求部分，复制一份数组并升序排序，
     * 则新数组和原数组A、C部分一定是相同的，找出A、C，那么B就可以通过计算得出
     * <p>
     * 作者：LeetCode-Solution
     * * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
     * * 来源：力扣（LeetCode）
     * * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        //拷贝一份并升序排序
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int len = nums.length, start = 0, end = len - 1;
        //从前向后找出两个数组对应位置值相同的最后一个数的位置 + 1
        while (start < len && nums[start] == sorted[start]) start++;
        while (end >= 0 && nums[end] == sorted[end]) end--;
        //若存在需排序数组，此时s的位置应为带排序数组的起始位置，e位于结束位置
        return end >= start ? end - start + 1 : 0;
    }

    /**
     * 官方题解2
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE, right = -1;
        int min = Integer.MAX_VALUE, left = -1;
        //有点玄学
        for (int i = 0; i < len; i++) {
            //从前向后找右边界，C中的数一定都是大于B中的数的
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
            if (min < nums[len - i - 1]) {
                left = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return right >= 0 ? right - left + 1 : 0; //这里也有讲究
    }
}
