package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * <p>
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution697_1 {

    /**
     * 官方题解的代码，
     * 思路看https://leetcode-cn.com/problems/degree-of-an-array/solution/xiang-xi-fen-xi-ti-yi-yu-si-lu-jian-ji-d-nvdy/
     * 可能会更容易懂，大体思路差不多
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                //共出现的次数  第一次出现的位置 最后一次出现的位置
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        //数组的度 最长子数组长度
        int degree = 0, minLen = 0;
        //核心在于 最短子数组的起始和终止位置，由出现次数最多的元素 第一次和最后一次出现的位置 确定。
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (degree < arr[0]) {
                degree = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (degree == arr[0]) {
                //对所有出现次数等于degree的子数组的最短长度，取 min。 即最短连续子数组
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}
