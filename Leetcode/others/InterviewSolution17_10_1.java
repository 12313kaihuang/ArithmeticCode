package Leetcode.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 * <p>
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InterviewSolution17_10_1 {


    //空间复杂度貌似不达标
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int maxNum = nums[0], maxCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            if (count > maxCount) {
                maxNum = num;
                maxCount = count;
            }
            countMap.put(num, count);
        }
        return maxCount * 2 > nums.length ? maxNum : -1;
    }

    /**
     * 优化版本
     */
    public int majorityElement3(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int c = countMap.getOrDefault(num, 0) + 1;
            if (c > len / 2) return num;
            countMap.put(num, c);
        }
        return -1;
    }

    /**
     * 摩尔投票：在每一轮投票过程中，从数组中删除两个不同的元素，直到投票过程无法继续，
     * 此时数组为空或者数组中剩下的元素都相等。
     * <p>
     * 遇到相同的数则将 count 加 11，遇到不同的数则将 count 减 11。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci/solution/zhu-yao-yuan-su-by-leetcode-solution-xr1p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int majorityElemen2(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            if (num == candidate) count++;
            else count--;
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == candidate) count++;
        }
        return count * 2 > length ? candidate : -1;
    }

    public static void main(String[] args) {
//        System.out.println(new InterviewSolution17_10_1().majorityElement(new int[]{1, 2, 3}));
        System.out.println(new InterviewSolution17_10_1().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
